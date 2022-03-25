package com.runninggo.toy.controller;

import com.runninggo.toy.domain.MemberDto;
import com.runninggo.toy.service.MemberService;
import com.runninggo.toy.validator.IdCheckValidator;
import com.runninggo.toy.validator.PwCheckValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class MemberController {

    @Autowired
    MemberService memberService;
    @Autowired
    PwCheckValidator pwValidator;
    @Autowired
    IdCheckValidator idCheckValidator;

    @InitBinder
    public void validator(WebDataBinder binder) {
        binder.addValidators(pwValidator);
        binder.addValidators(idCheckValidator);
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "/member/loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "/member/joinForm";
    }

    @PostMapping("/joinCheck")
    public String joinCheck(@Valid MemberDto memberDto, Errors errors, Model model) throws Exception{

        //작성한 정보를 유지하고, joinSuccessForm에 name전송하기 위함.
        model.addAttribute("memberDto", memberDto);

        //만약 회원가입에 실패한다면
        if (errors.hasErrors()) {
            //유효성 검사에 실패하면 작성중이던 폼 그대로 유지
            return "/member/joinForm";
        }

        //유효성 검사를 통과하면 insert 후 페이지 이동
        memberService.insertMember(memberDto);
        return "/member/joinSuccessForm";
    }

    @GetMapping("/registerEmail")
    public String emailConfirm(String email,Model model)throws Exception{
        memberService.updateMailAuth(email);
        model.addAttribute("member_mail", email);

        return "/member/joinSuccessForm";
    }

    @PostMapping("/login")
    public String login(String id, String pass, boolean saveId,
                        HttpServletResponse response, HttpSession session, Model model) {

        MemberDto memberDto = new MemberDto();

        memberDto.setId(id);
        memberDto.setPass(pass);

        int result = memberService.login(memberDto);

        if(result != 1){
            model.addAttribute("loginFailMsg", "아이디 또는 비밀번호가 올바르지 않습니다.");
            return "/member/loginForm";
        }

        //result가 1이면(id, pass가 일치하면) saveId값을 체크해서 쿠키를 만들거나 삭제한다.
        session.setAttribute("id", id);
        session.setAttribute("loginOK", "yes");

        if (saveId){
            Cookie cookie = new Cookie("id", id); //1. 쿠키생성
            response.addCookie(cookie); //2. 응답에 저장
        } else {
            Cookie cookie = new Cookie("id", id);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        return "redirect:/"; //3. 홈으로 이동
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); //세션 종료
        return "redirect:/";
    }

    //login id, pass check
    @ResponseBody
    @PostMapping("/loginCheck")
    public int loginCheck(MemberDto memberDto, Model model) {
        model.addAttribute("msg", "ajaxfail");
        return memberService.login(memberDto);
    }

    //id 중복 체크
    @ResponseBody
    @PostMapping("/idCheck")
    public int idCheck(String id) {
        return memberService.idCheck(id);
    }
}

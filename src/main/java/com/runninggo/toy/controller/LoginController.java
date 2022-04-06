package com.runninggo.toy.controller;

import com.runninggo.toy.domain.MemberDto;
import com.runninggo.toy.service.MemberService;
import com.runninggo.toy.validator.LoginCheckValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    MemberService memberService;

    @Autowired
    LoginCheckValidator loginCheckValidator;

    @InitBinder
    public void validator(WebDataBinder binder) {
        binder.setValidator(loginCheckValidator);
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "/member/loginForm";
    }

    @PostMapping("/login")
    public String login(@Valid MemberDto memberDto, Errors errors, String id,  boolean saveId,
                        HttpServletResponse response, HttpSession session) throws Exception {

        if (errors.hasErrors()) {
            return "/member/loginForm";
        }

        //이메일 인증 했는지 확인
        if (memberService.emailAuthFail(id) != 1) {
            return "/member/emailAuthFail";
        }

        //id, pass가 일치하고, 이메일 인증 했으면 세션을 생성하고, saveId 값을 체크해서 쿠키를 만들거나 삭제한다.
        session.setAttribute("id", id);
        session.setAttribute("loginOK", "yes");

        Cookie cookie = new Cookie("id", id); //1. 쿠키생성
        if (saveId){
            response.addCookie(cookie); //2. 응답에 저장
        } else {
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

    @GetMapping("/findIdForm")
    public String findIdForm() {
        return "/member/findIdForm";
    }

    @PostMapping("/findId")
    public String findId(MemberDto memberDto, Model model) throws Exception{
        List<MemberDto> idList = memberService.findId(memberDto);
        model.addAttribute("idList", idList);
        return "/member/findIdResult";
    }

    @GetMapping("/findPassForm")
    public String findPassForm() {
        return "/member/findPassForm";
    }

    @PostMapping("/findPass")
    public String findPass(MemberDto memberDto, Model model) throws Exception {
        int count = memberService.findPass(memberDto);
        model.addAttribute("count", count);
        return "/member/findPassResult";
    }
}

package com.runninggo.toy.controller;

import com.runninggo.toy.domain.MemberDto;
import com.runninggo.toy.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    MemberService memberService;

    @GetMapping("/loginForm")
    public String loginForm() {
        return "/member/loginForm";
    }

    @PostMapping("/login")
    public String login(String id, String pass, boolean saveId,
                        HttpServletResponse response, HttpSession session, Model model) throws Exception {

        MemberDto memberDto = new MemberDto();

        memberDto.setId(id);
        memberDto.setPass(pass);
        //로그인 시 아이디, 비밀번호 일치여부 확인
        if(memberService.login(memberDto) != 1){
            model.addAttribute("loginFailMsg", "아이디 또는 비밀번호가 올바르지 않습니다.");
            return "/member/loginForm";
        }

        //이메일 인증 했는지 확인
        if (memberService.emailAuthFail(id) != 1) {
            return "/member/emailAuthFail";
        }

        //id, pass가 일치하고, 이메일 인증 했으면 saveId값을 체크해서 쿠키를 만들거나 삭제한다.
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

    @GetMapping("/findIdForm")
    public String findIdForm() {
        return "/member/findIdForm";
    }

    @PostMapping("/findId")
    public String findId(MemberDto memberDto, Model model) throws Exception{
        List<MemberDto> idList = memberService.findId(memberDto);
        model.addAttribute("idList", idList);
        return "/member/findIdList";
    }

    @GetMapping("/findPassForm")
    public String findPassForm() {
        return "/member/findPassForm";
    }

}

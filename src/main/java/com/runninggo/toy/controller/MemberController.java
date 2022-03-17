package com.runninggo.toy.controller;

import com.runninggo.toy.domain.MemberDto;
import com.runninggo.toy.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/login")
    public String login(Model m) {
        m.addAttribute("data", "로그인하실건가요?");
        return "/member/login";
    }

    @GetMapping("/join")
    public String join() {
        return "/member/join";
    }

    @PostMapping("/joinCheck")
    public String joinCheck(MemberDto memberDto) {
        memberService.insertMember(memberDto);
        return "redirect:/";
    }

    //id 중복 체크
    @ResponseBody
    @PostMapping("/idCheck")
    public int idCheck(String id) {
        return memberService.idCheck(id);
    }
}

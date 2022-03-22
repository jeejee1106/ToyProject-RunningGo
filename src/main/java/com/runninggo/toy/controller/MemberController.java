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
    public String joinCheck(@Valid MemberDto memberDto, Errors errors, Model model) {

        System.out.println("errors = " + errors);

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

    @PostMapping("/login")
    public String login(String id, String pass) {
        MemberDto memberDto = new MemberDto();

        memberDto.setId(id);
        memberDto.setPass(pass);

        int result = memberService.login(memberDto);

        if(result != 1){
            return "/member/loginForm";
        }
        return "redirect:/";
    }

    //id 중복 체크
    @ResponseBody
    @PostMapping("/idCheck")
    public int idCheck(String id) {
        return memberService.idCheck(id);
    }
}

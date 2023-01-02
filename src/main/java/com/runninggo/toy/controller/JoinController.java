package com.runninggo.toy.controller;

import com.runninggo.toy.domain.MemberDto;
import com.runninggo.toy.service.MemberService;
import com.runninggo.toy.validator.JoinCkValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/join")
public class JoinController {

    MemberService memberService;
    JoinCkValidator joinCkValidator;

    public JoinController(MemberService memberService, JoinCkValidator joinCkValidator) {
        this.memberService = memberService;
        this.joinCkValidator = joinCkValidator;
    }

    @InitBinder
    public void validator(WebDataBinder binder) {
        binder.setValidator(joinCkValidator);
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
        int result = memberService.insertMember(memberDto);
        if(result == 1){
//            try { //예외처리 더 고민해보기.
                memberService.sendJoinCertificationMail(memberDto); //인증메일 보내기
//            } catch (TaskRejectedException e) {
//                log.info("TaskRejectedException 발생={}", e.getStackTrace());
//            }
            return "/member/joinSuccessForm";
        }
        return "/member/joinForm";
    }

    @GetMapping("/registerEmail")
    public String emailConfirm(MemberDto memberDto)throws Exception{

        memberService.updateMailAuth(memberDto);

        return "/member/emailAuthSuccess";
    }

    //id 중복 체크
    @ResponseBody
    @PostMapping("/idCheck")
    public int idCheck(String id) {
        return memberService.idCheck(id);
    }

    //git push check
}

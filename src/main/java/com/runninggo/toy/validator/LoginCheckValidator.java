package com.runninggo.toy.validator;

import com.runninggo.toy.domain.MemberDto;
import com.runninggo.toy.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class LoginCheckValidator extends AbstractValidator<MemberDto>{

    private MemberService memberService;

    public LoginCheckValidator(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    protected void doValidate(MemberDto memberDto, Errors errors) throws Exception {
        //아이디와 비밀번호가 존재하는지 체크
        if (memberService.login(memberDto) != 1) {
            errors.reject("login.mismatch");
        }
    }
}

package com.runninggo.toy.validator;

import com.runninggo.toy.domain.MemberDto;
import com.runninggo.toy.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class LoginCheckValidator extends AbstractValidator<MemberDto>{

    @Autowired
    private MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    protected void doValidate(MemberDto memberDto, Errors errors) throws Exception {
        if (memberService.login(memberDto) != 1) {
            errors.reject("login.mismatch");
        }
    }
}

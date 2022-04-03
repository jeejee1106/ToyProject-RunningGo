package com.runninggo.toy.validator;

import com.runninggo.toy.domain.MemberDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class PwMtcCkValidator extends AbstractValidator<MemberDto>{

    @Override
    protected void doValidate(MemberDto dto, Errors errors) {
        if (!dto.getPass().equals(dto.getPassCheck())) {
            errors.rejectValue("passCheck", "pass.bad");
        }
    }
}

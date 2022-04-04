package com.runninggo.toy.validator;

import com.runninggo.toy.dao.MemberDao;
import com.runninggo.toy.domain.MemberDto;
import com.runninggo.toy.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class IdDuplCkValidator extends AbstractValidator<MemberDto>{

    @Autowired
    private MemberService memberService;

    @Override
    protected void doValidate(MemberDto dto, Errors errors) {
        //아이디 중복 체크
        if (memberService.idCheck(dto.getId()) == 1) {
            errors.rejectValue("id", "id.duplicate"); //필드, 에러코드
        }

        //비밀번호 일치하는지 체크
        if (!dto.getPass().equals(dto.getPassCheck())) {
            errors.rejectValue("passCheck", "pass.bad");
        }
    }
}

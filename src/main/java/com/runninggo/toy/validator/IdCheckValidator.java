package com.runninggo.toy.validator;

import com.runninggo.toy.dao.MemberDao;
import com.runninggo.toy.domain.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class IdCheckValidator extends AbstractValidator<MemberDto>{

    @Autowired
    private MemberDao memberDao;

    @Override
    protected void doValidate(MemberDto dto, Errors errors) {
        if (memberDao.idCheck(dto.getId()) == 1) {
            errors.rejectValue("id", "id.duplicate");
        }
    }
}

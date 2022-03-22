package com.runninggo.toy.validator;

import com.runninggo.toy.domain.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Slf4j
public abstract class AbstractValidator<T> implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(MemberDto.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        try {
            doValidate((T) target, errors);
        } catch (RuntimeException e) {
            log.error("유효성 검증 에러", e);
            throw e;
        }
    }

    protected abstract void doValidate(final T dto, final Errors errors);
}
package com.runninggo.toy.validator;

import com.runninggo.toy.domain.MemberDto;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Slf4j
public abstract class AbstractValidator<T> implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return MemberDto.class.isAssignableFrom(clazz); //clazz가 MemberDto 또는 그 자손인지 확인
    }

    @SneakyThrows
    @Override
    public void validate(Object target, Errors errors) {
//        try {
            doValidate((T) target, errors);
//        } catch (Exception e) {
//            log.error("유효성 검증 에러", e);
//        }
    }

    protected abstract void doValidate(final T dto, final Errors errors) throws Exception;
}
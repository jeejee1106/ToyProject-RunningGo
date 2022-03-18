//package com.runninggo.toy.validator;
//
//import com.runninggo.toy.domain.MemberDto;
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.Validator;
//
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class MemberValidator implements Validator {
//
//    private static final String idRegExp = "^[a-z0-9]{4,20}$";
//    private static final String passRegExp = "^[a-z0-9]{4,20}$";
//    private Pattern idPattern, passPattern;
//
//    public MemberValidator() {
//        idPattern = Pattern.compile(idRegExp);
//        passPattern = Pattern.compile(passRegExp);
//    }
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return MemberDto.class.equals(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        //원래는 instaceof로 target이 MemberDto인지 확인해야하는데, 위 supports메서드에서 이미 확인을 했기 때문에 여기선 굳이 안해줘도 된다.
//        MemberDto memberDto = (MemberDto) target;
//
//        //id 유효성 검사
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required");
//        Matcher idMatcher = idPattern.matcher(memberDto.getId());
//        if (!idMatcher.matches()) {
//            errors.rejectValue("id", "bad");
//        }
//
//        //pass 유효성 검사
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pass", "required");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passCheck", "required");
//        Matcher matcher = passPattern.matcher(memberDto.getPass());
//        if (!matcher.matches()) {
//            errors.rejectValue("pass", "bad");
//        }
//
////        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
////        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
////        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hp", "required");
//    }
//}

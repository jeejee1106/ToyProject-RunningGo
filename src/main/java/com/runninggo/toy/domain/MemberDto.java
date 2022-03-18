package com.runninggo.toy.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Getter
@Setter
public class MemberDto {

    @Pattern(regexp = "^[a-z0-9]{5,20}$", message = "5~20자의 영문 소문자, 숫자로 작성해주세요.")
    @NotBlank(message = "필수입력 항목입니다.")
    private String id;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,20}$", message = "8~20자의 영문 대소문자+숫자+특수문자 조합으로 설정해주세요.")
    @NotBlank(message = "필수입력 항목입니다.")
    private String pass;

//    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,20}$", message = "비밀번호가 일치하지 않습니다.")
    @NotBlank(message = "필수입력 항목입니다.")
    private String passCheck;

    @Pattern(regexp = "^[가-힣]{2,}$", message = "이름은 한글만 입력 가능합니다.")
    @NotBlank(message = "필수입력 항목입니다.")
    private String name;

    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-].+.[A-Za-z]{2,6}$", message = "이메일 형식이 올바르지 않습니다.")
    @NotBlank(message = "필수입력 항목입니다.")
    private String email;

    @NotBlank(message = "필수입력 항목입니다.")
    private String hp;

    private String area;

    private Date join_date;
}

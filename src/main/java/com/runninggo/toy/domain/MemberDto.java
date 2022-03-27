package com.runninggo.toy.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Getter
@Setter //없으면 NullPointException 터짐
public class MemberDto {

    @Pattern(regexp = "^[a-z0-9]{5,20}$", message = "5~20자의 영문 소문자, 숫자만 사용 가능합니다.")
    @NotBlank(message = "필수입력 항목입니다.")
    private String id;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,20}$", message = "8~20자의 영문 대소문자+숫자+특수문자를 사용하세요.")
    @NotBlank(message = "필수입력 항목입니다.")
    private String pass;

    @NotBlank(message = "필수입력 항목입니다.")
    private String passCheck;

    @Pattern(regexp = "^[가-힣]{2,}$", message = "이름은 한글만 입력 가능합니다.")
    @NotBlank(message = "필수입력 항목입니다.")
    private String name;

    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9-]+[.][A-Za-z]{2,6}$", message = "이메일 형식이 올바르지 않습니다.")
    @NotBlank(message = "필수입력 항목입니다.")
    private String email;

    @Pattern(regexp = "^01(?:0|1|[6-9])(-)(\\d{3}|\\d{4})(-)(\\d{4})$", message = "휴대폰 번호 형식이 올바르지 않습니다.")
    @NotBlank(message = "필수입력 항목입니다.")
    private String hp;

    private String area;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date join_date;

    private String mail_key;
}

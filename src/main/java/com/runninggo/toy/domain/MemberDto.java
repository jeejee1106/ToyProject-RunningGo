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

    @NotBlank
    @Pattern(regexp = "^[a-z0-9]{4,20}$", message = "5~20자의 영문 소문자, 숫자로 작성해주세요")
    private String id;

    @NotBlank
    private String pass;

    @NotBlank
    private String passCheck;

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String hp;

    private String area;

    private Date join_date;
}

package com.runninggo.toy.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MemberDto {
    private String id;
    private String pass;
    private String name;
    private String email;
    private String hp;
    private String area;
    private Date join_date;
}

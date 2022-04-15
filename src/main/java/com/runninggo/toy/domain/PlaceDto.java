package com.runninggo.toy.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PlaceDto {
    private String id;
    private String local1;
    private String local2;
    private String subway;
    private String level;
    private String storage;
    private int distance;
    private String description;
    private String reason;
    private Date posting_date;
}

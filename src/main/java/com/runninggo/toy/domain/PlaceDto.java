package com.runninggo.toy.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
public class PlaceDto {
    private String id;

    @NotBlank(message = "필수입력 항목입니다.")
    private String local1;

    @NotBlank(message = "필수입력 항목입니다.")
    private String local2;

    @NotBlank(message = "필수입력 항목입니다.")
    private String subway;

    @NotBlank(message = "필수입력 항목입니다.")
    private String level;

    @Size(max = 30, message = "30자 이하로 입력해주세요")
    private String storage;

    @Range(min = 1, max = 99, message = "1 이상 99 이하의 숫자만 입력해주세요.")
    private Double distance;

    @NotBlank(message = "필수입력 항목입니다.")
    @Size(min = 50, max = 1000, message = "50자 이상 1000자 이하로 작성해주세요.")
    private String description;

    @NotBlank(message = "필수입력 항목입니다.")
    @Size(min = 50, max = 1000, message = "50자 이상 1000자 이하로 작성해주세요.")
    private String reason;

    private Date posting_date;
}

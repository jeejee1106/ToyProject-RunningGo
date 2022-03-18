package com.runninggo.toy.service;

import com.runninggo.toy.domain.MemberDto;
import org.springframework.validation.Errors;

import java.util.Map;

public interface MemberService {
    int insertMember(MemberDto memberDto);
    Map<String, String> validateHandling(Errors errors);
    int idCheck(String id);
}

package com.runninggo.toy.service;

import com.runninggo.toy.domain.MemberDto;

public interface MemberService {
    int insertMember(MemberDto memberDto);
    int idCheck(String id);
}

package com.runninggo.toy.service;

import com.runninggo.toy.domain.MemberDto;

import java.util.List;

public interface MemberService {
    void insertMember(MemberDto memberDto) throws Exception;
    int idCheck(String id);
    int login(MemberDto memberDto);
    int updateMailKey(MemberDto memberDto) throws Exception;
    int updateMailAuth(String email) throws Exception;
    int emailAuthFail(String id) throws Exception;
    List<MemberDto> findId(MemberDto memberDto) throws Exception;
}

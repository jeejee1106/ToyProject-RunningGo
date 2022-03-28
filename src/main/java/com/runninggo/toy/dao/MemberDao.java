package com.runninggo.toy.dao;

import com.runninggo.toy.domain.MemberDto;

import java.util.List;

public interface MemberDao {
    int insertMember(MemberDto memberDto);
    int idCheck(String id);
    int login(MemberDto memberDto);
    int updateMailKey(MemberDto memberDto) throws Exception;
    int updateMailAuth(String email) throws Exception;
    int emailAuthFail(String id) throws Exception;
    List<MemberDto> findId(MemberDto memberDto) throws Exception;
    int findPass(MemberDto memberDto) throws Exception;
    int updateRandomPass(MemberDto memberDto) throws Exception;
}

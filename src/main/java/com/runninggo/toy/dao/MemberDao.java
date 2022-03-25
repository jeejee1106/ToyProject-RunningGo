package com.runninggo.toy.dao;

import com.runninggo.toy.domain.MemberDto;

public interface MemberDao {
    int insertMember(MemberDto memberDto);
    int idCheck(String id);
    int login(MemberDto memberDto);

    //    void createAuthKey(String member_mail,String auth_key) throws Exception;
    int updateMailKey(MemberDto memberDto) throws Exception;
    int updateMailAuth(String email) throws Exception;
}

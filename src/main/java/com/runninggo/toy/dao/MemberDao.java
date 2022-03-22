package com.runninggo.toy.dao;

import com.runninggo.toy.domain.MemberDto;

public interface MemberDao {
    int insertMember(MemberDto memberDto);
    int idCheck(String id);
    int login(MemberDto memberDto);
}

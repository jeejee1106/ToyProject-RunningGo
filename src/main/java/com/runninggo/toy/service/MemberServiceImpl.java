package com.runninggo.toy.service;

import com.runninggo.toy.dao.MemberDao;
import com.runninggo.toy.domain.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberDao memberDao;

    @Override
    public int insertMember(MemberDto memberDto) {
        return memberDao.insertMember(memberDto);
    }

    @Override
    public int idCheck(String id) {
        return memberDao.idCheck(id);
    }

    @Override
    public int login(MemberDto memberDto) {
        System.out.println("service memberDto = " + memberDto.getId());
        return memberDao.login(memberDto);
    }
}

package com.runninggo.toy.dao;

import com.runninggo.toy.domain.MemberDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao{

    @Autowired
    private SqlSession session;
    private static String namespace = "com.runninggo.toy.dao.MemberMapper.";

    @Override
    public int insertMember(MemberDto memberDto) {
        return session.insert(namespace + "insertMember", memberDto);
    }

    @Override
    public int idCheck(String id) {
        return session.selectOne(namespace + "idCheck", id);
    }
}

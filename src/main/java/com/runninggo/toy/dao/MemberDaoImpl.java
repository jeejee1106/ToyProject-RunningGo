package com.runninggo.toy.dao;

import com.runninggo.toy.domain.MemberDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

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

    @Override
    public int login(MemberDto memberDto) {
        return session.selectOne(namespace + "login", memberDto);
    }

    @Override
    public int updateMailKey(MemberDto memberDto) throws Exception {
        return session.update(namespace + "updateMailKey", memberDto);
    }

    @Override
    public int updateMailAuth(String email) throws Exception {
        return session.update(namespace + "updateMailAuth", email);
    }

//    @Override
//    public void createAuthKey(String member_mail, String auth_key) throws Exception {
//        Map<String, Object> map = new HashMap<>();
//
//        map.put("member_mail", member_mail);
//        map.put("auth_key", auth_key);
//
//        session.selectOne(namespace + "createAuthKey", map);
//    }

//    @Override
//    public void memberAuth(String member_mail) throws Exception {
//        session.update(namespace + "memberAuth", member_mail);
//    }
}

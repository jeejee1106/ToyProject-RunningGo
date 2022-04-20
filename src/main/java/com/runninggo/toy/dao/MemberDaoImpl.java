package com.runninggo.toy.dao;

import com.runninggo.toy.domain.MemberDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberDaoImpl implements MemberDao{

    private SqlSession session;
    private static String namespace = "com.runninggo.toy.dao.MemberMapper.";

    public MemberDaoImpl(SqlSession session) {
        this.session = session;
    }

    @Override
    public int insertMember(MemberDto memberDto) {
        return session.insert(namespace + "insertMember", memberDto);
    }

    @Override
    public int idCheck(String id) {
        return session.selectOne(namespace + "idCheck", id);
    }

    @Override
    public int login(MemberDto memberDto) throws Exception{
        return session.selectOne(namespace + "login", memberDto);
    }

    @Override
    public int updateMailKey(MemberDto memberDto) throws Exception {
        return session.update(namespace + "updateMailKey", memberDto);
    }

    @Override
    public int updateMailAuth(MemberDto memberDto) throws Exception {
        return session.update(namespace + "updateMailAuth", memberDto);
    }

    @Override
    public int emailAuthFail(String id) throws Exception {
        return session.selectOne(namespace + "emailAuthFail", id);
    }

    @Override
    public List<MemberDto> findId(MemberDto memberDto) throws Exception {
        return session.selectList(namespace + "findId", memberDto);
    }

    @Override
    public int findPass(MemberDto memberDto) throws Exception {
        return session.selectOne(namespace + "findPass", memberDto);
    }

    @Override
    public int updateRandomPass(MemberDto memberDto) throws Exception {
        return session.update(namespace + "updateRandomPass", memberDto);
    }

    @Override
    public String getEncPass(String id) throws Exception {
        return session.selectOne(namespace + "getEncPass", id);
    }

}

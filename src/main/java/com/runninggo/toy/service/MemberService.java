package com.runninggo.toy.service;

import com.runninggo.toy.domain.MemberDto;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface MemberService {
    void sendJoinCertificationMail(MemberDto memberDto) throws MessagingException, UnsupportedEncodingException;
    int insertMember(MemberDto memberDto) throws Exception;
    int idCheck(String id);
    int login(MemberDto memberDto) throws Exception;
    int updateMailKey(MemberDto memberDto) throws Exception;
    int updateMailAuth(MemberDto memberDto) throws Exception;
    int emailAuthFail(String id) throws Exception;
    List<MemberDto> findId(MemberDto memberDto) throws Exception;
    void findPass(MemberDto memberDto) throws Exception;
    int getFindUserResult(MemberDto memberDto) throws Exception;
    int updateRandomPass(MemberDto memberDto) throws Exception;
    String getEncPass(String id) throws Exception;
}

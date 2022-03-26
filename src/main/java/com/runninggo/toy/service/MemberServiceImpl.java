package com.runninggo.toy.service;

import com.runninggo.toy.dao.MemberDao;
import com.runninggo.toy.domain.MemberDto;
import com.runninggo.toy.mail.MailHandler;
import com.runninggo.toy.mail.TempKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberDao memberDao;
    @Autowired
    JavaMailSender mailSender;

    @Override
    public void insertMember(MemberDto memberDto) throws Exception {
        String mail_key = new TempKey().getKey(50,false);
        memberDto.setMail_key(mail_key);
        memberDao.insertMember(memberDto);
        memberDao.updateMailKey(memberDto);

        MailHandler sendMail = new MailHandler(mailSender);
        sendMail.setSubject("[RunninGo 이메일 인증메일 입니다.]"); //메일제목
        sendMail.setText(
                "<h1>RunninGo 메일인증</h1>" +
                        "<br>RunninGo에 오신것을 환영합니다!"+
                        "<br>아래 [이메일 인증 확인]을 눌러주세요."+
                        "<br><a href='http://localhost:8080/login/registerEmail' target='_blank'>이메일 인증 확인</a>");
        sendMail.setFrom("running.Go77@gmail.com", "러닝고");
        sendMail.setTo(memberDto.getEmail());
        sendMail.send();
    }

    @Override
    public int idCheck(String id) {
        return memberDao.idCheck(id);
    }

    @Override
    public int login(MemberDto memberDto) {
        return memberDao.login(memberDto);
    }

    @Override
    public int updateMailKey(MemberDto memberDto) throws Exception {
        return memberDao.updateMailKey(memberDto);
    }

    @Override
    public int updateMailAuth(String email) throws Exception {
        return memberDao.updateMailAuth(email);
    }

    @Override
    public int emailAuthFail(String id) throws Exception {
        return memberDao.emailAuthFail(id);
    }

}

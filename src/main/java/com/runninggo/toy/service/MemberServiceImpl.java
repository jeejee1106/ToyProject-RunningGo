package com.runninggo.toy.service;

import com.runninggo.toy.dao.MemberDao;
import com.runninggo.toy.domain.MemberDto;
import com.runninggo.toy.mail.MailHandler;
import com.runninggo.toy.mail.TempKey;
import com.runninggo.toy.myinfo.MyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    MyInfo myInfo = new MyInfo();
    final String RUNNINGGO_ID = myInfo.runningGoId;

    @Autowired
    MemberDao memberDao;
    @Autowired
    JavaMailSender mailSender;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
//    @Transactional(readOnly = true, rollbackFor=Exception.class)
    public void insertMember(MemberDto memberDto) throws Exception {

        //랜덤 문자열을 생성해서 mail_key 컬럼에 넣어주기
        String mail_key = new TempKey().getKey(30,false);
        memberDto.setMail_key(mail_key);

        //비밀번호를 암호화해서 넣어주기
        String encPassword = passwordEncoder.encode(memberDto.getPass());
        memberDto.setPass(encPassword);

        //회원가입
        memberDao.insertMember(memberDto);
        memberDao.updateMailKey(memberDto);

        //회원가입 완료하면 인증을 위한 이메일 발송
        MailHandler sendMail = new MailHandler(mailSender);
        sendMail.setSubject("[RunninGo 이메일 인증메일 입니다.]"); //메일제목
        sendMail.setText(
                "<h1>RunninGo 메일인증</h1>" +
                "<br>RunninGo에 오신것을 환영합니다!" +
                "<br>아래 [이메일 인증 확인]을 눌러주세요." +
                "<br><a href='http://localhost:8080/join/registerEmail?email=" + memberDto.getEmail() +
                "&mail_key=" + mail_key +
                "' target='_blank'>이메일 인증 확인</a>");
        sendMail.setFrom(RUNNINGGO_ID, "러닝고");
        sendMail.setTo(memberDto.getEmail());
        sendMail.send();
    }

    @Override
    public int idCheck(String id) {
        return memberDao.idCheck(id);
    }

    @Override
    public int login(MemberDto memberDto) throws Exception{

        String rawPassword = memberDto.getPass();
        String encodedPassword = memberDao.getEncPass(memberDto.getId());

        //입력받은 비밀번호와 암호화된 비밀번호를 비교(matches)해서 같지 않으면 0반환
        if(!passwordEncoder.matches(rawPassword, encodedPassword)) {
            return 0;
        } else{
            //같으면 memberDto.setPass()에 암호화된 비밀번호 넣어주어 입력한 비밀번호가 암호화된 비번과 같게 처리.
            memberDto.setPass(encodedPassword);
            return memberDao.login(memberDto);
        }
    }

    @Override
    public int updateMailKey(MemberDto memberDto) throws Exception {
        return memberDao.updateMailKey(memberDto);
    }

    @Override
    public int updateMailAuth(MemberDto memberDto) throws Exception {
        return memberDao.updateMailAuth(memberDto);
    }

    @Override
    public int emailAuthFail(String id) throws Exception {
        return memberDao.emailAuthFail(id);
    }

    @Override
    public List<MemberDto> findId(MemberDto memberDto) throws Exception {
        return memberDao.findId(memberDto);
    }

    @Override
    public int findPass(MemberDto memberDto) throws Exception {
        int result = memberDao.findPass(memberDto);

        if (result == 1) {
            //랜덤문자열 생성
            String pass = new TempKey().getKey(15,false);

            //위 문자열(비밀번호)을 암호화해서 넣어주기
            String encPassword = passwordEncoder.encode(pass);

            memberDto.setPass(encPassword);
            memberDao.updateRandomPass(memberDto);

            MailHandler sendMail = new MailHandler(mailSender);
            sendMail.setSubject("[RunninGo 임시비밀번호 입니다.]"); //메일제목
            sendMail.setText(
                    "<h1>RunninGo 임시비밀번호</h1>" +
                            "<br>회원님의 임시비밀번호입니다."+
                            "<br><b>" + pass + "</b>"+
                            "<br>로그인 후 반드시 비밀번호를 변경해주세요!!");
            sendMail.setFrom(RUNNINGGO_ID, "러닝고");
            sendMail.setTo(memberDto.getEmail());
            sendMail.send();
        }
        return result;
    }

    @Override
    public int updateRandomPass(MemberDto memberDto) throws Exception {
        return memberDao.updateRandomPass(memberDto);
    }

    @Override
    public String getEncPass(String id) throws Exception {
        return memberDao.getEncPass(id);
    }

}

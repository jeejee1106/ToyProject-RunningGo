package com.runninggo.toy.service;

import com.runninggo.toy.domain.MemberDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**.xml"})
public class JoinServiceTest {

    @Autowired
    MemberService memberService;

    public MemberDto joinMemberDto(String id, String pass, String name, String email, String hp, String area) {
        MemberDto memberDto = new MemberDto();
        memberDto.setId(id);
        memberDto.setPass(pass);
        memberDto.setName(name);
        memberDto.setEmail(email);
        memberDto.setHp(hp);
        memberDto.setArea(area);
        return memberDto;
    }

    @Test
    @DisplayName("회원가입성공")
    void joinSuccessTest() throws Exception{
        MemberDto memberDto = joinMemberDto(
                "test5", "test123!", "지지", "kimmj1106@naver.com", "010-1111-1111", "");
        int result = memberService.insertMember(memberDto);

        assertTrue(result == 1);
    }

//    @Test
//    @DisplayName("회원가입실패")
//    void joinFailTest() throws Exception{
//        MemberDto memberDto = joinMemberDto(
//                "test7", "test123!", "test", "kimmj1106@naver.com", "010-1111-1111", "");
//        int result = memberService.insertMember(memberDto);
//
//        assertTrue(result != 1);
//    }
}

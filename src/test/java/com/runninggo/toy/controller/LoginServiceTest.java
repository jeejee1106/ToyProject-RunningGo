package com.runninggo.toy.controller;

import com.runninggo.toy.domain.MemberDto;
import com.runninggo.toy.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**.xml"})
public class LoginServiceTest {

    @Autowired
    MemberService memberService;

    @Test
    @DisplayName("로그인테스트")
    public void loginTest() throws Exception{
        MemberDto memberDto = new MemberDto();
        memberDto.setId("11111");
        memberDto.setPass("testpass123!");

        int result = memberService.login(memberDto);
        System.out.println("result = " + result);
//
        assertTrue(result!=1);
    }
}
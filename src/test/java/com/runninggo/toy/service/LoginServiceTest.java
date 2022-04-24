package com.runninggo.toy.service;

import com.runninggo.toy.domain.MemberDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**.xml"})
public class LoginServiceTest {

    @Autowired
    MemberService memberService;

    public MemberDto loginMemberDto(String id, String pass) {
        MemberDto memberDto = new MemberDto();
        memberDto.setId(id);
        memberDto.setPass(pass);
        return memberDto;
    }

    public MemberDto findIdMemberDto(String name, String email, String hp) {
        MemberDto memberDto = new MemberDto();
        memberDto.setName(name);
        memberDto.setEmail(email);
        memberDto.setHp(hp);
        return memberDto;
    }

    @Test
    @DisplayName("로그인성공")
    public void loginSuccessTest() throws Exception{
        MemberDto memberDto = loginMemberDto("11111", "rla7748%");

        System.out.println("memberDto = " + memberDto);

        int result = memberService.login(memberDto);
        System.out.println("result = " + result);

        assertTrue(result==1);
    }

    @Test
    @DisplayName("로그인실패_id불일치")
    public void loginFailTest_Id() throws Exception{
        MemberDto memberDto = loginMemberDto("울랄라", "rla7748%");

        System.out.println("memberDto = " + memberDto);

        int result = memberService.login(memberDto);
        System.out.println("result = " + result);

        assertTrue(result!=1);
    }

    @Test
    @DisplayName("로그인실패_pass불일치")
    public void loginFailTest_Pass() throws Exception{
        MemberDto memberDto = loginMemberDto("11111", "111");

        System.out.println("memberDto = " + memberDto);

        int result = memberService.login(memberDto);
        System.out.println("result = " + result);

        assertTrue(result!=1);
    }

    @Test
    @DisplayName("로그인실패_둘다불일치")
    public void loginFailTest() throws Exception{
        MemberDto memberDto = loginMemberDto("bb", "bb");

        System.out.println("memberDto = " + memberDto);

        int result = memberService.login(memberDto);
        System.out.println("result = " + result);

        assertTrue(result!=1);
    }

    @Test
    @DisplayName("아이디찾기성공")
    void findIdSuccessTest() throws Exception {
        MemberDto memberDto = findIdMemberDto("지지", "kimmj1106@naver.com", "010-1111-1111");
        List<MemberDto> list = memberService.findId(memberDto);

        System.out.println("list = " + list.size());
        assertTrue(list.size()!=1);
    }

    @Test
    @DisplayName("아이디찾기실패")
    void findIdFailTest() throws Exception{
        MemberDto memberDto = findIdMemberDto("test", "kimmj1106@naver.com", "010-1111-1111");
        List<MemberDto> list = memberService.findId(memberDto);

        System.out.println("list = " + list.size());
        assertTrue(list.size()==0);
    }
}
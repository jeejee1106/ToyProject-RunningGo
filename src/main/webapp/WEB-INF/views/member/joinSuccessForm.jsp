<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="/css/member.css">

<div class="container">
    <div class="container-margin">
        <div class="joinSuccess-wrap">
            <div class="i-fa-check">
                <i class="fa fa-check"></i>
            </div>
            <h1>회원가입이 <b>완료</b> 되었습니다.</h1>
            <p class="joinSuccess-content">
                <b>${memberDto.name}</b>님의 회원가입을 축하드립니다.<br>
                나만의 러닝장소를 추천하고, 개성있는 크루들과 소통하세요!
            </p>
            <div class="joinSuccess-btn-box">
                <button type="button" onclick="location.href='/'">홈</button>
                <button type="button" class="btn-login" onclick="location.href='/login/loginForm'">로그인</button>
            </div>
        </div>
    </div>
</div>
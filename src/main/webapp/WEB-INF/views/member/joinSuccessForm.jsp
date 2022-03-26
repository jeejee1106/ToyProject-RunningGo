<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="/css/member.css">

<div class="container">
    <div class="container-margin">
        <div class="joinSuccess-wrap">
            <div class="i-fa-check">
                <i class="fa fa-check"></i>
            </div>
            <h1><b>${memberDto.name}</b>님, 환영합니다!</h1>
            <h5>RunningGo에서 나만의 러닝장소를 추천하고, 개성있는 크루들과 소통하세요!</h5>
            <p class="joinSuccess-content">
                입력하신 이메일 주소로 인증 메일이 발송되었습니다.
                이메일 인증을 하신 후 로그인이 가능합니다. 이메일 인증을 진행해주세요.
            </p>
            <div class="joinSuccess-btn-box">
                <button type="button" onclick="location.href='/'">홈</button>
                <button type="button" class="btn-login" onclick="location.href='/login/loginForm'">로그인</button>
            </div>
        </div>
    </div>
</div>
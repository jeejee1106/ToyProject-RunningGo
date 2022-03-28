<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
    <div class="container-margin">
        <div class="find-result-wrap">
            <h4 class="find-title">비밀번호 찾기 결과입니다.</h4>
            <c:choose>
                <c:when test="${count == 0}">
                등록된 가입 정보가 없습니다. <br>
                입력한 정보를 다시 한 번 확인해주세요.
                </c:when>

                <c:otherwise>
                입력하신 이메일주소로 <b>임시 비밀번호</b>를 발송했습니다.<br>
                로그인후 비밀번호 변경을 해주세요.
                </c:otherwise>
            </c:choose>
            <div class="find-result-btn-box">
                <button type="button" onclick="location.href='/'">홈</button>
                <button type="button" class="find-result-btn-login" onclick="location.href='/login/loginForm'">로그인</button>
            </div>
        </div>
    </div>
</div>
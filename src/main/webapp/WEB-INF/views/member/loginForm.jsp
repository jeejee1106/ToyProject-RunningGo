<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">
    <div class="container-margin">
        <div class="login-wrap">
            <div class="login-title">
                <h3>로그인</h3>
            </div>
            <div class="login-box">
                <div class="login-box-title">
                    <h5>회원 로그인</h5>
                </div>
                <form:form modelAttribute="memberDto" action="/login/login" method="post">
                    <div class="login-box-content">
                        <div>
                            <input type="text" id="id" name="id" value="${cookie.id.value}" autofocus placeholder="아이디">
                            <input type="password" id="pass" name="pass" placeholder="비밀번호">
                        </div>
                        <div class="btn-login">
                            <button type="submit" id="login-btn">로그인</button>
                        </div>
                    </div>

                    <div class="id-save-check">
                        <span>
                            <label>
                                <label><input type="checkbox" name="saveId" ${empty cookie.id.value ? "" : "checked"}>아이디 저장</label>
                            </label>
                        </span>
                    </div>
                    <div id="loginCheck-msg">
                        <form:errors/>
                    </div>
                </form:form>
                <hr>
                <!-- 여기서부터 회원가입, 비번찾기 버튼 -->
                <div class="btn-login-sub-box">
                    <ul class="login-sub-box-list">
                        <li>
                            <button class="btn-member-join" onclick="location.href='/join/joinForm'">
                                회원가입
                            </button>
                        </li>
                        <li>
                            <button class="btn-find-id" onclick="location.href='/login/findIdForm'">
                                아이디 찾기
                            </button>
                        </li>
                        <li>
                            <button class="btn-find-pass" onclick="location.href='/login/findPassForm'">
                                비밀번호 찾기
                            </button>
                        </li>
                    </ul>
                </div>
                <div class="login-box-title">
                    <h5>SNS 로그인</h5>
                </div>
                <div class="sns-login-box">
                    <button>카카오</button>
                    <button>네이버</button>
                    <button>구글</button>
                </div>
            </div>
        </div>
    </div>
</div>

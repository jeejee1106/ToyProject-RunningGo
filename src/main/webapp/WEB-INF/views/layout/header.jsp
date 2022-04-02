<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<nav class="navbar navbar-expand-lg navbar-light shadow">
    <div class="container d-flex justify-content-between align-items-center">

        <a class="navbar-brand text-success logo h1 align-self-center" href="/">
            RunningGo
        </a>

        <div class="align-self-center collapse navbar-collapse flex-fill  d-lg-flex justify-content-lg-between" id="templatemo_main_nav">
            <div class="flex-fill">
                <ul class="nav navbar-nav d-flex justify-content-between mx-lg-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/place/recmndForm">장소추천</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">크루모집</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">대회일정</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">러닝일기</a>
                    </li>
                </ul>
            </div>
            <div class="navbar align-self-center d-flex">
                <c:if test="${sessionScope.loginOK == null}">
                    <a class="nav-icon" href="/login/loginForm">
                        <i class="fa fa-fw fa-user text-dark"></i>
                        <span class="login-join-link">로그인/회원가입</span>
                    </a>
                </c:if>
                <c:if test="${sessionScope.loginOK != null}">
                    <span><b>${sessionScope.id}님</b></span>
                    <a class="nav-icon" href="/login/logout">
                        <i class="fa fa-fw fa-sign-out text-dark"></i>
                        <span class="login-join-link">로그아웃</span>
                    </a>
                </c:if>
            </div>
        </div>
    </div>
</nav>
<!-- Close Header -->
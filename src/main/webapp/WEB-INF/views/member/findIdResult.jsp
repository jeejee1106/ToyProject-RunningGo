<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="container">
    <div class="container-margin">
        <div class="findId-result-wrap">
            <div class="findId-result-content">
                <h4 id="find-id-title">아이디 찾기 결과입니다.</h4>
                <c:if test="${empty idList}">
                    등록된 아이디가 없습니다. <br>
                    입력한 정보를 다시 한 번 확인해주세요.
                </c:if>

                <c:forEach var="idList" items="${idList}">
                    <div>
                        <b>
                        ${fn:substring(idList.id,0,4) }
                        <c:forEach begin="5" end="${fn:length(idList.id)}" step="1">
                            *
                        </c:forEach>
                        </b>
                        (가입일 : <fmt:formatDate value="${idList.join_date}" pattern="yyyy-MM-dd"/>)
                    </div>
                </c:forEach>
            </div>
            <div class="findId-result-btn-box">
                <button type="button" onclick="location.href='/'">홈</button>
                <button type="button" class="findId-result-btn-login" onclick="location.href='/login/loginForm'">로그인</button>
            </div>
        </div>
    </div>
</div>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
    <div class="container-margin">
        등록된 아이디 입니다.
        <c:forEach var="idList" items="${idList}">
        ${idList.id}
        </c:forEach>
    </div>
</div>
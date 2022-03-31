<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
    <div class="container-margin">
        발생한 예외 : ${exception} <br>
        예외 메세지 : ${exception.message}

        <ol>
            <c:forEach items="${exception.stackTrace}" var="i">
                <li>${i.toString()}</li>
            </c:forEach>
        </ol>
    </div>
</div>

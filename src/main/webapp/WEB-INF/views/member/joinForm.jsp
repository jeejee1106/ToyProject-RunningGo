<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript">
    <%--$(document).ready(function (){--%>
    <%--    $("#listBtn").on("click", function (){--%>
    <%--        location.href = "<c:url value='/board/list'/>?page=${page}&pageSize=${pageSize}";--%>
    <%--    })--%>
    <%--    $("#writeBtn").on("click", function (){--%>
    <%--        let form = $("#form");--%>
    <%--        form.attr("action", "<c:url value='/board/write'/>");--%>
    <%--        form.attr("method", "post");--%>
    <%--        form.submit();--%>
    <%--    });--%>
    <%--});--%>

    function fn_idCheck() {
        var idRegExp = /^[a-z0-9]{5,20}$/; //아이디 유효성 검사
        var id = $("#id").val().trim();
        $.ajax({
            url: "/login/idCheck",
            type: "post",
            dataType: "json",
            data: {"id": id},
            success: function (data) {
                if (data == 1) {
                    $("#idCheck-msg").html("중복된 아이디입니다.").css({'color' : 'red'});
                    $("#id").val("").focus();
                    $(".idCheck-btn").attr('value', 'N');
                }
                else if (data == 0) {
                    if(id.length == 0){
                        $("#idCheck-msg").html("아이디를 입력해주세요.").css({'color' : 'red'});
                        $("#id").val("").focus();
                        $(".idCheck-btn").attr('value', 'N');
                    }
                    else if(!idRegExp.test(id)){
                        $("#idCheck-msg").html("5~20자의 영문 소문자, 숫자로 작성해주세요.").css({'color' : 'red'});
                        $("#id").val("").focus();
                        $(".idCheck-btn").attr('value', 'N');
                    }else{
                        $("#id").val(id);
                        $("#idCheck-msg").html("사용가능한 아이디입니다.").css({'color' : 'black'});
                        $(".idCheck-btn").attr('value', 'Y');
                    }
                }
            },
            error:function(request,status,error){
                alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
            }


        })
    }

    // function lastCheck(f){
    //     var check1 = $(".idCheck-btn").attr('value');
    //
    //     if(check1 == "N"){
    //         alert("아이디 중복체크를 해주세요");
    //         return false;
    //     }
    //     return true;
    // }
</script>
<div class="container">
    <div class="container-margin">
        <div class="join-wrap">
            <div class="join-title">
                <h3>회원가입</h3>
            </div>
            <hr>
            <div class="join-box">
                <h4 class="join-sub-title">기본정보</h4>
                <span class="important imp-tit">*필수입력 사항</span>
                <div class="join-table-box">
<%--                    <form:form modelAttribute="memberDto" action="/login/joinCheck" method="post" onsubmit="return lastCheck(this)">--%>
                    <form:form modelAttribute="memberDto" action="/login/joinCheck" method="post">
                        <table>
                            <colgroup>
                                <col width="250px;">
                                <col width="550px;">
                            </colgroup>
                            <tbody>
                            <tr>
                                <th id="top-th">
                                    <span class="important">*</span>아이디
                                </th>
                                <td id="top-td">
                                    <div class="idCheck-box">
                                        <input type="text" id="id" name="id" value="${memberDto.id}" placeholder="5~20자의 영문 소문자, 숫자로 작성해주세요">
                                        <button type="button" class="idCheck-btn" value="N" onclick="fn_idCheck()">중복확인</button>
                                    </div>
                                    <div id="idCheck-msg" class="valid-msg"><form:errors path="id" /></div>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    <span class="important">*</span>비밀번호
                                </th>
                                <td>
                                    <div>
                                        <input type="password" name="pass" value="${memberDto.pass}">
                                    </div>
                                    <div class="valid-msg"><form:errors path="pass"/></div>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    <span class="important">*</span>비밀번호 확인
                                </th>
                                <td>
                                    <div>
                                        <input type="password" name="passCheck" value="${memberDto.passCheck}">
                                    </div>
                                    <div class="valid-msg"><form:errors path="passCheck"/></div>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    <span class="important">*</span>이름
                                </th>
                                <td>
                                    <div>
                                        <input type="text" name="name" value="${memberDto.name}">
                                    </div>
                                    <div class="valid-msg"><form:errors path="name"/></div>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    <span class="important">*</span>이메일
                                </th>
                                <td>
                                    <div>
                                        <input type="text" name="email" value="${memberDto.email}">
                                        <select class="email-option">
                                            <option value="self">직접입력</option>
                                            <option value="naver.com">naver.com</option>
                                            <option value="hanmail.net">hanmail.net</option>
                                            <option value="daum.net">daum.net</option>
                                            <option value="mail.com">gmail.com</option>
                                            <option value="nate.com">nate.com</option>
                                        </select>
                                    </div>
                                    <div class="valid-msg"><form:errors path="email"/></div>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    <span class="important">*</span>휴대폰 번호
                                </th>
                                <td>
                                    <div>
                                        <input type="tel" name="hp" placeholder="- 없이 입력하세요" value="${memberDto.hp}">
                                    </div>
                                    <div class="valid-msg"><form:errors path="hp"/></div>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    <span class="important">&nbsp;&nbsp;</span>활동지역
                                </th>
                                <td>
                                    <div>
                                        <span>서울시</span>
                                        <select class="area-option" name="area" value="${memberDto.area}">
                                            <option value="none">선택안함</option>
                                            <option value="강남구">강남구</option>
                                            <option value="강동구">강동구</option>
                                            <option value="강북구">강북구</option>
                                            <option value="강서구">강서구</option>
                                            <option value="관악구">관악구</option>
                                            <option value="광진구">광진구</option>
                                            <option value="구로구">구로구</option>
                                            <option value="금천구">금천구</option>
                                        </select>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <div class="join-btn-box">
                            <button type="button">취소</button>
                            <button type="submit" class="btn-join">회원가입</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
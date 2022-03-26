<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<link rel="stylesheet" href="/css/member.css">

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
                    <form:form modelAttribute="memberDto" action="/join/joinCheck" method="post" onsubmit="return fn_lastCheck(this)">
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
                                        <input type="text" id="id-form" name="id" value="${memberDto.id}" placeholder="5~20자의 영문 소문자, 숫자만 사용 가능합니다." required>
                                        <button type="button" class="idCheck-btn">중복확인</button>
                                        <div id="test"></div>
                                    </div>
                                    <div id="idCheck-msg" class="valid-msg" value="N"><form:errors path="id" /></div>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    <span class="important">*</span>비밀번호
                                </th>
                                <td>
                                    <div>
                                        <input type="password" id="pass-form" name="pass" value="${memberDto.pass}" placeholder="8~20자의 영문 대소문자+숫자+특수문자를 사용하세요." required>
                                    </div>
                                    <div id="passCheck-msg" class="valid-msg" value="N"><form:errors path="pass"/></div>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    <span class="important">*</span>비밀번호 확인
                                </th>
                                <td>
                                    <div>
                                        <input type="password" id="passCheck-form" name="passCheck" value="${memberDto.passCheck}" required>
                                    </div>
                                    <div id="passCheck-msg2" class="valid-msg" value="N"><form:errors path="passCheck"/></div>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    <span class="important">*</span>이름
                                </th>
                                <td>
                                    <div>
                                        <input type="text" id="name-form" name="name" value="${memberDto.name}" required>
                                    </div>
                                    <div id="nameCheck-msg" class="valid-msg" value="N"><form:errors path="name"/></div>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    <span class="important">*</span>이메일
                                </th>
                                <td>
                                    <div>
                                        <input type="text" id="email-form" name="email" value="${memberDto.email}" required>
                                        <select class="email-option">
                                            <option value="" selected>직접입력</option>
                                            <option value="@naver.com">naver.com</option>
                                            <option value="@hanmail.net">hanmail.net</option>
                                            <option value="@daum.net">daum.net</option>
                                            <option value="@gmail.com">gmail.com</option>
                                            <option value="@nate.com">nate.com</option>
                                        </select>
                                    </div>
                                    <div id="emailCheck-msg" class="valid-msg" value="N"><form:errors path="email"/></div>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    <span class="important">*</span>휴대폰 번호
                                </th>
                                <td>
                                    <div>
                                        <input type="tel" id="hp-form" name="hp" placeholder="- 없이 입력하세요" value="${memberDto.hp}" required>
                                    </div>
                                    <div id="hpCheck-msg" class="valid-msg" value="N"><form:errors path="hp"/></div>
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
                            <button type="button" onclick=fn_cancel()>취소</button>
                            <button type="submit" class="btn-join">회원가입</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
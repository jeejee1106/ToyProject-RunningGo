<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <div class="container-margin">
        <div class="find-wrap">
            <div class="find-title">
                <h3>비밀번호 찾기</h3>
            </div>
            <div class="find-box">
                <div class="find-notice">
                    * 가입 시 등록하신 아이디, 이메일 주소를 입력해주세요.
                </div>
                <div class="find-table-box">
                    <form action="/login/findPass" method="post" onsubmit="return fn_findPass_check()">
                        <table>
                            <tbody>
                            <tr>
                                <th>
                                    아이디
                                </th>
                                <td>
                                    <div>
                                        <input type="text" id="findPass-id" name="id" placeholder="아이디를 입력해주세요." required>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    이메일
                                </th>
                                <td>
                                    <div>
                                        <input type="text" id="findPass-email" name="email" placeholder="이메일 형식으로 입력해주세요." required>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <div class="find-btn-box">
                            <button type="submit" id="findId-next-btn">다음</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
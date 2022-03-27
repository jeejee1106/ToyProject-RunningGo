<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <div class="container-margin">
        <div class="findId-wrap">
            <div class="findId-title">
                <h3>아이디 찾기</h3>
            </div>
            <div class="findId-box">
                <div class="findId-notice">
                    * 가입 시 등록하신 이름, 이메일, 휴대폰 번호를 입력해주세요.
                </div>
                <div class="findId-table-box">
                    <form action="/login/findId" method="post" onsubmit="return fn_findId_check()">
                        <table>
                            <tbody>
                            <tr>
                                <th>
                                    이름
                                </th>
                                <td>
                                    <div>
                                        <input type="text" id="findId-name" name="name" placeholder="2자 이상의 한글만 입력해주세요." required>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    이메일
                                </th>
                                <td>
                                    <div>
                                        <input type="text" id="findId-email" name="email" placeholder="이메일 형식으로 입력해주세요." required>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    휴대폰 번호
                                </th>
                                <td>
                                    <div>
                                        <input type="text" id="findId-hp" name="hp" placeholder="- 없이 입력하세요." required>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <div class="findId-btn-box">
                            <button type="submit" id="findId-next-btn">다음</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
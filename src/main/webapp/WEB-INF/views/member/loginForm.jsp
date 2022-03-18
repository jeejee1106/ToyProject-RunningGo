<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
                <div class="login-box-content">
                    <div>
                        <input type="text" class="user-id" placeholder="아이디">
                        <input type="password" class="user-pass" placeholder="비밀번호">
                    </div>
                    <div class="btn-login">
                        <button type="button">로그인</button>
                    </div>
                </div>
                <div class="id-save-check">
					<span>
						<label>
							<input type="checkbox">아이디 저장
						</label>
					</span>
                </div>
                <hr>
                <!-- 여기서부터 회원가입, 비번찾기 버튼 -->
                <div class="btn-login-sub-box">
                    <ul class="login-sub-box-list">
                        <li>
                            <button class="btn-member-join" onclick="location.href='/login/join'">
                                회원가입
                            </button>
                        </li>
                        <li>
                            <button class="btn-find-id" onclick="">
                                아이디 찾기
                            </button>
                        </li>
                        <li>
                            <button class="btn-find-pass" onclick="">
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
    로그인.jsp 입니다.
    ${data}
    </div>
</div>

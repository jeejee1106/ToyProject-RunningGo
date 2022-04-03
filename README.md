# [개인프로젝트] RunningGo - 러닝고🏃‍♀️🏃‍♂️
- <b>`러닝고는 서울의 러닝 코스를 추천하는 커뮤니티입니다.`</b>
- "나도 러닝을 시작하고 싶은데 어디서 뛰어야하지?"
- "최적의 러닝 장소를 찾고 싶은데, 정보가 뒤섞여있어서 찾아보기도 쉽지 않네... 짐보관도 할 수 있으면 좋은데"
- 이런 고민을 해결하고, 러닝 장소의 자세한 정보까지 알려주는 커뮤니티 러닝고!
- 거리, 짐 보관 여부, 난이도, 포토스팟 등 코스 정보와 꿀팁까지 한방에! 나만의 러닝 맛집을 알려주세요!

<br>

## 1. 제작 기간
### `2022년 3월 16일 ~ 진행중`

<br>

## 2. 사용 기술
### `Back-end`
- Java 11
- Spring Framework 5.0
- Maven 3.8
- MyBatis 2.2
- MySQL 8

### `Front-end`
  - HTML5
  - JavaScript
  - JQuery 2.2
  - CSS
  - BootStrap 4.1

<br>

## 3. 기능 구현
- #### `회원가입`
	- Validation(Back) + Javascript(Front)를 활용한 유효성 검사
	- 아이디 중복 여부와 비밀번호 일치 여부 역시 Validation으로 검사
	- Spring Security를 활용한 비밀번호 암호화
	- Gmail SMTP를 활용한 이메일 인증

- #### `로그인`
	- 일반 로그인
		- 로그인 : 이메일 인증 안하면 로그인 불가능
		- 아이디 찾기 : 회원정보를 입력하면 가입한 아이디를 List로 출력 후 5번째 자리부터 아이디 길이만큼 '*'로 치환
		- 비밀번호 찾기 : 회원정보를 입력하면 이메일주소로 임시 비밀번호 발급
	- 소셜로그인
		- 구현  예정

- #### `예외 처리`
	- ExceptionHandler를 이용한 예외 처리

<br>

## 4. 핵심 기능 설명
- 회원가입 시 유효성 검사 Validation
	- 먼저, 유효성 검사가 필요한 매개변수에 @Valid 어노테이션을 붙여줍니다. 이 어노테이션은 해당 객체가 유효한 객체인지 검사해줍니다.  
	- 유효성 검사가 필요한 매개변수의 다음 매개변수로 Error 객체를 넣어줍니다. (반드시 유효성 검증이 필요한 객체 다음에 와야합니다.)
	- @valid가 붙은 객체의 유효성 검사가 실패하게 되면 error.hasErrors()메서드에서 true값이 반환됩니다.
	- 회원가입 폼의 데이터 형식 유효성 검사를 위해 하이버네이트~~ 해주었고, 패턴으로는 정규식을 넣어주었습니다.
- 비밀번호 암호화 PasswordEncoder
- 예외 처리 ExceptionHandler

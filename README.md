# [개인프로젝트] RunningGo - 러닝고🏃‍♀️🏃‍♂️
#### 💡 러닝고는 서울의 러닝 코스를 추천하는 커뮤니티 사이트입니다.
* "나도 러닝을 시작하고 싶은데 **어디서** 뛰어야하지?"
* "**최적의 러닝 장소**를 찾고 싶은데, 정보가 뒤섞여있어서 찾아보기도 쉽지 않네... **짐보관**도 할 수 있으면 좋은데"
* 이런 고민을 해결하고, **러닝 장소의 자세한 정보**까지 알려주는 커뮤니티 러닝고!
* **거리, 짐 보관 여부, 난이도, 포토스팟 등 코스 정보와 꿀팁까지 한방에! 나만의 러닝 맛집을 알려주세요!**

<br>

## 1. 제작 기간
### `2022년 3월 16일 ~ 진행중`

<br>

## 2. 사용 기술
### `Back-end`
* Java 11
* Spring Framework 5.0
* Maven 3.8
* MyBatis 2.2
* MySQL 8

### `Front-end`
* HTML5
* JavaScript
* JQuery 2.2
* CSS
* BootStrap 4.1

<br>

## 3. 기능 구현
* #### `회원가입`
  * Validation(Back-end) + Javascript(Front-end)를 활용한 유효성 검사
  * 아이디 중복 여부와 비밀번호 일치 여부 역시 Validation으로 검사
  * Spring Security를 활용한 비밀번호 암호화
  * Gmail SMTP를 활용한 이메일 인증

* #### `로그인`
  * 일반 로그인
    * 로그인 : Validation(Back-end)를 활용한 유효성 검사, 이메일 인증 안하면 로그인 불가능
    * 아이디 찾기 : 회원정보를 입력하면 가입한 아이디를 List로 출력 후 5번째 자리부터 아이디 길이만큼 '\*'로 치환
    * 비밀번호 찾기 : 회원정보를 입력하면 이메일주소로 임시 비밀번호 발급
  * 소셜로그인
    * 구현  예정

* #### `예외 처리`
  * ExceptionHandler를 이용한 예외 처리

<br>

## 4. 핵심 기능 설명 & 트러블 슈팅
#### 📌회원가입, 로그인 시 유효성 검사 Validation
<details>
  <summary>핵심 기능 설명</summary>
	
  ##### `1. 제약조건 어노테이션을 활용한 데이터 형식 유효성 검사`
  * 먼저, 유효성 검사가 필요한 MemberDto 객체의 각 필드에 제약조건 어노테이션을 적용해주었다.(@NotBlank, @Pattern)  
  * JoinController에서는 MemberDto 객체 앞에 @Valid 어노테이션을 적용해주었고, Errors를 통해 유효성 검사 적합 여부를 확인했다.  
  * @Valid가 적용된 MemberDto 객체에서 유효성 검사 중 에러가 발생하면 error.hasErrors()메서드에서는 true값이 반환되고, 조건문을 사용하여 에러가 발생했을 시 메세지를 출력한 후 작성중인 폼이 그대로 유지되는 코드를 작성하였다.  
  * **‼결과‼** 회원가입 시 데이터 형식이 유효하지 않으면 오류 메세지를 출력하고, 작성중인 폼이 그대로 유지되도록 구현할 수 있었다.  
  * [이미지로 코드 & 결과 확인하기](https://user-images.githubusercontent.com/84839167/161678010-5aac77c5-1f72-4ae2-a74b-af5bed0deb9f.png)

  ##### `2. WebDataBinder를 활용한 유효성 검사`
  * 제약조건 어노테이션으로 할 수 없는 유효성 검사는 WebDataBinder를 활용하였다.
    * 회원가입 시 아이디 중복확인과 비밀번호-비밀번호확인 일치 여부(JoinController)
    * 로그인 시 아이디, 비밀번호의 존재 여부(LoginController)
  * 먼저, 각 Controller의 상단에 @InitBinder 어노테이션을 적용하고, WebDataBinder 객체를 매개변수로 받는 메서드를 만들어주었다.
  * 나는 각 Controller에서 검증할 내용이 서로 달랐기 때문에 Validator 인터페이스를 구현한 클래스를 추상클래스로 만들었다.
    * 👉[AbstractValidator 코드확인](https://github.com/jeejee1106/ToyProject-RunningGo/blob/1c6c8384af327871bb1144f4fdbbe8b41836bc88/src/main/java/com/runninggo/toy/validator/AbstractValidator.java#L9)
  * 그리고 그 추상클래스를 다시 상속 받는 두 개의 검증클래스를 만들어 위 메서드에 각각 바인딩 해주었다.
    * 👉[JoinValidator 코드확인](https://github.com/jeejee1106/ToyProject-RunningGo/blob/1c6c8384af327871bb1144f4fdbbe8b41836bc88/src/main/java/com/runninggo/toy/validator/IdDuplCkValidator.java#L11) 👉[LoginValidator 코드확인](https://github.com/jeejee1106/ToyProject-RunningGo/blob/1c6c8384af327871bb1144f4fdbbe8b41836bc88/src/main/java/com/runninggo/toy/validator/LoginCheckValidator.java#L11)
  * 또한, messageSource를 사용해 에러 발생 시 전달할 메시지도 에러코드에 저장해주었고, 위 1번과 같이 @Valid와 Errors를 활용해 유효성 검사 적합 여부를 확인했다.  
  * **‼결과‼** 유효하지 않은 값이 들어오면 저장해준 에러코드를 출력하고, 더 이상 회원가입, 로그인이 진행되지 못하도록 구현할 수 있었다.  
  * [이미지로 코드 & 결과 확인하기](https://user-images.githubusercontent.com/84839167/161677883-4e4976b7-81ee-480f-98e8-ba1563627b0b.png)

</details>
<details>
  <summary>트러블 슈팅</summary>
  
</details>

#### 📌비밀번호 암호화 PasswordEncoder
<details>
  <summary>핵심 기능 설명</summary>
  
</details>
<details>
  <summary>트러블 슈팅</summary>
  
</details>

#### 📌예외 처리 ExceptionHandler
<details>
  <summary>핵심 기능 설명</summary>
  
</details>
<details>
  <summary>트러블 슈팅</summary>
  
</details>

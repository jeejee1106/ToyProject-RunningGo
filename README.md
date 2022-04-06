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
    * 비밀번호 찾기 : 회원정보를 입력하면 이메일주소로 암호화된 임시 비밀번호 발급
  * 소셜로그인
    * 구현  예정

* #### `예외 처리`
  * ExceptionHandler를 이용한 예외 처리

<br>

## 4. 핵심 기능 설명 & 트러블 슈팅
#### 1. 회원가입, 로그인 시 유효성 검사 Validation
<details>
  <summary>📌핵심 기능 설명</summary>
	
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
  <summary>⚽트러블 슈팅 : @InitBinder가 적용된 메서드에 객체를 바인딩을해도 유효성 검사가 실행되지 않음</summary>

<br>
유효성 검사에 들어가기 전, 구글링을 통해 바인딩 객체가 하나일 땐 setValidator() 메서드를, 하나 이상일 땐 addValidators() 메서드를 사용해야 한다는 것을 공부한 후 코드를 작성했다.
	
  ##### `1. 회원가입 시 유효성 검사 미작동`
  * 첫 번째 시도 : 아이디 중복 검사 클래스, 비밀번호 일치 검사 클래스를 addValidators() 메서드를 사용해 각각 바인딩 -> ⭕정상 작동!  
  * 두 번째 시도 : 두 클래스를 하나의 클래스로 구현해도 될 것 같다는 생각에 JoinCkValidator클래스를 만들어 코드를 합친 후 <br> 바인딩할 객체가 하나이기 때문에 setValidator() 메서드로 변경 -> ❌비정상작동
    * 하고자 했던 바인딩을 통한 유효성 검사는 잘 되었지만, 잘 되던 데이터 형식 유효성 검사가 작동하지 않았다.
  * 세 번째 시도 : 객체가 하나이지만 혹시나 하는 마음에 addValidators() 메서드로 다시 변경 -> ⭕정상 작동!
<details>
  <summary>👉코드확인</summary>

  <div markdown="1">    

  ```java
	  //첫 번째 코드 - 정상작동
	  @InitBinder
	  public void validator(WebDataBinder binder) {
		  binder.addValidators(IdDuplCkValidator);
	  	  binder.addValidators(passMctCkValidator);
	  }
	  
	  //두 번째 코드 - 비정상작동
	  @InitBinder
	  public void validator(WebDataBinder binder) {
		  binder.addValidators(joinCkValidator);
	  }

	  //세 번째 코드 - 정상작동
	  @InitBinder
	  public void validator(WebDataBinder binder) {
		  binder.setValidator(joinCkValidator);
	  }
  ```
  </div>
</details>
	
객체가 하나인데 setValidator() 메서드가 아닌 addValidators() 메서드를 사용했을 때 정상 작동하는 이유가 무엇일까?  
사실 정확한 이유는 찾지 못했지만, 아래 로그인 시 유효성 검사까지 완료해보니 짐작 가는 부분이 생겼다.  
	
  ##### `2. 로그인 시 유효성 검사 미작동`
  * 첫 번째 시도 : validator가 아닌 Model을 사용해서 아이디, 비밀번호가 존재하지 않으면 메시지를 전송하는 방식을 적용 -> ⭕정상작동!
  * 두 번째 시도 : 로그인도 validator를 적용해보고 싶다는 생각에 아이디, 비밀번호 존재 여부를 검사하는 클래스를 만든 후 <br>
	회원가입과 똑같이 addValidators() 메서드 사용 -> ❌비정상작동
    * 회원가입 시에 필요한 MemberDto객체의 데이터 형식 검사를 진행하며 에러 발생
  * 세 번째 시도 : setValidator() 메서드로 변경 -> ⭕정상작동!
<details>
  <summary>👉코드확인</summary>

  <div markdown="1">    

  ```java
	  //첫 번째 코드 - 정상작동 (login메서드)
	  if(memberService.login(memberDto) != 1){
		  model.addAttribute("loginFailMsg", "아이디 또는 비밀번호가 올바르지 않습니다.");
		  return "/member/loginForm";
          }
	  
	  //두 번째 코드 - 비정상작동
	  @InitBinder
	  public void validator(WebDataBinder binder) {
		  binder.addValidators(LoginCkValidator);
	  }
	  
	  //세 번째 코드 - 정상작동
	  @InitBinder
	  public void validator(WebDataBinder binder) {
		  binder.setValidator(LoginCkValidator);
	  }
  ```
  </div>
</details>

로그인할 때에는 데이터 형식을 검사하길 원하지 않았는데 두 번째 시도에선 데이터 형식을 검사하며 에러가 발생했다.  
문득 setValidator() 메서드가 아닌 addValidators() 메서드를 사용하고 있었다는 사실을 깨닫고, setValidator() 메서드로 수정해주었다.  
이 과정에서 회원가입 두 번째 시도와 같이 데이터 형식 검사를 하지 않는다는 것을 알아냈고,  힌트를 얻을 수 있었다.

위 두 경우를 보면 회원가입 유효성 검사에서는 addValidators()메서드를,  
로그인 유효성 검사에서는 setValidator()메서드를 사용해야 정상작동하는 것을 알 수 있다.  
회원가입도 검사할 객체가 하나인데 왜 addValidators() 메서드만 정상작동하는걸까?  
내가 찾은 답은 `'어노테이션을 통한 데이터 유효성 검사 또한 하나의 유효성 검사 객체(?)로 인식한다.'` 이다.  

`그렇다면?`  
회원가입에서는 ①데이터 형식 유효성 검사와 ②커스텀 유효성 검사 두 개가 이루어지니 **addValidators()메서드를**,  
로그인은 ①커스텀 유효성 검사만 하면 되니 **setValidator()메서드를** 사용하면 된다는 것이 내가 찾은 결론이다.  
또한 검증객체가 하나 이상일 땐 제약조건 어노테이션으로 정의한 데이터 형식 유효성 검사가 우선적으로 이루어진다는 것을 예상할 수 있다.
	
</details>

<br>

#### 2. 비밀번호 암호화 PasswordEncoder
<details>
  <summary>📌핵심 기능 설명</summary>
  
  ##### `1. 회원가입 시 비밀번호 암호화`
  * 먼저 PasswordEncoder을 주입 받기 위한 Spring Security 설정을 해주었고, Service에서 BCryptPasswordEncoder를 사용했다.
  * 회원가입 시 입력받은 비밀번호를 BCryptPasswordEncoder객체의 encode() 메서드로 암호화 해주었고, 
  * 암호화된 비밀번호를 다시 MemberDto에 넣어주며 회원가입을 완료했다.
  * [이미지로 코드 & 결과 확인하기](https://user-images.githubusercontent.com/84839167/161939355-cac8c85a-0e30-429c-909a-fde92dd30b57.png)
  
  ##### `2. 로그인 시 비밀번호 비교`
  * 로그인 시 입력받은 비밀번호와 DB에 저장된 암호화된 비밀번호를 비교하여 일치하면 로그인에 성공하도록 로직을 짰다.
  * 두 값의 비교는 BCryptPasswordEncoder객체의 matches() 메서드를 사용했고, 입력받은 비밀번호와 DB에 저장된 비밀번호가 
  * 일치할 경우 입력받은 비밀번호의 값을 암호화된 비밀번호로 바꾸어 주며 로그인에 성공할 수 있었다.
  * [이미지로 코드 & 결과 확인하기](https://user-images.githubusercontent.com/84839167/161939367-2daf8776-9865-45d0-94bf-3eb7ba5bf886.png)

  ##### `새로 알게된 점`
Spring Security는 같은 비밀번호로 회원가입을 해도 매번 다른 랜덤키를 부여한다.  
같은 문자열임에도 각기 다른 랜덤키를 어떻게 비교를 하는건지 궁금해서 더 알아보았다.  
BCryptPasswordEncoder는 **비밀번호의 단방향 암호화**를 지원하는 PasswordEncoder 인터페이스의 구현체이고,  
해시 함수를 사용하여 비밀번호를 암호화하고, **복호화를 할 수 없도록** 만들어졌다고 한다.  
때문에 비밀번호를 서로 비교할 땐 equals()가 아닌 matches()를 사용해야 한다.  
matches()는 내부적으로 입력받은 패스워드와 암호화된 패스워드가 서로 대칭되는지에 대한 알고리즘을 구현하고 있다고 한다.  
matches()는 더 비밀번호의 보안을 위해 복호화 할 수 없는 비밀번호를 다룰 때 사용한다는 것을 알게되었다.
	
</details>

<br>

#### 3. 예외 처리 ExceptionHandler
<details>
  <summary>📌핵심 기능 설명</summary>
  
</details>
<details>
  <summary>⚽트러블 슈팅</summary>
  
</details>

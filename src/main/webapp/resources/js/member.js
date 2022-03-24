$(function () {

    /**
     * 로그인 js
     */
    //로그인버튼 비활성화
    $("#login-btn").css({"pointer-events" : "none", "backgroundColor" : "#cbcbcb"});
    //아이디, 비밀번호 입력하면 버튼 활성화
    $("#id, #pass").on("keyup",function(){
        let login_id = $("#id").val().trim();
        let login_pass = $("#pass").val().trim();
        if(login_id.length != 0 && login_pass.length != 0){
            $("#login-btn").css({"pointer-events" : "", "backgroundColor" : "#2146d0"});
        } else{
            $("#login-btn").css({"pointer-events" : "none", "backgroundColor" : "#cbcbcb"});
        }
    });

    /**
    * 회원가입 js
    * */
    //아이디 유효성 검사
    $(".idCheck-btn").click(function () {
        let idRegExp = /^[a-z0-9]{5,20}$/;
        let id = $("#id-form").val().trim();

        $.ajax({
            url: "/login/idCheck",
            type: "post",
            dataType: "json",
            data: {"id": id},
            success: function (data) {
                $("#idCheck-msg").css("margin-top", "5px");
                if (data == 1) {
                    $("#idCheck-msg").html("중복된 아이디입니다.").css("color", "red").attr("value", "N");
                    $("#id-form").val("").focus();
                } else if (data == 0) {
                    if(id.length == 0){
                        $("#idCheck-msg").html("아이디를 입력해주세요.").css("color", "red").attr("value", "N");
                        $("#id-form").val("").focus();
                    } else if(!idRegExp.test(id)){
                        $("#idCheck-msg").html("5~20자의 영문 소문자, 숫자만 사용 가능합니다.").css("color", "red").attr("value", "N");
                        $("id-form").val("").focus();
                    } else{
                        $("#id-form").val(id);
                        $("#idCheck-msg").html("사용가능한 아이디입니다.").css("color", "blue").attr("value", "Y");
                    }
                }
            },
            error:function(request,status,error){
                alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
            }
        })
    });

    //아이디 중복 검사 통과 후 value=Y 상태에서 문자열을 지웠을 때 value=N 이 나오도록
    $("#id-form").on("keyup",function(){
        let id = $("#id-form").val().trim();
        if (id.length == 0) {
            $("#idCheck-msg").html("").attr("value", "N");
        }
    });

    //비밀번호 유효성 검사
    $("#pass-form").on("keyup",function(){
        $("#passCheck-msg").css("margin-top", "5px");
        let passRegExp = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,20}$/;
        let pass = $(this).val().trim();

        if(passRegExp.test(pass) && pass.length > 0){
            $("#passCheck-msg").html("사용가능한 비밀번호입니다.").css("color", "blue").attr("value", "Y");
        } else if(!passRegExp.test(pass) && pass.length > 0){
            $("#passCheck-msg").html("8~20자의 영문 대소문자+숫자+특수문자를 사용하세요.").css("color", "red").attr("value", "N");
        } else{
            $("#passCheck-msg").html("").attr("value", "N");
        }
    });

    // 비밀번호 일치 확인
    $("#passCheck-form").on("keyup",function(){
        $("#passCheck-msg2").css("margin-top", "5px");
        if($("#pass-form").val() != $(this).val().replace(/\s/gi,"")){
            $("#passCheck-msg2").html("비밀번호가 일치하지 않습니다.").css("color", "red").attr("value", "N");
        }else if($("#pass-form").val() == $(this).val().replace(/\s/gi,"")){
            $("#passCheck-msg2").html("비밀번호가 일치합니다.").css("color", "blue").attr("value", "Y");
        }else{
            $("#passCheck-msg2").html("").attr("value", "N");
        }
    });

    //이름 유효성 검사
    $("#name-form").on("keyup",function(){
        $("#nameCheck-msg").css("margin-top", "5px");
        let nameRegExp = /^[가-힣]{2,}$/;
        let name = $("#name-form").val().trim();

        if(!nameRegExp.test(name) && name.length > 0){
            $("#nameCheck-msg").html("2자 이상의 한글만 사용 가능합니다.").css("color", "red").attr("value", "N");
        } else if(name.length == 0) {
            $("#nameCheck-msg").html("").attr("value", "N");
        } else{
            $("#nameCheck-msg").html("").attr("value", "Y");
        }
    });

    //이메일 셀렉트 박스 선택 후 유효성 검사
    $(".email-option").change(function() {
        let emailRegExp = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9-]+[.][A-Za-z]{2,6}$/;
        let val_split = $("#email-form").val().split('@')[0] //select box 다시 선택 시 @부터 제거 후 다른 값 들어가게
        let email = $("#email-form").val(val_split + $(".email-option").val());

        if(!emailRegExp.test(email) && email.length > 1){ //length > 0 으로 하면 스크립트 안먹음... 하...
            $("#emailCheck-msg").html("이메일 형식이 올바르지 않습니다.").css("color", "red").attr("value", "N");
        } else if (email.length == 0) {
            $("#emailCheck-msg").html("").attr("value", "N");
        } else {
            $("#emailCheck-msg").html("").attr("value", "Y");
        }
    });

    //이메일 유효성 검사
    $("#email-form").on("keyup",function(){
        $("#emailCheck-msg").css("margin-top", "5px");
        let emailRegExp = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9-]+[.][A-Za-z]{2,6}$/;
        let email = $("#email-form").val().trim();

        if(!emailRegExp.test(email) && email.length > 0){
            $("#emailCheck-msg").html("이메일 형식이 올바르지 않습니다.").css("color", "red").attr("value", "N");
        } else if (email.length == 0) {
            $("#emailCheck-msg").html("").attr("value", "N");
        } else {
            $("#emailCheck-msg").html("").attr("value", "Y");
        }
    });

    //휴대폰 번호 유효성 검사
    $("#hp-form").on("keyup",function(){
        $("#hpCheck-msg").css("margin-top", "5px");
        //자동하이픈 + 숫자가 아니면 입력 불가
        $(this).val($(this).val()
            .replace(/[^0-9]/g, "")
            .replace(/(^02|^0505|^1[0-9]{3}|^0[0-9]{2})([0-9]+)?([0-9]{4})$/,"$1-$2-$3")
            .replace("--", "-"));

        let hpRegExp = /^01(?:0|1|[6-9])(-)(\d{3}|\d{4})(-)(\d{4})$/;
        let hp = $("#hp-form").val().trim();

        if(!hpRegExp.test(hp) && hp.length > 0){
            $("#hpCheck-msg").html("휴대폰 번호 형식이 올바르지 않습니다.").css("color", "red").attr("value", "N");
        } else if (hp.length == 0) {
            $("#hpCheck-msg").html("").attr("value", "N");
        } else {
            $("#hpCheck-msg").html("").attr("value", "Y");
        }
    });

});

//유효성 최종 체크
function fn_lastCheck(f){
    let check1 = $("#idCheck-msg").attr("value");
    let check2 = $("#passCheck-msg").attr("value");
    let check3 = $("#passCheck-msg2").attr("value");
    let check4 = $("#nameCheck-msg").attr("value");
    let check5 = $("#emailCheck-msg").attr("value");
    let check6 = $("#hpCheck-msg").attr("value");

    if(check1 == "N"){
        alert("아이디 중복체크를 해주세요");
        return false;
    } else if (check2 == "N" || check3 == "N") {
        alert("유효하지 않은 비밀번호입니다.");
        return false;
    } else if (check4 == "N") {
        alert("유효하지 않은 이름입니다.")
        return false;
    } else if (check5 == "N") {
        alert("유효하지 않은 이메일입니다.")
        return false;
    } else if (check6 == "N") {
        alert("유효하지 않은 휴대폰 번호입니다.")
        return false;
    }
    return true;
}

//취소버튼 이벤트
function fn_cancel(){
    let check = confirm("작성한 정보는 저장되지 않습니다. \n 홈 화면으로 이동하시겠습니까?")
    if(!check){
        return false;
    }
    return location.href="/";
}
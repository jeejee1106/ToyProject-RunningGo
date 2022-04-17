$(function () {

    //지하철 역 검색
    $("#subway-search-btn").click(function (){
        let subwayName = $("#subway").val().trim();
        if (subwayName.length == 0) {
            $("#lineNum-list").html("지하철역 명을 입력하세요.").attr("class", "write-msg").attr("value", "N");
            return;
        }
            $.ajax({
                url: "/place/subway_search",
                type: "get",
                dataType: "text",
                data : {"subwayName" : subwayName},
                contentType: "application/x-www-form-urlencoded; charset=UTF-8",

                success:function(data){
                    if (data == "error") {
                        $("#subway").val("").focus();
                        $("#lineNum-list").empty().html("역 명을 올바르게 입력하세요.").attr("class", "write-msg").attr("value", "N");
                    } else{
                        // $("lineNum-list").attr("value", "Y");
                        let subwayName2 = data.split("#");

                        $("#lineNum-list").empty().attr("value", "Y");

                        for (let i = 1; i <= subwayName2[i].length; i++) {

                            if (subwayName2[i] == "경의선") {
                                subwayName2[i] = subwayName2[i].replace("경의선", "010호선");
                            } else if(subwayName2[i] == "수인분당선"){
                                subwayName2[i] = subwayName2[i].replace("수인분당선", "011호선");
                            } else if (subwayName2[i] == "우이신설경전철") {
                                subwayName2[i] = subwayName2[i].replace("우이신설경전철", "012호선");
                            } else if (subwayName2[i] == "신분당선") {
                                subwayName2[i] = subwayName2[i].replace("신분당선", "013호선");
                            } else if (subwayName2[i] == "공항철도") {
                                subwayName2[i] = subwayName2[i].replace("공항철도", "014호선");
                            }

                            for (let j = 1; j < 15; j++) {
                                if(subwayName2[i] == "0" + j + "호선") {
                                    $("#lineNum-list").append("<img class='lineNum-img' src=/img/line" + j + ".png/>");
                                }
                            }
                        }
                    }

                },
                error:function(request,status,error){
                    alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
                }
            });
    });

    //지하철 검색 통과 후 value=Y 상태에서 문자열을 지웠을 때 value=N 이 나오도록
    $("#subway").on("keyup",function(){
        let subway = $("#subway").val().trim();
        if (subway.length == 0) {
            $("#lineNum-list").attr("value", "N");
        }
    });

    //난이도 클릭 이벤트
    $(".btn-level").click(function () {

        let level = $(this).val();
        $("#level-val").attr("value", level);

        $(this).css({"background" : "#2146d0", "color" : "#ffffff"});
        $(this).siblings().css({"background" : "#ffffff", "color" : "black"});

    });

    //짐 보관 가능할 시 input태그 show
    $("input:radio[name=storage-YN]").click(function(){

        if($("input[name=storage-YN]:checked").val() == "Y"){
            $(".storage-place").show();
            $("#storage-place").attr("required", "required");
        }else {
            $(".storage-place").hide();
            $("#storage-place").attr("required" , false);

        }
    });

    //
    $("#distance").on("keyup",function(){
        // $(this).val($(this).val().replace(/[^0-9.]/g, ""));
        let distanceRegExp = /(^\d+$)|(^\d{1,}.\d{0,1}$)/; ;
        let distance = $("#distance").val().trim();

        if(!distanceRegExp.test(distance) && distance.length > 0){
            $("#distanceCheck-msg").html("자연수 또는 소수점 한자리까지 표현 가능합니다.").css("color", "red").attr("value", "N");
        } else if (distance.length == 0) {
            $("#distanceCheck-msg").html("").attr("value", "N");
        } else if (distance < 1 || distance > 99) {
            $("#distanceCheck-msg").html("1 이상 99 이하의 숫자만 입력해주세요.").css("color", "red").attr("value", "N");
        } else {
            $("#distanceCheck-msg").html("").attr("value", "Y");
        }
    });

});

// 게시글 업로드 시 유효성 최종 체크
function place_lastCheck(){
    let check1 = $("#lineNum-list").attr("value");
    let check2 = $("#level-val").attr("value");

    if(check1 == "N"){
        alert("지하철 역을 검색해주세요.");
        return false;
    } else if (check2 == "N") {
        alert("코스 난이도를 선택해주세요.");
        return false;
    }

    return true;
}
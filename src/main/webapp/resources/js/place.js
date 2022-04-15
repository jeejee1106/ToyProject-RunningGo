$(function () {

    //지하철 역 검색
    $("#subway-search-btn").click(function (){
        let subwayName = $("#subway").val().trim();
        if (subwayName.length == 0) {
            $("#lineNum-list").html("지하철역 명을 입력하세요.").attr("class", "write-msg");
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
                        $("#lineNum-list").empty().html("역 명을 올바르게 입력하세요.").attr("class", "write-msg");
                    } else{
                        let aa = data.split("#");

                        $("#lineNum-list").empty();

                        for (let i = 1; i <= aa[i].length; i++) {

                            if (aa[i] == "경의선") {
                                aa[i] = aa[i].replace("경의선", "010호선");
                            } else if(aa[i] == "수인분당선"){
                                aa[i] = aa[i].replace("수인분당선", "011호선");
                            } else if (aa[i] == "우이신설경전철") {
                                aa[i] = aa[i].replace("우이신설경전철", "012호선");
                            } else if (aa[i] == "신분당선") {
                                aa[i] = aa[i].replace("신분당선", "013호선");
                            } else if (aa[i] == "공항철도") {
                                aa[i] = aa[i].replace("공항철도", "014호선");
                            }

                            for (let j = 1; j < 15; j++) {
                                if(aa[i] == "0" + j + "호선") {
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

    //난이도 클릭 이벤트
    $(".btn-level").click(function () {

        let level = $(this).val();
        $("#level-val").attr("value", level);

        $(this).css({"background" : "#2146d0", "color" : "#ffffff"});
        $(this).siblings().css({"background" : "#ffffff", "color" : "black"});

    });

    //짐 보관 장소 input 숨김
    $(".storage-place").hide();

    //짐 보관 가능할 시 input태그 show
    $("input:radio[name=storage-YN]").click(function(){

        if($("input[name=storage-YN]:checked").val() == "Y"){
            $(".storage-place").show();
        }else {
            $(".storage-place").hide();
        }
    });

});

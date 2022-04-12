$(function () {

    //지하철 역 검색
    $("#subway-search-btn").click(function (){
        let subwayName = $("#subway").val().trim();
            $.ajax({
                url: "/place/subway_search",
                type: "get",
                dataType: "text",
                data : {"subwayName" : subwayName},
                contentType: "application/x-www-form-urlencoded; charset=UTF-8",

                success:function(data){
                    if (data == "error") {
                        alert("역 명을 올바르게 입력하세요")
                        $("#subway").val("").focus();
                        $("#lineNum-list").empty();
                    } else{
                        let aa = data.split("#");

                        $("#lineNum-list").empty();

                        for (let i = 1; i < aa[i].length; i++) {

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


                            if(aa[i] == "01호선") {
                                $("#lineNum-list").append("<img class='lineNum-img' src=/img/line1.png/>");
                            } else if(aa[i] == "02호선") {
                                $("#lineNum-list").append("<img class='lineNum-img' src=/img/line2.png/>");
                            } else if(aa[i] == "03호선") {
                                $("#lineNum-list").append("<img class='lineNum-img' src=/img/line3.png/>");
                            } else if(aa[i] == "04호선") {
                                $("#lineNum-list").append("<img class='lineNum-img' src=/img/line4.png/>");
                            } else if(aa[i] == "05호선") {
                                $("#lineNum-list").append("<img class='lineNum-img' src=/img/line5.png/>");
                            } else if(aa[i] == "06호선") {
                                $("#lineNum-list").append("<img class='lineNum-img' src=/img/line6.png/>");
                            } else if(aa[i] == "07호선") {
                                $("#lineNum-list").append("<img class='lineNum-img' src=/img/line7.png/>");
                            } else if(aa[i] == "08호선") {
                                $("#lineNum-list").append("<img class='lineNum-img' src=/img/line8.png/>");
                            } else if(aa[i] == "09호선") {
                                $("#lineNum-list").append("<img class='lineNum-img' src=/img/line9.png/>");
                            } else if(aa[i] == "010호선") {
                                $("#lineNum-list").append("<img class='lineNum-img' src=/img/line10.png/>");
                            } else if(aa[i] == "011호선") {
                                $("#lineNum-list").append("<img class='lineNum-img' src=/img/line11.png/>");
                            } else if(aa[i] == "012호선") {
                                $("#lineNum-list").append("<img class='lineNum-img' src=/img/line12.png/>");
                            } else if(aa[i] == "013호선") {
                                $("#lineNum-list").append("<img class='lineNum-img' src=/img/line13.png/>");
                            } else if(aa[i] == "014호선") {
                                $("#lineNum-list").append("<img class='lineNum-img' src=/img/line14.png/>");
                            }
                        }
                    }

                },
                error:function(request,status,error){
                    alert("에러....")
                    alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
                }
            })
    });

});

$(function () {

    //지하철 역 검색
    $("#subway-search-btn").click(function (){
        let subwayName = $("#subway").val().trim();
            $.ajax({
                url: "/place/subway_search",
                type: "get",
                dataType: "json",
                data : {"subwayName" : subwayName},
                contentType: "application/x-www-form-urlencoded; charset=UTF-8",

                success:function(data){
                    alert(data.SearchInfoBySubwayNameService.RESULT.MESSAGE);

                    alert(data.SearchInfoBySubwayNameService.row.STATION_NM);
                    alert(data.SearchInfoBySubwayNameService.RESULT.CODE);
                    
                },
                error:function(request,status,error){
                    alert("에러....")
                    alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
                }
            })
    });

});

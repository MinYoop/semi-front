
$(function(){
$("#emp_search").click(function(){
$.ajax({
url:"http://openapi.seoul.go.kr:8088/4c52546a706a65613934595a6a7a45/xml/GreenMarketInfo/1/150",
method: "get",
dataType:"xml",
success:function(data){
var tagName = new Array();
var rows = $(data).find("row");
if($(".INX").val() == "송파구" || $(".INX").val() == "금천구" || $(".INX").val() == "양천구" || $(".INX").val() == "동작구" || $(".INX").val() == "동대문구" || $(".INX").val() == "노원구" || $(".INX").val() == "강서구" || $(".INX").val() == "영등포구" || $(".INX").val() == "강남구" || $(".INX").val() == "서대문구" || $(".INX").val() == "종로구" || $(".INX").val() == "강동구" ){
$table = $("<table border=1>");
for(var i = 0; i<1 ; i++){
$tr = $("<tr>");
for(var i = 0; i<7; i++){
$td = $("<th>").append($(data).find("row").children().eq(i).prop("tagName"));
$tr.append($td);
}
$table.append($tr);
}

            for(var i = 0 ; i < rows.length; i++){
                $tr  = $("<tr>");
                if(rows.eq(i).children().eq(1).text() == $(".INX").val()){
                    for(var j = 0; j < rows.eq(i).children().length; j++){
                        $td = $("<th>").append(rows.eq(i).children().eq(j).text());
                        $tr.append($td);
                        $table.append($tr);
                    }
                }
            }
        }else{
            alert("존재하지 않는 정보입니다.");
        }
            if($(".chkchk").children().eq(3).prop("tagName") == "TABLE"){
                $(".chkchk").children().eq(3).remove();
                $(".chkchk").append($table);

            }else{
                $(".chkchk").append($table);
            }
        },
        error:function(request,error){
            alert(request.status+" " + error);
        }
    });

});
});

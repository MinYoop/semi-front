$(document).ready(function(){
   $("#emp_search").on("change",function(){
      $.ajax({
         url:"http://openapi.seoul.go.kr:8088/4c52546a706a65613934595a6a7a45/xml/GreenMarketInfo/1/150",
         method: "get",
         dataType:"xml",
         success:function(data){
            $(".chkchk").html("");
            var tagName = new Array();
            var rows = $(data).find("row");
            var options = document.getElementById("emp_search");
            var guname="";
            for(var i = 0 ; i < options.length ; i++){
               if(options[i].selected){
                  guname = options[i].value;
               }
            }
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
               if(rows.eq(i).children().eq(1).text() == guname){
                  for(var j = 0; j < rows.eq(i).children().length; j++){
                     $td = $("<th>").append(rows.eq(i).children().eq(j).text());
                     $tr.append($td);
                     $table.append($tr);
                  }
               }
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
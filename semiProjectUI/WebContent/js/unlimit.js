window.onload = function(){
	
$.ajax({
		
		url: "servlet.do?command=settingItem",
		cache: false,
		async:false,
		success: function(html){
			
			
				
				$('#limit').append(html);				
		},
		error:function(){
			alert("초기매물받기 실패");
			
		}
    })
    return false;
}   



// 무한스크롤 인식

var count = 5;
$(document).ready(function () {
	  $(document).scroll(function() {
		var maxHeight = $(document).height();
	    var currentScroll = $(window).scrollTop() + $(window).height();

	    if(maxHeight <= currentScroll + 50) {	
	    	
	    	$('html, body').animate({scrollTop : currentScroll-1000});				
			
	    	infiniteScroll();
	       
	    }
	    
	  
	  })
	});


//스크롤 감지 및 호출
function infiniteScroll(){
		count++;	
		loadArticle(count);
		
}

String.prototype.trim = function () { //trim
	
    return this.replace(/^\s+|\s+$/g, "");

}



// ajax 로드
function loadArticle(pageNumber){	
	
    $.ajax({
		
		url: "servlet.do?command=limit&page="+pageNumber,
		cache: false,
		success: function(html){
			
			if(html.trim()=="nomoreitem"){
				document.getElementById("nomoreitem").innerHTML="더 이상 등록된 매물이 없습니다."

			}else{
				/*setTimeout(function(){ // 시간 지연
					$('#limit').append(html);					
				}, 300);*/
				
				$('#limit').append(html);	
			}
			
		},
		error:function(){
			
		}
    });
	return false;
}


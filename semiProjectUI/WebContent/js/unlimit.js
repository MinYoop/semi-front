   // 무한스크롤 인식

var count = 2;
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
		
		loadArticle(count);
		count++;	
}

// ajax 로드
function loadArticle(pageNumber){	
	
    $.ajax({
		
		url: "servlet.do?command=limit&page="+pageNumber,
		cache: false,
		success: function(html){
			setTimeout(function(){ // 시간 지연
				$('#limit').append(html);
				
			}, 1000);
		},
		error:function(){
			alert("실패");
		}
    });
	return false;
}


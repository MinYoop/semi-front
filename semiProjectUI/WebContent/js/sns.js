const lochkforindex = () =>{
	
	$.ajax({	
		url:"usr.do",
		method:"post",
		datatype: "json",
		data : {
			"command" : "isNew"
		}, 
		success: function(res){
			if(res!=true){// 세션 존재. favs 와 basket 공간에 html
				$(".favs").html(res.favs);// java단에서 존나 정리하고 붙여서 json으로 보내기.
				$(".basket").html(res.basket);// java단에서 존나 정리하고 붙여서 json으로
												// 보내기.
			
			} else{}// 세션 부존재. 서블릿서 세션 생성됨 .
			  fbstate();
			// 페북이면 권한 확인해서 로긴까지. 네이버는 가입했어도 로긴버튼 눌러야 함.
			}
	});}
				


let fbstate = function(){ FB.getLoginStatus(function(response){
        	statusChangeCallback(response);
        });
  }
  
  

      function statusChangeCallback(response){
    	
		  if(response.status==='connected'){
			 
			  console.log('Logged in and authenticated');
			  setTimeout(function(){$("#subscriptionModal").modal('hide');},2000);
			 isSessionHasUsr()// 로긴여부 확인 (세션에 usr 있나)
								
		  } else if(response.status===''){
			  console.log('Not authenticated')
		  }
	  }

		
const isSessionHasUsr = () =>{
	
	$.post("usr.do?command=isSessionHasUsr",function(data){
		console.log("세션이 유저를 가지고 있을까? "+data)
		if(data>0){
			$.ajax({
				url:"Message.do",
				data:{
					command:"chkMessage"
				},
				success: function(data){
					/*if(data>0){*/
					$(".badge-danger").html("<button style='background-color"
							+":black;color:white' type='button' onClick='Message.do?command=msgFirstPage'class='btn-xs'>" 
							+"새 메세지 <span class='badge badge-danger badge-pill'>"+data+"</span>");
				//	}
				},
					error : function(e){
						console.log(e);
					}

			})}
 }
)}
		
		
		function getFBIdAndLogin(){ FB.api('/me?fields=id',function(response){
			  if(response && !response.error){
				  console.log(response);
				  location.href="usr.do?command=login&sns=FB&snsId="+ response.id;
				  
			  }
		  }) 
		}
			
		 function logchk(sns,snsid){ 
						  lochkforindex(sns,snsid);
					  }


		let isUs = () =>{ FB.api('/me?fields=id',function(response){
			if(response && !response.error){
				$.post("usr.do?command=isUs&sns=FB&snsId="+response.id,function(res){
					console.log(res);
					if(res>0){ 
						location.href="usr.do?command=login&sns=FB&snsId="+ response.id;
					} else{
						  
						  location.href="usr.do?command=signInPage&sns=FB&snsId="+response.id;
					}
				});
			}
		})
		
		}
			
		
			
			isSessionHasUsr();
			lochkforindex();
			
			FB.Event.subscribe('auth.statusChange', function(response) {
				  if(response.status==='connected'){
						 
					  console.log('Logged in and authenticated');
					  setTimeout(function(){$("#subscriptionModal").modal('hide');},2000);
					  
					 isSessionHasUsr();
								
				  } else if(response.status===''){
					  console.log('Not authenticated')
				  }

			});
			
			
			
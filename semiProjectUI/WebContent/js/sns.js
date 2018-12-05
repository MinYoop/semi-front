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
  
  
// Promise.resolve().then(fbgogo(fbstate));

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
			$.post("Message.do?command=unchked", function(data){
				$(".msgchkarea").html(data);
				},"text");// 메세지 체크 안 한 개수 확인
			console.log("세션에 유저가 있습니다.")
		} else{
			console.log("세션에 유저가 없어요.")
			 isUs();
		}
	});
 }
		
		
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
			
		
		
		// 네이버
		var naverLogin = new naver.LoginWithNaverId(
				{
					clientId: "AIOJsfO8McQfNj7Mv65y",
					callbackUrl: "http://localhost:8787/semiProjectUI/signin.jsp",
					isPopup: false, /* 팝업을 통한 연동처리 여부 */
					loginButton: {color: "green", type: 3, height: 60} /*
																		 * 로그인
																		 * 버튼의
																		 * 타입을
																		 * 지정
																		 */
				}
			);
			
			/* 설정정보를 초기화하고 연동을 준비 */
			naverLogin.init();
			
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
			
			
			
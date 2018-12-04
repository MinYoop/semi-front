










import {msgchk} from './js/msgchk.js';
import {favschk} from './js/favschk.js';
import {basketchk} from './js/basketchk.js';

const lochk = () =>{
	if($(".cryptUsr").val()!=null){
	$.ajax({//cryptUsr를 보내 제대로 된 cryptUsr값인지 확인  
		url:"usr.do",
		method:"post",
		data : {
			"command" : "loginchk",
			"cryptUsr" : $("#cryptUsr").val()
		}, 
		success: function(res){
			if(res>0){
				setTimeout(function(){$("#subscriptionModal").modal('hide');},3000);	//인덱스화면용
				msgchk();
				favschk();
				basketchk();
			} else if(res=0){
				alert("살려주세요 ");
			} else{
				alert("로그인이 필요합니다.");	//로그인 전용화면들용 
				$.ajax({	//로그인 전용화면들용 
					url:"usr.do",	//로그인 전용화면들용 
					method:"post",	//로그인 전용화면들용 
					data:{	//로그인 전용화면들용 
						"command":"logout"	//로그인 전용화면들용 
					}	//로그인 전용화면들용 
					
				});	//로그인 전용화면들용 
			}
			
		}, error: function(e){
			alert("error : "+ e);
		}
	
	})
	} else{
		
	
}}

//아래부터 변용버전들 
//cryptUsr를 받아와서 $('body').append("<input type='hidden' name='cryptUsr' value='"+result.cryptUsr+"'>"); 라고 붙여주기. 



				
				
				
				
				
				/*
			 var fbid = getfbid();
				$.ajax({	
					url:"usr.do",	
					method:"post",	
					data:{	
						"command":"login",
						"sns" : sns ,
						"snsId" : snsId
					}, success:function(res){
						if(res>0){//회원 확인되었으므로 서블릿에서 로그인하여 세션 세팅되었고 페이지세팅작업 
							$('body').append("<input type='hidden' name='cryptUsr' value='"+res+"'>");
							setTimeout(function(){$("#subscriptionModal").modal('hide');},3000);	//인덱스화면용
							userboot();
						} else{
							alert("회원가입 작업이 완료되지 않았습니다. 회원가입을 완료해주세요. ");
							$.ajax({	
								url:"usr.do",	
								method:"post",	
								data:{	
									"command":"signinpage",
									"sns" : sns ,
									"snsId" : snsId
								}})
						}
					}	
				});	
			}
			
		}, error: function(e){
			alert("error : "+ e);
		}
	
	})
	} else{
		
	
}
	
}




function userboot(){
	msgchk();
	favschk();
	basketchk();
}


*/
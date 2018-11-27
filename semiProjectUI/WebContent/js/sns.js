
/**
 * 
 * if (typeof facebookInit == 'function') {
        facebookInit();
    }

FB.getLoginStatus(function(response){
	statusChangeCallback(response);
});


function statusChangeCallback(response){
  if(response.status==='connected'){
	  console.log('Logged in and authenticated');
  } else {
	  console.log('Not authenticated');
  }
}

function checkLoginState() {
FB.getLoginStatus(function(response) {
	statusChangeCallback(response);
});
}
*/

  let fbstate = function(){ FB.getLoginStatus(function(response){
        	statusChangeCallback(response);
        });
  }
  

      function statusChangeCallback(response){
		  if(response.status==='connected'){
			  console.log('Logged in and authenticated');
			  setTimeout(function(){$("#subscriptionModal").modal('hide');},3000);
			  regchk();
		  } else if(response.status===''){
			  console.log('Not authenticated');
		  }
	  }

		function checkLoginState() {
		FB.getLoginStatus(function(response) {
			statusChangeCallback(response);
		});
		}
	

		var naverLogin = new naver.LoginWithNaverId(
				{
					clientId: "7d54a380d44fc4335738259b6e2dc63c",
					callbackUrl: "http://localhost:8787/ojoproject/api/member/naver.jsp",
					isPopup: false, /* 팝업을 통한 연동처리 여부 */
					loginButton: {color: "green", type: 3, height: 60} /* 로그인 버튼의 타입을 지정 */
				}
			);
			
			/* 설정정보를 초기화하고 연동을 준비 */
			naverLogin.init();
			
			
	
			

/**
 * 
 */
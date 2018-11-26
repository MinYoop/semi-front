
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
let fbgogo = function(fb){

(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = 'https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v3.2&appId=416848035516774&autoLogAppEvents=1';
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));
fb();};

  let fbstate = function(){ FB.getLoginStatus(function(response){
        	statusChangeCallback(response);
        });
  }
  
  fbgogo(fbstate);

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
	


/**
 * 
 */
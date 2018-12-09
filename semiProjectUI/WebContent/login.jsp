<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- mobile responsive meta -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- ** Plugins Needed for the Project ** -->
<!-- Bootstrap -->
<link rel="stylesheet" href="plugins/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="plugins/themify-icons/themify-icons.css">
<link rel="stylesheet" href="plugins/slick/slick.css">
<link rel="stylesheet" href="plugins/venobox/venobox.css">
<link rel="stylesheet" href="plugins/animate/animate.css">
<link rel="stylesheet" href="plugins/aos/aos.css">
<link rel="stylesheet"
	href="plugins/bootstrap-touchspin-master/jquery.bootstrap-touchspin.min.css">
<link rel="stylesheet" href="plugins/nice-select/nice-select.css">
<link rel="stylesheet"
	href="plugins/bootstrap-slider/bootstrap-slider.min.css">

<!-- Main Stylesheet -->
<link href="css/style.css" rel="stylesheet">

<!--Favicon-->
<link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">
<link rel="icon" href="images/favicon.png" type="image/x-icon">
<script type="text/javascript"
	src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<style>
</style>
</head>

<body>

	<!-- preloader start -->
	<div class="preloader">
		<img src="images/preloader.gif" alt="preloader">
	</div>
	<!-- preloader end -->

	<section class="signin-page account">
		<div class="container">
			<div class="row">
				<div class="col-md-6 mx-auto">
					<div class="block text-center">
						<a class="logo" href="index.html"> <img src="images/logo.png"
							width="100px" height="50px" alt="logo">
						</a>
						<h2 class="text-center">Come in here!</h2>
						<div class="form-group">
							<input type="hidden" class="form-control" placeholder="Email">
						</div>
						<div class="form-group">
							<input type="hidden" class="form-control" placeholder="Password">
						</div>
						<a id="custom-login-btn" href="javascript:loginWithKakao()"> <img
							src="//mud-kage.kakao.com/14/dn/btqbjxsO6vP/KPiGpdnsubSq3a0PHEGUK1/o.jpg"
							width="300" /></a>
						<div id="naverIdLogin" class="my-3"></div>
						<script type="text/javascript"
							src="//connect.facebook.net/ko_KR/all.js#xfbml=1&appId=416848035516774"
							id="facebook-jssdk"></script>
						<div class="fb-login-button" data-width="277" data-max-rows="1"
							data-size="large" data-button-type="login_with"
							data-show-faces="false" data-auto-logout-link="true"
							data-use-continue-as="false"></div>
					</div>
			
				</div>
			</div>
		</div>

	</section>


	<!-- /main wrapper -->

	<!-- jQuery -->
	<!-- Bootstrap JS -->
	<script src="plugins/bootstrap/bootstrap.min.js"></script>
	<script src="plugins/slick/slick.min.js"></script>
	<script src="plugins/venobox/venobox.min.js"></script>
	<script src="plugins/aos/aos.js"></script>
	<script src="plugins/syotimer/jquery.syotimer.js"></script>
	<script src="plugins/instafeed/instafeed.min.js"></script>
	<script src="plugins/zoom-master/jquery.zoom.min.js"></script>
	<script
		src="plugins/bootstrap-touchspin-master/jquery.bootstrap-touchspin.min.js"></script>
	<script src="plugins/nice-select/jquery.nice-select.min.js"></script>
	<script src="plugins/bootstrap-slider/bootstrap-slider.min.js"></script>
	<!-- google map -->
	<script src="plugins/google-map/gmap.js"></script>
	<!-- Main Script -->
	<script src="js/script.js"></script>
	<script src="js/sns.js"></script>
			<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
					<script type="text/javascript">

Kakao.init('9cf5622e3400d24c091a552cd507d917');
let loginWithKakao = () =>{
	Kakao.Auth.login({
        success: function(authObj) {
          console.log(JSON.stringify(authObj));
          
    Kakao.API.request({
      url: '/v2/user/me',
      success: function(resp) {
        console.log(JSON.stringify(resp));
        if(resp && !resp.error){
        $.post("usr.do?command=isUs&sns=DK&snsId="+resp.id,function(res){
			console.log(res);
			if(res>0){ 
				location.href="usr.do?command=login&sns=DK&snsId="+ resp.id;
			} else{
				  
				  location.href="usr.do?command=signInPage&sns=DK&snsId="+resp.id;
			}
		});
        }
      },
      fail: function(error) {
        alert(JSON.stringify(error));
      }
    });
  },
  fail: function(err) {
    alert(JSON.stringify(err));
  }
});}




var naverLogin = new naver.LoginWithNaverId(
		{
			clientId: "AIOJsfO8McQfNj7Mv65y",
			callbackUrl: "http://localhost:8787/semiProjectUI/signin.jsp",
			isPopup: false,
			loginButton: {color: "green", type: 3, height: 60} 
													
		}
	);
	
	naverLogin.init();
	
	

</script>
</body>

<!-- Mirrored from demo.themefisher.com/themefisher/elite-shop/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 21 Nov 2018 12:11:31 GMT -->
</html>
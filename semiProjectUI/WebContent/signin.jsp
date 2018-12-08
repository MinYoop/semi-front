<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>


<!DOCTYPE html>
<html lang="zxx">


<head>
<meta charset="utf-8">
<title>Elite Shop</title>

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

</head>

<body>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js"
	charset="utf-8"></script>
	
	<script type="text/javascript">
	
	var naver_id_login = new naver_id_login("AIOJsfO8McQfNj7Mv65y", "http://localhost:8787/semiProjectUI/signin.jsp");
	  // 접근 토큰 값 출력
	  
	  // 네이버 사용자 프로필 조회
	  naver_id_login.get_naver_userprofile("naverSignInCallback()");
	  // 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
	  function naverSignInCallback() {
		
		$(".email").val(naver_id_login.getProfileData('email'));
	   $(".snsId").val(naver_id_login.getProfileData('id'));
	   $(".sns").val('NV');
	   $.ajax({
	      url : "../../nvlogin",
	      
	      method : "post",
	      data : {"data" : JSON.stringify(
	      { 
	      	id : naver_id_login.getProfileData('id'),
	      	nickname : naver_id_login.getProfileData('nickname'),
	     	email : naver_id_login.getProfileData('email'),
	     	age : naver_id_login.getProfileData('age')
	      }) },
	      success : function(data){
	    	  $(".joinus").append("<b>"+naver_id_login.getProfileData('nickname')+"님 환영합니다.</b><br/><br/>"+
	    			  "가입을 완료하시려면 추가 정보가 필요합니다.<br/>");
	    	  
	    	  $(".wait").css("display","none");
	    	  $(".nvform").css("display","block");
	    	  
	        
	      },
	      error : function(request,status, error){
	        alert(request.status+" : " +error);
	        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	        alert("실패! 다음 기회에...") 
	      }

	    })
	  }
	  
	  </script>

	<!-- preloader start -->
	<div class="preloader">
		<img src="images/preloader.gif" alt="preloader">
	</div>
	<!-- preloader end -->
	<section class="signin-page account">
		<div class="container" id="legogogo">
			<div class="row" id="legogogo2">
				<div class="col-md-6 mx-auto">
					<div class="block text-center">
						<a class="logo" href="index.html"> <img src="images/logo.png"
							alt="logo" width="100" height="50">
						</a>
						<h2 class="text-center">We wanna know little more about you...!</h2>
						<form class="text-left clearfix" method="post" action="usr.do?command=signin">
							<div class="form-group">
								<input type="text" class="form-control" name="nickName"
									placeholder="NickName">
							</div>
							<div class="form-group">
								<input class = "email" type="email" class="form-control" name="email"
									placeholder="Email">
							</div>
							<div class="form-group">
								<input type="text" class="form-control" name="address1" id="address1"
									placeholder="Address" readonly="readonly" onclick="goPopup()" value="">
							<b> 우편번호 </b><input style="align-item:center;color:grey" id="zipCode" name="zipCode" class="mt-2" type="text" size="10" readonly="readonly"></div>
							<div class="form-group">
								<input type="text" class="form-control" name="address2" id="addrDetail"
									placeholder="Address detail">
							</div>

							<div class="form-group">
								<input type="hidden" class="form-control snsId" name="snsId"
									value=${param.snsId }>
							</div>
							<div class="form-group">
								<input type="hidden" class="form-control" name="sns"
									value=${param.sns }>
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-primary">Sign In</button>
							</div>
							<div id="reggogo1"></div>
							<div id="reggogo2"></div>
							<input type="hidden" name="homeLat" id="homeLat" value=""> 
							<input type="hidden" name="homeLon" id="homeLon" value=""> 
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>

	</div>
	<!-- /main wrapper -->

	<!-- jQuery -->
	<script src="plugins/jQuery/jquery.min.js"></script>
	
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
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b649a06a2d0d11606e17caaae9dd77ed&libraries=services"></script>
	
<script type="text/javascript">
	  function goPopup(){
		var pop = window.open("../../popup/jusopopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes");
		}
		function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn , detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn, buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo){
		$("#roadAddrPart1").val(roadAddrPart1); 
		$("#addrDetail").val(addrDetail); 
		$("#zipNo").val(zipNo);
		}
	  
	
		function goPopup(){
		var pop = window.open("jusopopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes");
		}
		function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn , detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn, buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo){
		$("#address1").val(roadAddrPart1); 
		$("#addrDetail").val(addrDetail); 
		$("#zipCode").val(zipNo);
		
		var geocoder = new daum.maps.services.Geocoder();
		var callback = function(result, status) {
		    if (status === daum.maps.services.Status.OK) {
		    	console.log(result);
		    	$("#homeLat").val(result[0].y);
		    	$("#homeLon").val(result[0].x);

		    } else{alert("에라...");}
		}

	setTimeout(geocoder.addressSearch($("#address1").val(), callback),0);
		}
	
		
		</script>
	
	
	
</body>

</html>
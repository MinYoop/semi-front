<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>  


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 


<!DOCTYPE html>
<html lang="zxx">


<head>
<meta charset="utf-8">
<title>IUTRADE</title>

<!-- mobile responsive meta -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">


<!--Favicon-->
<link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">
<link rel="icon" href="images/favicon.png" type="image/x-icon">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script type="text/javascript"
	src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js"
	charset="utf-8"></script>
	


</head>

<!-- preloader start -->
<body>


<div id="header"></div>

	<div class="preloader">
		<img src="images/preloader.gif" alt="preloader">
	</div>
	<!-- preloader end -->

	<!-- main wrapper -->
<!-- main wrapper -->
<div class="main-wrapper">

<!-- breadcrumb -->
<nav class="bg-gray py-3">
  <div class="container">
    <ol class="breadcrumb">
      <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
      <li class="breadcrumb-item active" aria-current="page">My Accounts</li>
    </ol>
  </div>
</nav>
<!-- /breadcrumb -->

<section class="user-dashboard section">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <ul class="list-inline dashboard-menu text-center">
     <!-- <li class="list-inline-item"><a href="dashboard.html">Dashboard</a></li>
          <li class="list-inline-item"><a href="order.html">Orders</a></li>
          <li class="list-inline-item"><a href="address.html">Address</a></li> -->     
          <li class="list-inline-item"><a class="active"  href="profile-details.jsp">Profile Details</a></li>
        </ul>
        <div class="dashboard-wrapper dashboard-user-profile">
          <div class="media">
            <div id="staticMap" style="width:400px;height:400px;"></div> 
            <div class="media-body">
              <ul class="user-profile-list">
                <li><span>닉네임</span>${User.nickName}</li>
  <c:choose>
    <c:when test="${User.sns eq 'DK'}">
                <li><span>SNS 로그인</span><img src="images/team/kakao.png" height="30px" width="auto"></li>
    </c:when>
    <c:when test="${User.sns eq 'NV'}">
                <li><span>SNS 로그인</span><img src="images/team/nv.png" height="30px" width="auto"></li>
    </c:when>

    <c:otherwise>
                <li><span>SNS 로그인</span><img src="images/team/facebook.png" height="30px" width="auto"></li>
    </c:otherwise>
</c:choose>
                <li><span>이메일</span>${User.email}</li>
                <li><span>주소</span>${User.address1}</li>
                <li><span>상세주소</span>${User.address2}</li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

	<input type="hidden" id="homelon" value="${User.homeLon }">
	<input type="hidden" id="homelat" value="${User.homeLat }">
	
		<div id="footer"></div>
</div>
	<script src="plugins/bootstrap/bootstrap.min.js"></script>
	<script src="plugins/slick/slick.min.js"></script>
	<script src="plugins/venobox/venobox.min.js"></script>
	<script src="plugins/aos/aos.js"></script>
	<script src="plugins/syotimer/jquery.syotimer.js"></script>
	<script src="plugins/instafeed/instafeed.min.js"></script>
	<script src="plugins/zoom-master/jquery.zoom.min.js"></script>
	<script src="plugins/bootstrap-touchspin-master/jquery.bootstrap-touchspin.min.js"></script>
	<script src="plugins/nice-select/jquery.nice-select.min.js"></script>
	<script src="plugins/bootstrap-slider/bootstrap-slider.min.js"></script>

	<script src="js/script.js"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b649a06a2d0d11606e17caaae9dd77ed"></script>
<script>
var markerPosition  = new daum.maps.LatLng($("#homelat").val(),$("#homelon").val()); 


var marker = {
    position: markerPosition
};

var staticMapContainer  = document.getElementById('staticMap'), 
    staticMapOption = { 
        center: new daum.maps.LatLng($("#homelat").val(),$("#homelon").val()), 
        level: 4, 
        marker: marker
    };    

var staticMap = new daum.maps.StaticMap(staticMapContainer, staticMapOption);
</script>

</body></html></html>
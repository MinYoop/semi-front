<%@ page import ="dto.NoticeBoard" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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
<body>
<script src="js/pasing.js"></script>
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
					<li class="breadcrumb-item"><a href="index.html">Home</a></li>
					<li class="breadcrumb-item active" aria-current="page">Shipping
						Information</li>
				</ol>
			</div>
		</nav>
		<!-- /breadcrumb -->

		<!-- ORDER-REVIEW -->
		<section class="section">
			<div class="container">
				<div class="row">
					<div class="col-md-8">
						<div class="inner-wrapper border-box">
							<!-- navbar -->
							<div class="justify-content-between nav mb-5">
								<a href="shipping.html"
									class="text-center d-inline-block nav-item"> <i
									class="ti-truck d-block mb-2"></i> <span class="d-block h4">ê³µì§ì¬í­</span>
								</a>

								<!-- /navbar -->


								<!-- buttons -->
								<div class="p-4 bg-gray d-flex justify-content-between">
									<a href="payment.html" class="btn btn-dark">Back</a> <a
										href="confirmation.html" class="btn btn-primary">Continue</a>
								</div>

							</div>

							<table  class="inner-wrapper border-box">
								<col width="150">
								<col width="350">
								<col width="150">
								<col width="150">
								<tr>
									<th>1</th>
									<th>2</th>
									<th>3</th>
									<th>4</th>

								</tr>
								<c:choose>
									<c:when test="${empty list}">
										<tr>
											<td colspan="4">========작성된 글이 없습니다.========</td>
										</tr>
									</c:when>
									<c:otherwise>
										<c:forEach items="${list }" var="dto">
											<tr>
												<td>${dto.notice_seq }</td>
												<td><c:forEach begin="1" end="${dto.titletab }"> &nbsp; </c:forEach> <a href="answer.do?command=selectOne&boardno=${dto.boardno }">${dto.title}</a></td>
												<td>${dto.admin_id }</td>
												<td>${dto.reg_date }</td>
											</tr>
										</c:forEach>
									</c:otherwise>
								</c:choose>

								<tr>
									<td colspan="4"><input type="button" value="ê¸ì°ê¸°"
										onclick="location.href='answer.do?command=boardinsertform'" /></td>
								</tr>

							</table>
							
							<div id="pasing"></div>
							<input type="hidden" id="totalCount" value="110">
							<input type="hidden" id="page" value="5">
							<input type="hidden" id="boardName" value="NoticeBoard">
						</div>

					</div>
				</div>
		</section>
		<!-- /ORDER-REVIEW -->



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
		<script
			src="../../../maps.googleapis.com/maps/api/js7402?key=AIzaSyBI14J_PNWVd-m0gnUBkjmhoQyNyd7nllA"></script>
		<script src="plugins/google-map/gmap.js"></script>
		<!-- Main Script -->
		<script src="js/script.js"></script>
		<div id="footer"></div>
</body>

<!-- Mirrored from demo.themefisher.com/themefisher/elite-shop/review.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 21 Nov 2018 12:10:32 GMT -->
</html>
<%@ page import="dto.NoticeBoardDto"%>
<%@ page import="dao.NoticeBoardDao"%>
<%@ page import="dto.Admin"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
	
	<div id="header"></div>

	<div class="preloader">
		<img src="images/preloader.gif" alt="preloader">
	</div>
	<!-- main wrapper -->
	<div class="main-wrapper">

		<!-- breadcrumb -->
		<nav class="bg-gray py-3">
			<div class="container">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="index.html">Home</a></li>
					<li class="breadcrumb-item active" aria-current="page">Cart</li>
				</ol>
			</div>
		</nav>
		<!-- /breadcrumb -->
		<h2 class="sub-title2">구매희망상품</h2>

		<table class="tbl_prd_list">


			<colgroup>

				<col style="width: 40px" />

				<col style="width: 160px" />

				<col style="width: 110px" />

				<col style="width: 100px" />

				<col style="width: 110px" />


			</colgroup>

			<thead>


				<tr>

					<th scope="col"><input type="checkbox" checked id="inp_allRe1"
						name="" value="" disabled="disabled" title="구매희망상품 전체 선택" /></th>

					<th scope="col">판매자</th>

					<th scope="col">상품정보</th>

					<th scope="col">구매가</th>

					<th scope="col">위도 & 경도</th>

				</tr>
			</thead>

			<tbody>

				<c:choose>
					<c:when test="${empty favList }">
						<tr>
							<td colspan="7" class="no_data">장바구니에 저장된 상품이 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="dto" items="${favList }">






							<tr height="40">
								<!--  판매자  -->
								<td align="center" width="160">${dto.seller }</td>

								<!-- 상품 정보  -->
								<td align="center" width="110"></td>

								<!-- 구매가  -->

								<td align="center" width="100">${dto.price}</td>

								<!-- 위도 & 경도   -->

								<td align="center" width="110">${dto.tradeLat}<br>${dto.tradeLon}</td>
							</tr>

						</c:forEach>
					</c:otherwise>
				</c:choose>

			</tbody>

		</table>
		<!--  <td><input type="text" value="1" name="cart-quantity"></td>  숫자 올려주는-->
		<hr>
		<div class="d-flex flex-column flex-md-row align-items-center">
			<input type="text"
				class="form-control text-md-left text-center mb-3 mb-md-0"
				name="coupon" id="coupon" placeholder="I Love you">
			<button class="btn btn-outline-primary ml-md-3 w-100 mb-3 mb-md-0">쿠폰</button>
			<a href="#" class="btn ml-md-4 btn-dark w-100">Update Cart</a>
		</div>
		<hr>


		<div class="basket_price_info">


			<div class="sum_price">
				총 판매가 <span class="tx_num">0</span>원 
				<span class="tx_sign minus">-</span>
				에누리 예상(5%) <span class="tx_num">0</span>원 
				<span class="tx_sign plus">+</span>
				배송비 <span class="tx_num">0</span>원 
				<span class="tx_sign equal">=</span>
				<span class="tx_total_price">총 결제예상금액 
				<span class="tx_price"><span class="tx_num">0</span>원</span></span>
			</div>
		</div>

		<div class="total_price_info">
			<div class="detail_price">
				<p>
					총 판매가<span><span class="tx_num">0</span>원</span>
				</p>
				<span class="tx_sign2 minus">-</span>
				<p class="tx_sale">
					총 에누리 금액<span><span class="tx_num">0</span>원</span>
				</p>

				<span class="tx_sign2 plus">+</span>
				<p>
					교통비<span><span class="tx_num">0</span>원</span>
				</p>

			</div>

			<div class="sum_price">
				<span class="tx_text">교통비는 장소와 vehicle에 따라 변경될 수 있습니다.</span> 총 결제예상금액<span
					class="tx_price"><span class="tx_num">0</span>원</span>

			</div>



		</div>


		<hr>
		<a href="coming-soon.html" class="btn btn-primary float-right">결제</a>

	</div>
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
	
	<!-- Main Script -->
	<script src="js/script.js"></script>
	<div id="footer"></div>
</body>

</html>
	
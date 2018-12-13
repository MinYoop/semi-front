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
	<div class="main-wrapper">

		<section class="section bg-gray hero-area">
			<div class="container">
				<div class="hero-slider">

					<!-- Start first slide  -->
					<div class="slider-item">
						<div class="row">
							<div
								class="col-lg-6 align-self-center text-center text-md-left mb-4 mb-lg-0">
								<h3 data-duration-in=".5" data-animation-in="fadeInLeft"
									data-delay-in="0" data-animation-out="fadeOutLeft"
									data-delay-out="5" data-duration-out=".3">남성을 위한</h3>
								<!-- Start Title -->
								<h1 data-duration-in=".5" data-animation-in="fadeInLeft"
									data-delay-in=".2" data-animation-out="fadeOutLeft"
									data-delay-out="5" data-duration-out=".3">고품격 정품 컨버스</h1>
								<!-- end title -->
								<!-- Start Subtitle -->
								<h3 class="mb-4" data-duration-in=".5"
									data-animation-in="fadeInLeft" data-delay-in=".4"
									data-animation-out="fadeOutLeft" data-delay-out="5"
									data-duration-out=".3">강남역에서 단 돈 5만원에 모십니다.</h3>
								<!-- end subtitle -->
								<!-- Start description -->
								<p class="mb-4" data-duration-in=".5"
									data-animation-in="fadeInLeft" data-delay-in=".6"
									data-animation-out="fadeOutLeft" data-delay-out="5"
									data-duration-out=".3">엄마한테 새학기 문제집 많이 사야 한다고 뻥치고 산 건데... 
									신발장에서 숨기는거 까먹었다가 걸려서 팝니다. 딱 3일 신고 걸려서 파는거라 엄청 깨끗하구요. 하루에 한 번씩 컨버스 전용 세정제로 닦아줬습니다.</p>
								<!-- end description -->
								<!-- Start button -->
								<a href="servlet.do?command=sellboardlist" class="btn btn-primary"
									data-duration-in=".5" data-animation-in="fadeInLeft"
									data-delay-in=".8" data-animation-out="fadeOutLeft"
									data-delay-out="5" data-duration-out=".3">shop now</a>
								<!-- end button -->
							</div>
							<!-- Start slide image -->
							<div class="col-lg-6 text-center text-md-left">
								<!-- background letter -->
								<div class="bg-letter">
									<span data-duration-in=".5" data-animation-in="fadeInRight"
										data-delay-in="1.2" data-animation-out="fadeOutRight"
										data-delay-out="5" data-duration-out=".3"> C </span>
									<!-- Slide image -->
									<img class="img-fluid d-unset"
										src="images/hero-area/converse.png" alt="converse"
										data-duration-in=".5" data-animation-in="fadeInRight"
										data-delay-in="1" data-animation-out="fadeOutRight"
										data-delay-out="5" data-duration-out=".3">
								</div>
							</div>
							<!-- end slide image  -->
						</div>
					</div>
					<!-- end slider item -->


					<!-- Start slide  -->
					<div class="slider-item">
						<div class="row">
							<div
								class="col-lg-6 align-self-center text-center text-md-left mb-4 mb-lg-0">
								<h3 data-duration-in=".5" data-animation-in="fadeInDown"
									data-delay-in="0" data-animation-out="fadeOutDown"
									data-delay-out="5.8" data-duration-out=".3">여성을 위한</h3>
								<h1 data-duration-in=".5" data-animation-in="fadeInDown"
									data-delay-in=".2" data-animation-out="fadeOutDown"
									data-delay-out="5.4" data-duration-out=".3">유행을 타지 않는 명품백</h1>
								<h3 class="mb-4" data-duration-in=".5"
									data-animation-in="fadeInDown" data-delay-in=".4"
									data-animation-out="fadeOutDown" data-delay-out="5"
									data-duration-out=".3">수유역에서 40 만원 </h3>
								<p class="mb-4" data-duration-in=".5"
									data-animation-in="fadeInDown" data-delay-in=".6"
									data-animation-out="fadeOutDown" data-delay-out="4.6"
									data-duration-out=".3">작년 말에 친구가 해외여행 갈 때 부탁해서 받아서 이쁘게 잘 썼어요. 정이 많이 들었는데 요번 엑소 월드투어 때문에 
									어쩔 수 없이 팔아요. 정품 새제품 가격 아시죠?</p>
								<a href="servlet.do?command=sellboardlist" class="btn btn-primary"
									data-duration-in=".5" data-animation-in="fadeInDown"
									data-delay-in=".8" data-animation-out="fadeOutDown"
									data-delay-out="4.2" data-duration-out=".3">shop now</a>
							</div>
							<div class="col-lg-6 text-center">
								<div class="bg-letter">
									<!-- background letter -->
									<span data-duration-in=".5" data-animation-in="fadeInRight"
										data-delay-in="1.2" data-animation-out="fadeOutRight"
										data-delay-out="5" data-duration-out=".3"> B </span> <img
										class="img-fluid d-unset" src="images/hero-area/bag.png"
										alt="converse" data-duration-in=".5"
										data-animation-in="fadeInRight" data-delay-in="1"
										data-animation-out="fadeOutRight" data-delay-out="5"
										data-duration-out=".3">
								</div>
							</div>
						</div>
					</div>
					<!-- end slide  -->

				</div>
			</div>
		</section>
		



		<section class="section overlay cta"
			style="background-image: url(images/backgrounds/cta.jpg);">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 text-center">
						<h1 class="text-white mb-2">연말연시 기념 폭탄세일</h1>
						<p class="text-white mb-4">을 좀 부탁드립니다 회원 여러분. 연말연시에 약 30프로 할인하여 중고 매물을 올리면 더욱 잘 팔린다는 사실!!!</p>
						<a href="servlet.do?command=sellboardlist" class="btn btn-light">sell now</a><!-- 여기에 매물 올리기 링크 -->
					</div>
				</div>
			</div>
		</section>

		

		

		<!-- service -->
		<section class="section-sm border-top">
			<div class="container">
				<div class="row">
					<!-- service item -->
					<div class="col-lg-3 col-sm-6 mb-4 mb-lg-0">
						<div
							class="d-flex flex-sm-row flex-column align-items-center align-items-sm-start">
							<i class="ti-truck service-icon mb-3 mb-sm-0"></i>
							<div class="text-center text-sm-left">
								<h4>배달사고 확률 0% 달성</h4>
								<p class="mb-0 text-gray">배달을 안 하면<br> 배달사고가 안 납니다.</p>
							</div>
						</div>
					</div>
					<!-- service item -->
					<div class="col-lg-3 col-sm-6 mb-4 mb-lg-0">
						<div
							class="d-flex flex-sm-row flex-column align-items-center align-items-sm-start">
							<i class="ti-shield service-icon mb-3 mb-sm-0"></i>
							<div class="text-center text-sm-left">
								<h4>안전한 지불</h4>
								<p class="mb-0 text-gray"> 직접 만나 물건을 확인한 뒤<br> 대금을 지불하니 안전합니다.</p>
							</div>
						</div>
					</div>
					<!-- service item -->
					<div class="col-lg-3 col-sm-6 mb-4 mb-lg-0">
						<div
							class="d-flex flex-sm-row flex-column align-items-center align-items-sm-start">
							<i class="ti-timer service-icon mb-3 mb-sm-0"></i>
							<div class="text-center text-sm-left">
								<h4>24/7 자유로운 거래</h4>
								<p class="mb-0 text-gray">24시간 중 언제든 물건을 받을 수 있습니다. 
								판매자와의 약속 시간에 따라.
									</p>
							</div>
						</div>
					</div>
					<!-- service item -->
					<div class="col-lg-3 col-sm-6 mb-4 mb-lg-0">
						<div
							class="d-flex flex-sm-row flex-column align-items-center align-items-sm-start">
							<i class="ti-reload service-icon mb-3 mb-sm-0"></i>
							<div class="text-center text-sm-left">
								<h4>아름다운 재활용</h4>
								<p class="mb-0 text-gray">중고책을 새책 대신 사면 자르지 않아도 되는 나무가 몇 그루인지 아십니까?
								저희는 모릅니다.</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- /service -->

		

		<!-- Newsletter Modal ìëê³  ì´ì ë¶í´ ë¡ê·¸ì¸ ëª¨ë¬ -->
		<div class="modal fade subscription-modal" id="subscriptionModal"
			tabindex="-1">
			<div class="modal-dialog modal-lg">
				<!-- modal content start -->
				<div class="modal-content">
					<!-- container start -->
					<div class="container-fluid">
						<div class="row">
							<!-- close button -->
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<div class="col-lg-6 px-0">
								<!-- newsletter image -->
								<div class="image">
									<img src="images/newsletter-popup.jpg" alt="products"
										class="img-fluid w-100 rounded-left">
								</div>
							</div>
							<div class="col-lg-6 align-self-center p-5">
								<!-- Content start -->
								<div class="text-center align-self-center">
									<h3 class="mb-lg-5 mb-4">Serendipity!</h3>
									<h4>가장 가까운 곳의 가장 좋은 물건</h4>
									<h2 class="mb-lg-5 mb-4">이 곳에 있습니다.</h2>
									<!-- newsletter form -->
									<div class="form whenlogin">
									<form method="post" action="login.jsp">
									<button class="btn btn-primary w-100" onclick="submit">SNS로그인</button></form>
										<script type="text/javascript"
											src="//connect.facebook.net/en_US/all.js#xfbml=1&appId=416848035516774"
											id="facebook-jssdk"></script>
							 <div class="fb-login-button" style="display:none" data-width="277" 
											data-max-rows="1" data-size="large"
											data-button-type="login_with" data-show-faces="false"
											data-auto-logout-link="true" data-use-continue-as="false" ></div> 
											
									</div>
								</div>
								<!-- Content end -->
							</div>
						</div>
					</div>
					<!-- container end -->
				</div>
				<!-- modal content end -->
			</div>
		</div>
		<!-- /Newsletter Modal -->

	<div id="footer"></div>
	 
	</div>

	<!-- Bootstrap JS -->
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
	<!-- google map -->
	<script src="maps/api/js7402?key=AIzaSyBI14J_PNWVd-m0gnUBkjmhoQyNyd7nllA"></script>
	<script src="plugins/google-map/gmap.js"></script>
	<!-- Main Script -->
	<script src="js/script.js"></script>
	<script src="js/sns.js"></script>

</body>

</html>
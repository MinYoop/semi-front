<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 코어 -->
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

<script src="js/script.js"></script>

<script type="text/javascript" src="js/unlimit.js"></script>


	
<!-- 무한스크롤 --> 	


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
	<div class="main-wrapper" style="text-align:center">

		<!-- breadcrumb -->
		<nav class="bg-gray py-3">
			<div class="container">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
					<li class="breadcrumb-item active" aria-current="page">Shop</li>
				</ol>
			</div>
		</nav>
		

		<!-- shop -->
		<section class="section">
			<div class="container">
				<div class="row">
					
					<div class="col-lg-9">
						<div class="row" id="limit">
							
							<!-- 코어 반복 -->
							<%-- <c:choose>
								
								<c:when test="${empty list }">
				
				======================판매글 없음======================
					
				</c:when>
								<c:otherwise>
									
									<c:forEach items="${list }" var="dto">



										<!-- product -->
										
										<div class="col-lg-4 col-sm-6 mb-4">
											<div class="product text-center">
												<div class="product-thumb">
													<div class="overflow-hidden position-relative">
														<a href="product-single.html"> <img
															class="img-fluid w-100 mb-3 img-first"
															src="images/collection/product-1.jpg" alt="product-img">
															<img class="img-fluid w-100 mb-3 img-second"
															src="images/collection/product-4.jpg" alt="product-img">
														</a>
														<div class="btn-cart">
															<a href="#" class="btn btn-primary btn-sm">Add To Cart</a>
														</div>
													</div>
													<div class="product-hover-overlay">
														<a href="#" class="product-icon favorite"
															data-toggle="tooltip" data-placement="left"
															title="Wishlist"><i class="ti-heart"></i></a> <a href="#"
															class="product-icon cart" data-toggle="tooltip"
															data-placement="left" title="Compare"><i
															class="ti-direction-alt"></i></a> <a data-vbtype="inline"
															href="#quickView" class="product-icon view venobox"
															data-toggle="tooltip" data-placement="left"
															title="Quick View"><i class="ti-search"></i></a>
													</div>
												</div>
												<div class="product-info">
													<h3 class="h5">
														<a class="text-color" href="product-single.html">${dto.title }</a>
													</h3>
													<c:choose>
													<c:when test="${dto.distance<1 }">
														<span class="h5">${dto.distance*1000 }m</span>													
													</c:when>
														
													<c:otherwise>
														<span class="h5">${dto.distance }km</span>													
													</c:otherwise>
													</c:choose>
												</div>
												<!-- product label badge -->
												<div class="product-label sale">${dto.status }</div>
											</div>
										</div>
										<!-- //end of product -->





									</c:forEach>
								</c:otherwise>

							</c:choose> --%>



							<!-- <div class="col-12 mt-5">
								<nav>
									<ul class="pagination justify-content-center">
										<li class="page-item active"><a class="page-link"
											href="#">1</a></li>
										<li class="page-item"><a class="page-link" href="#">2</a></li>
										<li class="page-item"><a class="page-link" href="#">3</a></li>
										<li class="page-item"><a class="page-link" href="#"><i
												class="ti-arrow-right"></i></a></li>
									</ul>
								</nav>
							</div>
							<div id="pasing" style="text-align:center"></div>
							<input type="hidden" id="totalCount" value="200">
							<input type="hidden" id="page" value="23">
							<input type="hidden" id="boardName" value="selling">
							<script src="js/pasing.js"></script> -->
							
						</div>
						
						<div class="col-12 mt-5">
								<nav>
									<ul class="pagination justify-content-center">
										
										<li id="nomoreitem">더 많은 매물을 보려면 스크롤을 내려주세요</li>										
										
									</ul>
								</nav>
					    </div>
					    
					    
					    <c:choose>								
							<c:when test="${User ne null}">
											
								<input type="button" value="판매글쓰기" onclick="location.href='servlet.do?command=writeform'"/>
					
							</c:when>
								<c:otherwise>
					    		<p>로그인 하시면 판매글 작성하실 수 있습니다. </p>
					    		</c:otherwise>
					    </c:choose>
					</div>
				</div>
			</div>
		</section>
		<!-- /shop -->
		

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


<!-- 아래 div 부분을 카트 버튼에 붙인다.
	 <div class="btn-cart">
	<a href='javascript:void(0);' onclick="favAdd(${dto.seq})"class="btn btn-primary btn-sm">Add To Cart</a>
							</div>
	 
	<script type="text/javascript">
							let favAdd = (seq) => {
								$.ajax({
									url:"FavAndCompare.do",
									data:{
										command:"addFav",
										sellNum : seq
									}, success:function(res){
										if(res >0){
											alert("찜바구니에 등록되었습니다.");
										} else{
											alert("로그인시 이용 가능한 기능입니다.");
										}
									}
								})
							}
							
							</script> 

-->


</body></html>
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

</head>

<body>
	<script type="text/javascript">
	let getPage = (boardName,page){
		location.href="Message.do?command=getPage&boardName="+boardName+"&page="+page+"&where=noticelist.jsp";
	}
	
	
	</script>
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
					<li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
					<li class="breadcrumb-item active" aria-current="page">Admin
						Notices</li>
				</ol>
			</div>
		</nav>
		<!-- /breadcrumb -->

		<!-- ORDER-REVIEW -->
		<section class="section">
			<div class="container">
				<div class="row">
					<div class="col-md-8">
						<div style="text-align: center"class="inner-wrapper border-box">
							<!-- navbar -->
							<div class="justify-content-between nav mb-5">
								<a href="#" class="text-center d-inline-block nav-item"> <i
									class="ti-home d-block mb-2"></i> <span class="d-block h2">공지사항</span>
								</a>
								<!-- /navbar -->


								<!-- buttons -->

							</div>


							<table class="inner-wrapper border-box " style="text-align:center">
								<col width="100">
								<col width="100">
								<col width="350">
								<col width="100">
								<c:choose>
									<c:when test="${admin_id ne null}">
										<col width="150">
										<col width="150">
									</c:when>
								</c:choose>
								<tr>
									<th>번호</th>
									<th>이름</th>
									<th>제목</th>
									<th>날짜</th>
									<c:choose>
										<c:when test="${admin_id ne null}">

											<th>수정</th>
											<th>삭제</th>
										</c:when>
									</c:choose>
								</tr>
								<c:choose>
									<c:when test="${empty list}">
										<tr>
											<td colspan="6">========작성된 글이 없습니다.========</td>
										</tr>
									</c:when>
									<c:otherwise>
										<c:forEach items="${list }" var="dto">
											<tr>
												<td>${dto.notice_seq }</td>
												<td>관리자</td>
												<td><a
													href="NoticeBoard.do?command=selectOne&notice_seq=${dto.notice_seq }">${dto.title}</a></td>
												<td><h6>${dto.reg_date }</h6></td>
												<c:choose>
												<c:when test="${admin_id ne null}">
													<td><a href="NoticeBoard.do?command=updateNoticeform&notice_seq=${dto.notice_seq }">수정</a></td>
													<td><a
														href="NoticeBoard.do?command=deleteNotice&notice_seq=${dto.notice_seq }">삭제</a></td>
												</c:when>
												</c:choose>
											</tr>

										</c:forEach>
									</c:otherwise>
								</c:choose>
					<c:choose>
								<c:when test="${admin_id ne null}">

									<tr>
										<td colspan="6" align="right">
											<button
												onclick="location.href='NoticeBoard.do?command=insertNoticeForm'">글쓰기</button>
									</tr>

								</c:when>
					</c:choose>		
							

							</table>

							<div id="pasing">${paging }</div>
						</div>

					</div>
				</div>
			</div>
		</section>
		<!-- /ORDER-REVIEW -->


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
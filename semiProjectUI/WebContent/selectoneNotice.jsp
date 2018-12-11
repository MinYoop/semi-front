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
<center>
 
<table>
		<tr>
			<th>이름</th>
			<td>관리자</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${dto.title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea rows="10" cols="60"
				readonly="readonly">${dto.content }</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
					<c:choose>
					<c:when test="${admin_id ne null}">

				<button onclick="location.href='NoticeBoard.do?command=updateNoticeform&notice_seq=${dto.notice_seq}'">수정</button>&nbsp;&nbsp;
				<button onclick="location.href='NoticeBoard.do?command=deleteNotice&notice_seq=${dto.notice_seq}'">삭제</button>&nbsp;&nbsp;
											
										</c:when>
									</c:choose>
				<button onclick="location.href='NoticeBoard.do?command=list'">목록</button>&nbsp;
			</td>
		</tr>
	
	</table>
</center> 
	
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
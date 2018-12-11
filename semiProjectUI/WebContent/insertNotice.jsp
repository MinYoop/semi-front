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
	

<div style="text-align:center"class="main-wrapper">
		<h1>글작성</h1>
<center>
	<form action="NoticeBoard.do" method="post">
		<input type="hidden" name="command" value="insertNotice">
		<table border="1">
			<tr>
				<th>작성자:</th>
				<td><input type="text" name="admin_id" value="${admin_id}" readonly="readonly"/></td>
			</tr>
			<tr>
				<th>제목:</th>
				<td><input type="text" name="title"/></td>
			</tr>
			<tr>
				<th>내용:</th>
				<td><textarea rows="10" cols="60" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="입력"/>
					<input type="button" value="취소" onclick="location.href='NoticeBoard.do?command=list'">
				</td>
			</tr>
		</table>
	</form>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 관리</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<script type="text/javascript" src="script/goods.js"></script>
</head>
<body>
	<div id="wrap" align="center">

		<h1>게시판 등록 - 관리자 페이지</h1>
		<form method="post" enctype="multipart/form-data" name="frm">
			<table>
				<tr>
					<th>제목</th>
					<td><input type="text" name="name" size="80"></td>
				</tr>

				<tr>
					<th>오늘의 행운번호 쏘세요~~</th>
					<td><input type="text" name="price"> </td>

				</tr>

				<tr>
					<th>사 진</th>
					<td><input type="file" name="pictureUrl"><br>
						(주의사항: 이미지를 변경하고자 할때만 선택하시오)</td>
				</tr>
				<tr>
					<th>설 명</th>
					<td><textarea cols="80" rows="10" name="description"></textarea></td>
				</tr>


			</table>
			<br>
			<input type="submit" value="등록" onclick="return goodsCheck()">
			<input type="reset" value="다시작성">
			
			<!-- 목록을 바꿔야함 내 부트스트랩이랑 합쳐 한다.  -->
			<input type="button" value="목록" onclick="location.href='freeboard.html'">

		</form>

	</div>

</body>
</html>
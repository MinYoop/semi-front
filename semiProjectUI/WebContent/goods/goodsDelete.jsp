<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 관리</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>
<body>

	<div id="wrap" align="center">

		<h1>상품 삭제 - 관리자 페이지</h1>
		<form action="goodsDelete.do" method="post">
			<table>
				<tr>
					<td><c:choose>
							<c:when test="${empty goods.pictureUrl }">
								<img src="upload/noimage.gif">
							</c:when>
							<c:otherwise>
								<img src="upload/${goods.pictureUrl }">
							</c:otherwise>

						</c:choose></td>
					<td>
						<table>
							<tr>
								<th style="width: 80px">상품명</th>
								<td>${goods.name }</td>
							</tr>

							<tr>
								<th>가격</th>
								<td>${goods.price} 원</td>
							</tr>
							<tr>
								<th>설명</th>
								<td>
									<div style="height: 220px; width: 100%">
										${goods.description}</div>
								</td>
							</tr>
						</table>
					</td>
				</tr>

			</table>
			<br>
			<input type="hidden" name="code" value="${goods.code}">
			<input type="submit" value="삭제">
			<input type="button" value="목록" onclick ="location.href='goodsList.do'">
			
		</form>

	</div>

</body>
</html>
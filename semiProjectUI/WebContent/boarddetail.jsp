<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

   function map3(){
      // open(url, windowName, windowFeatures(팝업창의 윈도우 크기/생략가능(생략하면 새탭으로 뜬다.)) ) : 
      window.open('servlet.do?command=map3&tradeLat=${dto.tradeLat}&tradeLon=${dto.tradeLon}',"","width=300px,heigth=300px");
   }


</script>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="js/script.js"></script>

</head>
<body>

   <jsp:useBean id="dto" class="dto.SellBoard" scope="request"></jsp:useBean>
   
   <div id="header"></div>
   <center>
   <div>
   
   <h1>상세 글 보기</h1>
   
   <table border="1">
      <tr>
         <th>번  호</th>
         <td><jsp:getProperty property="sellSeq" name="dto"/></td>
      </tr>
      <tr>
         <th>작성자</th>
         <td><jsp:getProperty property="seller" name="dto"/></td>
      </tr>
      <tr>
         <th>카테고리</th>
         <td><jsp:getProperty property="category" name="dto"/></td>
      </tr>
      <tr>
         <th>제  목</th>
         <td><jsp:getProperty property="title" name="dto"/></td>
      </tr>
      <tr>
         <th>작성일</th>
         <td><jsp:getProperty property="regDate" name="dto"/></td>
      </tr>
      <tr>
         <th>내  용</th>
         <td width="600px">           
            <jsp:getProperty property="sellContent" name="dto"/>
         </td>
      </tr>
      
      
      <tr>
         <td colspan="2">
            	<input type="button" value="수정" onclick="location.href='servlet.do?command=boardupdateform&sellSeq=${dto.sellSeq }'">
				<input type="button" value="삭제" onclick="location.href='servlet.do?command=boarddeleteform&sellSeq=${dto.sellSeq }'">
				<input type="button" value="목록" onclick="location.href='servlet.do?command=sellboardlist'">
				<input type="button" value="지도" onclick="map3()">
         </td>
      </tr>      
   </table>
   </div>
   </center>
   <div id="footer"></div>
</body>
</html>
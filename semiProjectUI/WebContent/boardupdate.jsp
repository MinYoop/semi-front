<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%
    String ctx = request.getContextPath();    //콘텍스트명 얻어오기.
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.0.min.js"></script>

<script type="text/javascript" src="<%=ctx %>/SE2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript">
var oEditors = [];
$(function(){
      nhn.husky.EZCreator.createInIFrame({
          oAppRef: oEditors,
          elPlaceHolder: "ir1", //textarea에서 지정한 id와 일치해야 합니다. 
          //SmartEditor2Skin.html 파일이 존재하는 경로
          sSkinURI: "/semiProjectUI1/SE2/SmartEditor2Skin.html",  
          htParams : {
              // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
              bUseToolbar : true,             
              // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
              bUseVerticalResizer : true,     
              // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
              bUseModeChanger : true,         
              fOnBeforeUnload : function(){
                   
              }
          }, 
          fOnAppLoad : function(){
              //기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
              oEditors.getById["ir1"].exec("PASTE_HTML", [""]);
             
          },
          fCreator: "createSEditor2"
      });
      
      //저장버튼 클릭시 form 전송
      $("#save").click(function(){
          oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
          
          $("#frm").submit();
      });    
});
 
 
 
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>게시글 수정</h1>

	<form action="servlet.do" method="post"> 
		<input type="hidden" name="command" value="boardupdate">
		<input type="hidden" name="sellSeq" value="${dto.sellSeq }">
		<table border="1">
			<tr>
				<th>번호</th>
				<td>${dto.sellSeq }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${dto.seller }</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${dto.regDate }</td>
			</tr>
			<tr>
				<th>제  목</th>
				<td><input type="text" name="title" value="${dto.title }" /></td>
			</tr> 
			<tr>
				<th>내  용</th>
				<td width="600px"><textarea rows="10" cols="60" name="content" id="ir1" >${dto.content }</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정" />
					<input type="button" value="취소" onclick="location.href='servlet.do?command=boarddetail&sellSeq=${dto.sellSeq }'" />
			
				</td>
			</tr>
		</table>
	</form>

</body>
</html> --%>
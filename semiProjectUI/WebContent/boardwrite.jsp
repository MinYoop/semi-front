<%@page import="dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<%
	String ctx = request.getContextPath(); //콘텍스트명 얻어오기.
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.9.0.min.js"></script>
<script src="js/script.js"></script>
<script type="text/javascript" src="<%=ctx%>/SE2/js/HuskyEZCreator.js"
	charset="utf-8"></script>

<script type="text/javascript">
	//selector
	$(function(){})
	function sub_change1() {
		vn_mnu1 = frm.menu1.selectedIndex;

		if (vn_mnu1 == 1) {
			frm.category.length = 6;
			frm.category.options[0].text = '---두번째 항목---';
			frm.category.options[1].text = '게이밍 노트북';
			frm.category.options[2].text = '초경량 노트북';
			frm.category.options[3].text = '디자인용 노트북';
			frm.category.options[4].text = 'pc주요 부품';
			frm.category.options[5].text = '모니터/사운드';
		}
		if (vn_mnu1 == 2) {
			frm.category.length = 6;
			frm.category.options[0].text = '---두번째 항목---';
			frm.category.options[1].text = '휴대폰/스마트폰';
			frm.category.options[2].text = '태블릿/전자책';
			frm.category.options[3].text = '스마트워치 VR';
			frm.category.options[4].text = '보조배터리/충전기';
			frm.category.options[5].text = '휴대폰 액세서리';
		}
		if (vn_mnu1 == 3) {
			frm.category.length = 6;
			frm.category.options[0].text = '---두번째 항목---';
			frm.category.options[1].text = '가방/지갑';
			frm.category.options[2].text = '시계/쥬얼리';
			frm.category.options[3].text = '신발';
			frm.category.options[4].text = '의류/언더웨어';
			frm.category.options[5].text = '명품관';
		}
		if (vn_mnu1 == 4) {
			frm.category.length = 6;
			frm.category.options[0].text = '---두번째 항목---';
			frm.category.options[1].text = '침실/침실가구';
			frm.category.options[2].text = '행거/옷장/수납장';
			frm.category.options[3].text = '쇼파/거실가구';
			frm.category.options[4].text = '의자/책상/책장';
			frm.category.options[5].text = '식탁/주방가구';
		}
	}
	</script>

	<script type="text/javascript">
	
	var oEditors = [];
	$(function() {
		nhn.husky.EZCreator.createInIFrame({
			oAppRef : oEditors,
			elPlaceHolder : "ir1", //textarea에서 지정한 id와 일치해야 합니다. 
			//SmartEditor2Skin.html 파일이 존재하는 경로
			sSkinURI : "/semiProjectUI/SE2/SmartEditor2Skin.html",
			htParams : {
				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseToolbar : true,
				// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseVerticalResizer : true,
				// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
				bUseModeChanger : true,
				fOnBeforeUnload : function() {

				}
			},
			fOnAppLoad : function() {
				//기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
				oEditors.getById["ir1"].exec("PASTE_HTML", [ "" ]);

			},
			fCreator : "createSEditor2"
		});

		//저장버튼 클릭시 form 전송
		$("#save").click(function() {
			oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);

			$("#frm").submit();
		});
	});
</script>
<script type="text/javascript">
	function map1() {
		// open(url, windowName, windowFeatures(팝업창의 윈도우 크기/생략가능(생략하면 새탭으로 뜬다.)) ) : 
		window.open('servlet.do?command=map1', "", "width=300px,heigth=300px");
	}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="header"></div>
	<center>
		<div>
			<h1>글 쓰기</h1>
			<form id="frm" action="servlet.do" method="post">
				<input type="hidden" name="command" value="boardwrite" />
				<table border="1">
					<tr>
						<th>작성자</th>
						<td><input type="text" name="seller"
							value=<%=((User) session.getAttribute("User")).getNickName()%> readonly="readonly" />
						</td>
					</tr>
					<tr>
						<th>카테고리</th>
						<td>
						<select name="menu1" size="1" onChange="sub_change1()">
								<option selected>---첫번째 항목---</option>
								<option>컴퓨터●노트북</option>
								<option>태블릿●모바일</option>
								<option>패션●잡화</option>
								<option>가구●침구</option>
						</select>
						 <select name="category" size="1">
								<option value=" " selected>---두번째 항목---</option>
						</select>
						</td>
					</tr>


					<tr>
						<th>제 목</th>
						<td><input type="text" name="title" /></td>
					</tr>
					<tr>
						<th>내 용</th>
						<td width="600px"><textarea rows="10" cols="60"
								name="sellContent" id="ir1"></textarea></td>
					</tr>

					<tr>
						<td align="left"><input type="button" value="거래위치 지정"
							onclick="map1()" /></td>

						<td align="right"><input type="text" name="tradeLat"
							id="tradeLat" /> <input type="text" name="tradeLon" id="tradeLon" />
							<input type="button" value="등록" id="save" /> <input
							type="button" value="취소"
							onclick="location.href='servlet.do?command=sellboardlist'" /></td>
					</tr>

				</table>

			</form>
		</div>
	</center>
	<div id="footer"></div>

</body>
</html>
<%@page import="dto.Message"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="ko">


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
	<script src="js/msg.js"></script>



<style>
table {
	text-align: center;
	border-bottom-style:solid; border-bottom-color:red;
}

th{
	border-bottom-style:solid; border-bottom-color:red;

}
</style>
</head>

<!-- preloader start -->
<body>



	<div id="header"></div>

	<div class="preloader">
		<img src="images/preloader.gif" alt="preloader">
	</div>

<div class="main-wrapper" >

	<div class="modal fade subscription-modal" id="msgChkModal" tabindex="-1">
		<div class="modal-dialog modal-s">
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

						<div class="col-lg-11 align-self-center p-5">
							<!-- Content start -->
							<div class="text-center align-self-center">
								<form>
									<h3 class="mb-2 sentOrReceived"></h3>
									<h4 class="mb-1 msgChkModalTitle" style="text-align: center"></h4>
									<h5 class="mb-1 msgChkModalFromOrTo" style="text-align: right"></h5>
									<textarea class="mb-20 " id="msgChkModalContent" name="msgContent" 
										cols="40" rows="10" readonly="readonly"></textarea>
									<h6 class="mb-1 msgChkModalDate" style="text-align: right"></h6>
									
								</form>
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


	<div class="modal fade subscription-modal" id="sendform" tabindex="-1">
		<div class="modal-dialog modal-s">
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

						<div class="col-lg-11 align-self-center p-5">
							<!-- Content start -->
							<div class="text-center align-self-center">
								<form>
									<h3 class="mb-2">쪽지 보내기</h3>
									<h4 class="mb-1" style="text-align: center">
										Title <input type="text" size="20" id="msgTitle"
											name="msgTitle">
									</h4>
									<h5 class="mb-1" style="text-align: right">
										To. <input type="text" size="8" id="sendToWho"
											class="sendToWho" name="sendToWho"> <b
											class="whowouldreceive"></b>&nbsp;
									</h5>
									<input type='hidden' name="nickName" id="receiverNickname"
										value="">
									<textarea class="mb-20" name="msgContent" id="msgContent"
										cols="40" rows="10"></textarea>
									<button class="btn btn-secondary w-50" type="button"
										onclick="sendmsg()">Send</button>
								</form>
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



	<!-- 메세지 리스트  -->
	<script src="js/pasing2.js"></script>

	<div
		style="display: flex; align-items: center; justify-content: center; overflow:auto;flex-wrap: wrap"
		class="my-80">
		<div class="received mx-3 my-10"
			style="flex-shrink:0;width: 400px; height: 800px; margin: auto;">
			<div style="text-align: center">
				<h3>받은 쪽지</h3>
			</div>
			<div style ="text-align:center"class="receivedTable">
				<table  >
					<col width="100px">
					<col width="100px">
					<col width="200px">
					<col width="120px">
					<col width="80px">
					<col width="80px">

					<tr>
						<th>확인</th>
						<th>보낸이</th>
						<th>제목</th>
						<th>작성일</th>
						<th>답장</th>
						<th>삭제</th>
					</tr>

					<c:choose>
						<c:when test="${empty rclist }">
							<tr>
								<td colspan="6" style="text-align: center">----받은 쪽지가
									없습니다.----</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="dto" items="${rclist }">
								<tr>
									<c:choose>
										<c:when test="${dto.receiverChk>0 }">
											<td>확인</td>
										</c:when>
										<c:otherwise>
											<td><b>미확인</b></td>
										</c:otherwise>
									</c:choose>
									<td id="msgSender${dto.msgSeq }">${dto.sender }</td>
									<td id="msgTitle${dto.msgSeq }"><a
										onclick="viewReceivedMsg(${dto.msgSeq });">${dto.msgTitle }</a></td>
									<td id="msgDate${dto.msgSeq }"><h6>${dto.sendDate }</h6></td>
									<td><button class="btn-light" onclick='sendmsgPopup("${dto.sender }")'>클릭</button>
									<td><a href="Message.do?command=delete&msgSeq=${dto.msgSeq }">삭제</a></td>
								</tr>
								<div style="display: none" id="msgContent${dto.msgSeq}">${dto.msgContent }</div>
							</c:forEach>
						</c:otherwise>
					</c:choose>

					<tr>
						<td colspan="6"></td>
					</tr>
				</table>

				<input type="hidden" id="totalCount" value=""> <input
					type="hidden" id="page" value="1"> <input type="hidden"
					id="boardName" value="receivedMsgPage">
				<div id="pasing"></div>
			</div>
		</div>



		<div class="sent mx-3 my-10"
			style="flex-shrink:0; width: 400px; height: 800px; margin: auto; overflow:auto">

			<div style="text-align: center">
				<h3>보낸 쪽지</h3>
			</div>
			<div style="text-align:center"class="sentTable">
				<table>
				
					<col width="100px">
					<col width="100px">
					<col width="200px">
					<col width="120px">
					<col width="80px">

					<tr>
						<th>확인</th>
						<th>받은이</th>
						<th>제목</th>
						<th>작성일</th>
						<th>삭제</th>
					</tr>

					<c:choose>
						<c:when test="${empty sdlist }">
							<tr>
								<td colspan="5" style="text-align: center">----보낸 쪽지가
									없습니다.----</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="dto" items="${sdlist }">
								<tr>
									<c:choose>
										<c:when test="${dto.receiverChk>0 }">
											<td>확인</td>
										</c:when>
										<c:otherwise>
											<td><b>미확인</b></td>
										</c:otherwise>
									</c:choose>
									<td id="msgReceiver${dto.msgSeq }">${dto.receiver }</td>
									<td id="msgTitle${dto.msgSeq }"><a onclick="viewSentMsg(${dto.msgSeq });">${dto.msgTitle }</a></td>
									<td id="msgDate${dto.msgSeq }"><h6>${dto.sendDate }</h6></td>
									<td><a
										href="Message.do?command=delete&msgSeq=${dto.msgSeq }">삭제</a></td>
								</tr>
								<div style="display: none" id="msgContent${dto.msgSeq }">${dto.msgContent }</div>
							</c:forEach>
						</c:otherwise>
					</c:choose>

				

				</table>
				<input type="hidden" id="totalCount2" value=""> <input
					type="hidden" id="page2" value="1"> <input type="hidden"
					id="boardName2" value="sentMsgPage">
				<div id="pasing2"></div>
		<input type="button" value="쪽지 보내기"
							onclick="sendmsgPopup()">
			</div>
		</div>








	
	
	 
	</div>
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

</body></html>
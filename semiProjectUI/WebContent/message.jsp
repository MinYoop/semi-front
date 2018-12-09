<%@page import="dto.Message"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>  


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 

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
	<script type="text/javascript"
	src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js"
	charset="utf-8"></script>
	


</head>

<!-- preloader start -->
<body>

<script type="text/javascript">
	/*
MSG_SEQ             NUMBER            NOT NULL, 
MSG_CONTENT         VARCHAR2(2000)    NOT NULL, 
SENDER              NUMBER            NOT NULL, 
RECEIVER            NUMBER            NOT NULL, 
RECIEVER_CHK        NUMBER            NOT NULL, 
SENDER_DEL_CHK      NUMBER            NOT NULL, 
RECEIVER_DEL_CHK    NUMBER            NOT NULL, 
SEND_DATE           DATE              NOT NULL, 
	*/
	
	
let sendmsg = () => {
	$.ajax({
		url : 'Message.do',
		dataType: 'text',
		data : { 
			command : "sendMessage",
			msgTitle : $("#msgTitle").val(),
			msgContent : $("#msgContent").val(),
			receiver : $("#sendToWho").val()
				//센더에서 
				
		},
		success: function(msg){
			//리프레시된 보낸 쪽지 리스트를 출력.
		//	var msglists = msg.split("cutlineforreceivedandsent");
		//	$(".receivedtable").html(msglists[0]);
		//	$(".senttable").html(msglists[1]);
		}
	})
	
}
	
	
	
	
let sendmsgPopup = (sender=0) => {
if(sender!=0){
	$(".whowouldreceive").html(sender);
	$("#SendToWho").attr("type","hidden");
	$("#SendToWho").val(sender);
}else{
	$("#sendToWho").val("");
	$("#SendToWho").attr("type","text");
}
$('#sendform').modal('show');
} 
	 
let viewMsg = (seq) =>{
	$("#msgChkModalTitle").html($("#msgTitle"+seq).text());
	$("#msgChkModalContent").html($("#msgContent"+seq).val());
	$("#msgChkModalFrom").html($("#msgFrom"+seq).text());
	$("#msgChkModalDate").html($("#msgDate"+seq).text());
	$("#msgChkModal").modal('show');

}//모달 만들어서 내용 집어넣고 .modal('show');
//let getPage = (page = 1) ={//페이지 눌렀을 때 실행 
	
//}






	</script>
	
<div id="header"></div>

	<div class="preloader">
		<img src="images/preloader.gif" alt="preloader">
	</div>
	
	
	
	<div class="modal fade subscription-modal" id="sendform"
			tabindex="-1">
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
									<h4 class="mb-1" style="text-align:center">Title 
									<input type="text" size="20" id="msgTitle"name="msgTitle"></h4>
									<h5 class="mb-1" style="text-align:right">To. 
									<input type="text" size="8" id="sendToWho"name="sendToWho">
									<b class="whowouldreceive"></b>&nbsp;</h5>
									<input type='hidden' 
									name="nickName" id="receiverNickname"value="">
									<textarea class="mb-20"name="msgContent" id="msgContent"cols="40" rows="10"></textarea>
									<button class="btn btn-secondary w-50" type="button" onclick="sendmsg()">Send</button></form>
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
	<script src="js/pasing.js"></script>
		<script src="js/pasing2.js"></script>
	
	
	
<div style="display:flex; align-items: center;
  justify-content: center;" class="my-80">
<div class="received mx-3 my-10"style ="width:400px;height:500px; margin:auto;">
<div style="text-align:center"><h3>받은 쪽지</h3></div>
<div class="receivedTable">
<table >
		<col width="2%">
		<col width="4%">
		<col width="6%">
		<col width="4%">
		<col width="2%">
		<col width="2%">
		
		<tr>
			<th>확인</th>
			<th>보낸이</th>
			<th>내용</th>
			<th>작성일</th>
			<th>답장</th>
			<th>삭제</th>
		</tr>	
		
		<c:choose>
			<c:when test="${empty rclist }">
				<tr>
					<td colspan="6" style="text-align:center">----받은 쪽지가 없습니다.----</td>
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
						<td id="msgFrom${dto.msgSeq }">${dto.sender }</td>
						<td id="msgTitle${dto.msgSeq }"><a onclick="viewMsg(${dto.msgSeq })">${dto.msgTitle }</a></td>
					<td id="msgDate${dto.msgSeq }">${dto.sendDate }</td> 
				<td><button class="btn-secondary" onclick="sendmsgPopup('${dto.sender }')">클릭</button>
				<td><a href="Message.do?command=delete&msgSeq=${dto.msgSeq }">삭제</a></td>
					</tr>
				<div style="display:none" id="msgContent${dto.msgContent }">${dto.msgContent }</div> 
				</c:forEach>	
			</c:otherwise>		
		</c:choose>
		
		<tr>
			<td colspan="6">
			</td>
		</tr>
	</table>
	
	<input type="hidden" id="totalCount" value="100">
<input type="hidden" id="page" value="1">
<input type="hidden" id="boardName" value="messageboard">
<div id="pasing"></div>
</div>
</div>

<div class="sent mx-3 my-10"style ="width:400px;height:500px; margin:auto;">

<div style="text-align:center"><h3>보낸 쪽지</h3></div>
<div class="sentTable">
<table>
		<col width="2%">
		<col width="4%">
		<col width="6%">
		<col width="4%">
		<col width="2%">
		
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
					<td colspan="5" style="text-align:center">----보낸 쪽지가 없습니다.----</td>
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
				<td id="msgTitle${dto.msgSeq }"><a onclick="viewMsg(${dto.msgSeq })">${dto.msgTitle }</a></td>
				<td id="msgDate${dto.msgSeq }">${dto.sendDate }</td> 
				<td><a href="Message.do?command=delete&msgSeq=${dto.msgSeq }">삭제</a></td>
					</tr>
				<div style="display:none" id="msgContent${dto.msgSeq }">${dto.msgContent }</div> 
				</c:forEach>	
			</c:otherwise>		
		</c:choose>
		
		<tr>
			<td colspan="5">
				<input type="button" value="쪽지 보내기" onclick="sendmsgPopup()">
			</td>
		</tr>
		
	</table>
	<input type="hidden" id="totalCount2" value="1000">
<input type="hidden" id="page2" value="23">
<input type="hidden" id="boardName2" value="messageBoardReceived">
<div id="pasing2"></div>
</div>
</div>








</div>
<!-- footer -->
<footer class="bg-light">
  <div class="section">
    <div class="container">
      <div class="row">
        <div class="col-md-3 col-sm-6 mb-5 mb-md-0 text-center text-sm-left">
          <h3 class="mb-4">Contact</h3>
          <p>20464 Hirthe Curve Suite, Emardton, CT 12471-4107</p>
          <p>+5(305) 785-0437</p>
          <p>info@example.com</p>
          <ul class="list-inline social-icons">
            <li class="list-inline-item"><a href="#"><i class="ti-facebook"></i></a></li>
            <li class="list-inline-item"><a href="#"><i class="ti-twitter-alt"></i></a></li>
            <li class="list-inline-item"><a href="#"><i class="ti-vimeo-alt"></i></a></li>
            <li class="list-inline-item"><a href="#"><i class="ti-google"></i></a></li>
          </ul>
        </div>
        <div class="col-md-3 col-sm-6 mb-5 mb-md-0 text-center text-sm-left">
          <h3 class="mb-4">Category</h3>
          <ul class="pl-0 list-unstyled">
            <li class="mb-2"><a class="text-color" href="shop.html">Men</a></li>
            <li class="mb-2"><a class="text-color" href="shop.html">Women</a></li>
            <li class="mb-2"><a class="text-color" href="shop.html">Kids</a></li>
            <li class="mb-2"><a class="text-color" href="shop.html">Accessories</a></li>
            <li class="mb-2"><a class="text-color" href="shop.html">Shoe</a></li>
          </ul>
        </div>
        <div class="col-md-3 col-sm-6 mb-5 mb-md-0 text-center text-sm-left">
          <h3 class="mb-4">Useful Link</h3>
          <ul class="pl-0 list-unstyled">
            <li class="mb-2"><a class="text-color" href="about.html">News & Tips</a></li>
            <li class="mb-2"><a class="text-color" href="about.html">About Us</a></li>
            <li class="mb-2"><a class="text-color" href="address.html">Support</a></li>
            <li class="mb-2"><a class="text-color" href="shop.html">Our Shop</a></li>
            <li class="mb-2"><a class="text-color" href="contact.html">Contact Us</a></li>
          </ul>
        </div>
        <div class="col-md-3 col-sm-6 text-center text-sm-left">
          <h3 class="mb-4">Our Policies</h3>
          <ul class="pl-0 list-unstyled">
            <li class="mb-2"><a class="text-color" href="404.html">Privacy Policy</a></li>
            <li class="mb-2"><a class="text-color" href="404.html">Terms & Conditions</a></li>
            <li class="mb-2"><a class="text-color" href="404.html">Cookie Policy</a></li>
            <li class="mb-2"><a class="text-color" href="404.html">Terms of Sale</a></li>
            <li class="mb-2"><a class="text-color" href="dashboard.html">Free Shipping & Returns</a></li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <div class="bg-dark py-4">
    <div class="container">
      <div class="row">
        <div class="col-md-5 text-center text-md-left mb-4 mb-md-0 align-self-center">
          <p class="text-white mb-0">Logo &copy; 2018 all right reserved</p>
        </div>
        <div class="col-md-2 text-center text-md-left mb-4 mb-md-0">
          <img src="images/logo-alt.png" alt="logo">
        </div>
        <div class="col-md-5 text-center text-md-right mb-4 mb-md-0">
          <ul class="list-inline">
            <li class="list-inline-item"><img src="images/payment-card/card-1.jpg" alt="card"></li>
            <li class="list-inline-item"><img src="images/payment-card/card-2.jpg" alt="card"></li>
            <li class="list-inline-item"><img src="images/payment-card/card-3.jpg" alt="card"></li>
            <li class="list-inline-item"><img src="images/payment-card/card-4.jpg" alt="card"></li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</footer>
<!-- /footer -->

</div>
<!-- /main wrapper -->

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
<script src="plugins/bootstrap-touchspin-master/jquery.bootstrap-touchspin.min.js"></script>
<script src="plugins/nice-select/jquery.nice-select.min.js"></script>
<script src="plugins/bootstrap-slider/bootstrap-slider.min.js"></script>
<!-- google map -->
<script src="../../../maps.googleapis.com/maps/api/js7402?key=AIzaSyBI14J_PNWVd-m0gnUBkjmhoQyNyd7nllA"></script>
<script src="plugins/google-map/gmap.js"></script>
<!-- Main Script -->
<script src="js/script.js"></script>
</body>

<!-- Mirrored from demo.themefisher.com/themefisher/elite-shop/about.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 21 Nov 2018 12:11:31 GMT -->
</html>
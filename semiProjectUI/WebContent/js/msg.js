	
	
	
let sendmsg = () => {
	$.ajax({
		url : 'Message.do',
		dataType: 'text',
		data : { 
			command : "sendMessage",
			msgTitle : $("#msgTitle").val(),
			msgContent : $("#msgContent").val(),
			receiver : $("#sendToWho").val()

		},
		success: function(msg){
			$("#msgTitle").val("");
			$("#msgContent").val("");
			$('#sendform').modal('hide');
			getPage("sentMsgPage",1);
		
		}
	})
	
}
	
	
	
	
let sendmsgPopup = (sender='아이디음슴') => {
if(sender==="아이디음슴"){
	console.log("상대 미지정시"+sender)
		$(".whowouldreceive").html("");
	$("#sendToWho").val("");
	$("#sendToWho").attr("type","text");
}else{
	console.log("상대지정시"+sender)
	$(".whowouldreceive").html(sender);
	$("#sendToWho").attr("type","hidden");
	$("#sendToWho").val(sender);
}
$('#sendform').modal('show');
} 

let viewReceivedMsg = (seq) =>{
	$.ajax({
		url:"Message.do",
		method:"post",
		data:{
			command : "msgChked",
			msgSeq : seq
		},success:function(res){
			if(res>0){
				viewWithModal(seq,"받은 쪽지");
		}}})}
	 
let viewSentMsg = (seq) =>{
				viewWithModal(seq,"보낸 쪽지");
		}




let	viewWithModal =(seq,sentOrReceived)=>{
	$(".sentOrReceived").html(sentOrReceived);
	$(".msgChkModalTitle").html($("#msgTitle"+seq).text());
	
	if(sentOrReceived==="보낸 쪽지"){
	$(".msgChkModalFromOrTo").html("To. "+$("#msgReceiver"+seq).text());				
	} else{
	$(".msgChkModalFromOrTo").html("From. "+$("#msgSender"+seq).text());				
	}
	
	$("#msgChkModalContent").html($("#msgContent"+seq).text());
	$(".msgChkModalDate").html($("#msgDate"+seq).text());
	$("#msgChkModal").modal('show');
	}



let getPage = (boardName, pg) => {
	console.log(boardName);
	console.log(pg);
	$.ajax({
		url:"Message.do",
		method:'post',
		data: {
			command:boardName,
			page:pg
		
		},success:function(resp){
			console.log(resp);
			if(boardName==="receivedMsgPage"){
				$(".receivedTable").html(resp);
			} else{
				console.log(resp);

				$(".sentTable").html(resp);
			} 
		}
		

	})
}



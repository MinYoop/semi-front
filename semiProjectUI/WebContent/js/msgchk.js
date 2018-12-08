

const msgchk=()=>{

$.ajax({
	url:"Message.do",
	dataType:"text",
	method:"post",
	data:{
		"command":"chkMessage"
	},
	success: function(data){
		if(data>0){
		$(".badge-danger").html("<button style='background-color"
				+":black;color:white' type='button' onClick='Message.do?command=msgFirstPage'class='btn-xs'>" 
				+"새 메세지 <span class='badge badge-danger badge-pill'>"+data+"</span>");
		}},
		error : function(e){
			console.log(e);
		}

})

	
}
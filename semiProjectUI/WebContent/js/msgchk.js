
let msgpg = () => {
	location.href="Message.do?command=msgFirstPage";
}


$.ajax({
	url:"usr.do",
	data:{
		command:"isSessionHasUsr"
	},
	success:function(res){
		if(res>0){
			$(".whenlogin").html("<h4 style='color:red'>로그인 상태입니다.</h4>");
			  setTimeout(function(){$("#subscriptionModal").modal('hide');},4000);

			$.ajax({
				url:"Message.do",
				data:{
					command:"chkMessage"
				},
				success: function(data){
					/*if(data>0){*/
					$(".chkmsg").html("<button style='background-color"
							+":black;color:white' type='button' onClick='msgpg()'class='btn-xs'>" 
							+"새 메세지 <span class='badge badge-danger badge-pill'>"+data+"</span>");
				//	}
				},
					error : function(e){
						console.log(e);
					}

			})
		}else{
			$(".myinfo").html(" ");
			$(".loginout").html("<a href='usr.do?command=loginPage'>로그인</a>");
		}
	}
})






	

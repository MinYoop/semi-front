$(function(){
	
	//totalCount = 전체 게시글 수 
	//page = 현재 페이지 
	//boardName = 현재 내가 보고 있는 게시판
	
	//listSize = 한 페이지당 보여줄 게시글 수 
	//totalPage = 총 페이지 수
	
	//var totalCount = document.getElementById("totalCount").value;
	
	$.ajax({
		url:"Message.do",
		data:{
			command: "countAll",
			boardName: $("#boardName").val()
		},
		success:function(res){
			pager(res);
		}
	});
	
	let pager = (res) => {
		
	
	var totalCount = res;
	var page = $("#page").val();
	var boardName = $("#boardName").val();
	
	var listSize = 10; 
	var totalPage = parseInt(totalCount / listSize); //총 페이지 수
	
	//총 게시글(totalCount)를 한페이지당 보여줄 게시글 수(listSize)로 나눴을때 나머지가 0보다크다는것은
	//게시글이 최소 1개이상 더 있다는 뜻이므로, 전체페이지를 하나더 추가해줘야함.
	if(totalCount % listSize > 0){
		totalPage++;
	}
	
	//전체 페이지(totalPage) 보다 현재 page가 크다면, 현재 페이지를 totalPage로 맞춰준다.
	//ex) 전체페이지는 24 인데 현재 페이지가 26이라면 현재 페이지를 24로 만들어주는 것임.
	if(totalPage < page){
		page = totalPage;
	}
	
	//하단에 표시될 페이지들을 출력해주기위하여 startPage & endPage 를 계산해준다.
	//내가 고른 페이지가 4 라면 1~10 까지 표시해주어야하며, 13이라면 11~20을 표시해줘야하기때문이다.
	var startPage = parseInt((page - 1) / 10) * 10 + 1;
	var endPage = startPage + listSize - 1;
	
	//마지막페이지(endPage)가 전체 페이지(totalPage) 보다 크다면, 마지막페이지를 전체페이지로 맞춰준다.
	if (endPage > totalPage) {
	    endPage = totalPage;
	}
	
	//-----------------------실제 하단에 페이징 표시되기 위한 코드----------------------------
	//현재 별 의미없이 공백이나 괄호들을 append해줬는데 일시적으로 눈에 잘 보이기위해 처리해준것임.
	//부트스트랩이나, css를 만들어서 처리한다면 저런것들은 지우면됨.
	//.append 해주는 코드 안에 <a>태그 말고 <li>로 해도됨 (원하는 형식대로 출력하게하면됨)
	if(startPage > 1){
		$("#pasing").append("<a href='Message.do?command="+boardName+"&page=1'>처음</a>");
	}else{
		$("#pasing").append("처음");
	}
	
	$("#pasing").append(" ");
	
	if(page > 1){
		$("#pasing").append("<a href='Message.do?command="+boardName+"&page="+(page-1)+"'>이전</a>");
	}else{
		$("#pasing").append("이전");
	}
	
	
	for(var iCount = startPage; iCount <= endPage; iCount++) {
	    if (iCount == page) {
	       $("#pasing").append("<b> <a href='Message.do?command="+boardName+"&page="+iCount+"'>" + iCount + "</a> </b>");
	    } else {
	    	$("#pasing").append("<a href='Message.do?command="+boardName+"&page="+iCount+"'>" + iCount + " </a>");
	    }
	}
	
	
	if(page < totalPage){
		$("#pasing").append("<a href='Message.do?command="+boardName+"&page="+(Number(page)+1)+"'>다음</a>");
	}else{
		$("#pasing").append("다음");
	}
	
	$("#pasing").append(" ");
	
	if(endPage < totalPage){
		$("#pasing").append("<a href='Message.do?command="+boardName+"&page="+totalPage+"'>끝</a>");
	}else{
		$("#pasing").append("끝");
	}
	$("#pasing").append("<br>");
	
	/*$("#pasing").append(  "총 게시글 수 : " + totalCount +"<br>" +
						"게시판에 보여줄 게시글 수 : "+listSize+" <br>" +
						"게시판 총 페이지 : "+totalPage+" <br>" +
						"시작페이지 : "+startPage+" <br>" +
						"엔드페이지 : "+endPage+" <br>" +
						"내가 보고있는 게시판 이름 : "+boardName+"<br>");*/
						
}


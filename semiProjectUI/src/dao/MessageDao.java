package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.SqlMapConfig;
import dto.Message;
import dto.NoticeBoardDto;
import dto.PageSelector;

public class MessageDao extends SqlMapConfig {

	private String namespace = "MsgSql.";

	public MessageDao() {
		super();
	}

	
	public int countAll(HashMap<String,String> pageinfo) {  
		int totalCount = 0;
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			totalCount = session.selectOne( namespace + "countAll", pageinfo);

		} catch (Exception e) {

		} finally {
			session.close();
		}
		System.out.print(pageinfo.get("BoardName")+"토탈카운트 "+ 
		totalCount + pageinfo.get("nickName"));
		return totalCount; 
		
	}
	public int sendMessage(HashMap<String, String> newMsg) { // -----작업완료

		int res = 0;

		SqlSession session = getSqlSessionFactory().openSession(true);
		res = session.insert(namespace + "sendMsg", newMsg);
		session.close();
		return res;

	}

	public List<Message> selectSent(PageSelector pgs) { //

		List<Message> res = new ArrayList<Message>();

		SqlSession session = null;
		session = getSqlSessionFactory().openSession(true); // openSession(true) : autoCommit
		res = session.selectList(namespace + "selectSent", pgs);

		session.close();

		return res;
	}

	public List<Message> selectReceived(PageSelector pgs) {//-----pgs에 side,nickname,page 넣으 위와 이것 둘을 하나로 줄일 수 있으나 시간관계상 생략 

		List<Message> res = new ArrayList<Message>();

		SqlSession session = null;
		session = getSqlSessionFactory().openSession(true); // openSession(true) : autoCommit
		res = session.selectList(namespace + "selectReceived", pgs);

		session.close();

		return res;
	}

	public Message selectOne(int msgSeq) {

		Message res = null;

		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession(true);
			res = (Message) session.selectList(namespace + "selectOne", msgSeq);

		} catch (Exception e) {

		} finally {
			session.close();
		}

		return res;
	}

	public int delBySender(int msgSeq) {// 매퍼 작업 필요, 딜리트 작업 필요

		int res = 0;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.update(namespace + "deleteBySender", msgSeq);

		} catch (Exception e) {

		} finally {
			session.close();
		}

		return res;
	}

	public int delByReceiver(int msgSeq) {// 매퍼 작업 필요 , dao 작업 필요

		int res = 0;

		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.update(namespace + "deleteByReceiver", msgSeq);

		} catch (Exception e) {

		} finally {
			session.close();
		}

		return res;

	}

	public int selectNeverChk(String nickName) {
		// 받은 사람이 usrSeq인 메세지들의 receiverchk가 0인 메세지의 개수 리턴
		int res = 0;
		System.out.println("메세지 체크 닉네임 : "+nickName);
		HashMap<String,String> nick = new HashMap<String,String>();
		nick.put("nickName", nickName);
		SqlSession dbsession = getSqlSessionFactory().openSession(true);
		res = dbsession.selectOne(namespace + "selectNeverChk", nickName);
		dbsession.close();
		return res;
	}

	// 아... 아마도 이 아래로 biz 부분일 듯.
	public PageSelector PgsMaker(int pg, String boardName) {
		int listSize = 10;
		int page = pg;
		int startNum = (page - 1) * 10 + 1;
		int endNum = startNum + listSize - 1;
		PageSelector pageinfo = new PageSelector(boardName, startNum, endNum);
		return pageinfo;

	}

	public int countAllMessagesSent(HashMap<String,String> pageinfo) { //pageinfo에 side와 nickName 
		int totalCount = 0;
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			totalCount = session.selectOne( namespace + "countAllMessagesSent", pageinfo);

		} catch (Exception e) {

		} finally {
			session.close();
		}
		System.out.print("sent토탈카운트 "+ totalCount + "  "+pageinfo.get("side") + " "+pageinfo.get("nickName"));
		return totalCount; 
		
	}
	
	
	public int countAllMessagesReceived(HashMap<String,String> pageinfo) { //pageinfo에 side와 nickName 
		int totalCount = 0;
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			totalCount = session.selectOne( namespace + "countAllMessagesReceived", pageinfo);

		} catch (Exception e) {

		} finally {
			session.close();
		}
		System.out.print("received토탈카운트 "+ totalCount + "  "+pageinfo.get("side") + " "+pageinfo.get("nickName"));
		return totalCount; 
		
	}
		
	private String pageLineMaker(HashMap<String, String> pageinfo) {
		String pageLine = "";
		int totalPage = Integer.parseInt(pageinfo.get("totalPage"));
		int startPage = Integer.parseInt(pageinfo.get("startPage"));
		int endPage = Integer.parseInt(pageinfo.get("endPage"));
		int page = Integer.parseInt(pageinfo.get("page"));
		String boardName=new String();
		if(pageinfo.get("boardName")!=null) {
		if(pageinfo.get("boardName").equals("NOTICE_BOARD_TB")) {
			boardName=pageinfo.get("boardName");
		}}

		else{
			boardName=pageinfo.get("side").equals("receiver")?"receivedMsgPage":"sentMsgPage";
		}
		
		if(startPage > 1){
			pageLine +="<a onclick='getPage(\""+boardName+"\",1)'>처음</a>";
		}else{
			pageLine+="처음";
		}
		
		pageLine+=" ";
		
		if(page > 1){
			pageLine+="<a onclick='getPage(\""+boardName+"\","+(page-1)+")'>이전</a>";
		}else{
			pageLine+="이전";
		}
		
		for(int i = startPage; i <= endPage; i++) {
		    if (i == page) {
		    	pageLine+="<b> <a onclick='getPage(\""+boardName+"\","+i+")'>" + i + "</a> </b>";
		    } else {
		    	pageLine+="<a onclick='getPage(\""+boardName+"\","+i+")'>" + i + "</a>";
		    }
		}
		if(page < totalPage){
			pageLine+="<a onclick='getPage(\""+boardName+"\","+((page)+1)+")'>다음</a>";
		}else{
			pageLine+="다음";
		}
		
		pageLine+=" ";
		
		if(endPage < totalPage){
			pageLine+="<a onclick='getPage(\""+boardName+"\","+totalPage+")'>끝</a>";
		}else{
			pageLine+="끝";
		}
		pageLine+="<br>";
		
		System.out.println(pageLine.equals(null)?"페이지 null":pageLine);

		
		return pageLine;
	}

	public String pagingInfo(HashMap<String,String> pageinfo) {//side(=receiver or sender) 와 nickname과 page를 들고 있음.

		int totalCount =pageinfo.get("side").equals("sender")?countAllMessagesSent(pageinfo):countAllMessagesReceived(pageinfo);
		pageinfo.put("totalCount",Integer.toString(totalCount));
		return pagingInfo2(pageinfo);
	}
	
	
	public String pagingInfo2(HashMap<String,String> pageinfo) {
		int totalCount = Integer.parseInt(pageinfo.get("totalCount"));
		int listSize = 10;
		int totalPage = totalCount%10>0?((int)(totalCount/10)+1):((int)(totalCount/10));
		int page = Integer.parseInt(pageinfo.get("page"))>totalPage?totalPage:Integer.parseInt(pageinfo.get("page"));
		int startPage = ((int)((page-1)/10)*10+1);
		int endPage = startPage + listSize - 1;
		if(endPage>totalPage) {
			endPage =totalPage;
		}
		pageinfo.put("totalPage", Integer.toString(totalPage));
		pageinfo.put("startPage",Integer.toString(startPage));
		pageinfo.put("endPage",Integer.toString(endPage));
		pageinfo.put("page",Integer.toString(page));
		return pageLineMaker(pageinfo);
		
	}
		
	public String makeReceived(List<Message> rclist) {
		String received = "";
		received = "<table>		<col width=\"100px\">\n" + 
				"		<col width=\"100px\">\n" + 
				"		<col width=\"200px\">\n" + 
				"		<col width=\"120px\">\n" + 
				"		<col width=\"80px\">\n" + 
				"		<col width=\"80px\">\n" + 
				"		\n" + 
				"		<tr>\n" + 
				"			<th>확인</th>\n" + 
				"			<th>보낸이</th>\n" + 
				"			<th>제목</th>\n" + 
				"			<th>작성일</th>\n" + 
				"			<th>답장</th>\n" + 
				"			<th>삭제</th>\n" + 
				"		</tr>	\n" + 
				"		\n";
		
if(rclist ==null) {
	received += 

				"				<tr>\n" + 
				"					<td colspan=\"6\" style=\"text-align:center\">----받은 쪽지가 없습니다.----</td>\n" + 
				"				</tr>		\n";
} else {
	received += 
			"					<tr>\n";
	for(Message i : rclist) {
	received +=
				"						<td>"+(i.getReceiverChk()>0?"확인":"<b>미확인</b>")+"</td>\n" + 
				"						<td id=\"msgSender"+i.getMsgSeq()+"\">"+i.getSender()+"</td>\n" + 
				"						<td id=\"msgTitle"+i.getMsgSeq()+"\"><a onclick=\"viewReceivedMsg("+i.getMsgSeq()+")\">"+i.getMsgTitle()+"</a></td>\n" + 
				"						<td id=\"msgDate"+i.getMsgSeq()+"\"><h6>"+i.getSendDate()+"</h6></td>\n" + 
				"						<td><button class=\"btn-light\" onclick='sendmsgPopup(\""+i.getSender()+"\")\'>클릭</button>\n" + 
				"						<td><a href=\"Message.do?command=delete&msgSeq="+i.getMsgSeq()+"\">삭제</a></td>\n\n" + 
				"					</tr>\n"+
				"						<div style=\"display:none\" id=\"msgContent"+i.getMsgSeq()+"\">"+i.getMsgContent()+"</div>";
	}
	received +=			"		<tr>\n" + 
				"			<td colspan=\"6\">\n" + 
				"			</td>\n" + 
				"		</tr></table>";

	}
System.out.println(received);

		return received;
	}

	public String makeSent(List<Message> sdlist) {
		String received = "";
		received = "	<table>	<col width=\"100\">\n" + 
				"		<col width=\"100px\">\n" + 
				"		<col width=\"200px\">\n" + 
				"		<col width=\"120px\">\n" + 
				"		<col width=\"80px\">\n" + 
				"		\n" + 
				"		<tr>\n" + 
				"			<th>확인</th>\n" + 
				"			<th>받은이</th>\n" + 
				"			<th>제목</th>\n" + 
				"			<th>작성일</th>\n" + 
				"			<th>삭제</th>\n" + 
				"		</tr>	\n" + 
				"		\n";
		
if(sdlist ==null) {
	received += 

				"				<tr>\n" + 
				"					<td colspan=\"5\" style=\"text-align:center\">----보낸 쪽지가 없습니다.----</td>\n" + 
				"				</tr>		\n";
} else {
	
	for(Message i : sdlist) {
	received +=

				"					<tr>\n" + 
				"						<td>"+(i.getReceiverChk()>0?"확인":"<b>미확인</b>")+"</td>\n" + 
				"						<td id=\"msgReceiver"+i.getMsgSeq()+"\">"+i.getReceiver()+"</td>\n" + 
				"						<td id=\"msgTitle"+i.getMsgSeq()+"\"><a onclick=\"viewSentMsg("+i.getMsgSeq()+")\">"+i.getMsgTitle()+"</a></td>\n" + 
				"						<td id=\"msgDate"+i.getMsgSeq()+"\"><h6>"+i.getSendDate()+"</h6></td>\n" + 
				"						<td><a href=\"Message.do?command=delete&msgSeq="+i.getMsgSeq()+"\">삭제</a></td>\n\n" + 
				"					</tr>\n"+
				"						<div style=\"display:none\" id=\"msgContent"+i.getMsgSeq()+"\">"+i.getMsgContent()+"</div>";
	}
	received +=			"</table>";

	}

System.out.println(received);
		return received;

}

	public int msgChked(HashMap<String, String> msgChked) {
		int res = 0;

		SqlSession session = getSqlSessionFactory().openSession(true);
		res = session.update(namespace + "msgChked", msgChked);
		session.close();
		return res;

	}


	public List<NoticeBoardDto> selectNotice(PageSelector pageselector) {
		List<NoticeBoardDto> res = new ArrayList<NoticeBoardDto>();

		SqlSession session = null;
		session = getSqlSessionFactory().openSession(true); // openSession(true) : autoCommit
		res = session.selectList(namespace + "selectNotice", pageselector);

		session.close();

		return res;
	}
}

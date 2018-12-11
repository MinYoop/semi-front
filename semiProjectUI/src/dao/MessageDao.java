package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.SqlMapConfig;
import dto.Message;
import dto.PageSelector;

public class MessageDao extends SqlMapConfig {

	private String namespace = "MsgSql.";

	public MessageDao() {
		super();
	}

	public int sendMessage(HashMap<String, String> newMsg) { // -----작업완료

		int res = 0;

		SqlSession session = getSqlSessionFactory().openSession(true);
		res = session.insert(namespace + "sendMsg", newMsg);
		session.close();
		return res;

	}

	public List<Message> selectSent(PageSelector pgs) { // ------작업완료

		List<Message> res = new ArrayList<Message>();

		SqlSession session = null;
		session = getSqlSessionFactory().openSession(true); // openSession(true) : autoCommit
		res = session.selectList(namespace + "selectSent", pgs);

		session.close();

		return res;
	}

	public List<Message> selectReceived(PageSelector pgs) {

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

	public int countAllMessages(HashMap<String,String> pageinfo) {
		int totalCount = 0;
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			totalCount = session.selectOne( namespace + "countAllMessages", pageinfo);

		} catch (Exception e) {

		} finally {
			session.close();
		}
		return totalCount;
	}
		
	private String pageLineMaker(HashMap<String, String> pageinfo) {
		String pageLine = "";
		int totalPage = Integer.parseInt(pageinfo.get("totalPage"));
		int startPage = Integer.parseInt(pageinfo.get("startPage"));
		int endPage = Integer.parseInt(pageinfo.get("endPage"));
		int page = Integer.parseInt(pageinfo.get("page"));
		
		if(startPage > 1){
			pageLine.concat("<a onclick='getPage(1)'>처음</a>");
		}else{
			pageLine.concat("처음");
		}
		
		pageLine.concat(" ");
		
		if(page > 1){
			pageLine.concat("<a onclick='getPage("+(page-1)+")'>이전</a>");
		}else{
			pageLine.concat("이전");
		}
		
		for(int i = startPage; i <= endPage; i++) {
		    if (i == page) {
		    	pageLine.concat("<b> <a onclick='getPage("+i+")'>" + i + "</a> </b>");
		    } else {
		    	pageLine.concat("<a onclick='getPage("+i+")'>" + i + "</a>");
		    }
		}
		if(page < totalPage){
			pageLine.concat("<a onclick='getPage("+((page)+1)+")'>다음</a>");
		}else{
			pageLine.concat("다음");
		}
		
		pageLine.concat(" ");
		
		if(endPage < totalPage){
			pageLine.concat("<a onclick='getPage("+totalPage+")'>끝</a>");
		}else{
			pageLine.concat("끝");
		}
		pageLine.concat("<br>");
		
		return pageLine;
	}

	public String pagingInfo(HashMap<String,String> pageinfo) {//side(=receiver or sender) 와 nickname과 page를 들고 있음.

		int totalCount =countAllMessages(pageinfo);
		int listSize = 10;
		int totalPage = totalCount%10>0?((int)(totalCount/10)+1):((int)(totalCount/10));
		int page = Integer.parseInt(pageinfo.get("page"))>totalPage?totalPage:Integer.parseInt(pageinfo.get("page"));
		int startPage = ((int)((page-1)/10)*10+1);
		int endPage = startPage + listSize - 1;
		
		pageinfo.put("totalCount",Integer.toString(totalCount));
		pageinfo.put("startPage",Integer.toString(startPage));
		pageinfo.put("endPage",Integer.toString(endPage));
		pageinfo.put("page",Integer.toString(page));
		return pageLineMaker(pageinfo);
		
	}
		
	public String makeReceived(List<Message> rclist) {
		String received = "";
		received = "<table>		<col width=\"2%\">\n" + 
				"		<col width=\"4%\">\n" + 
				"		<col width=\"6%\">\n" + 
				"		<col width=\"4%\">\n" + 
				"		<col width=\"2%\">\n" + 
				"		<col width=\"2%\">\n" + 
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
	
	for(Message i : rclist) {
	received +=

				"					<tr>\n" + 
				"						<td>"+(i.getRecieverChk()>0?"확인":"<b>미확인</b>")+"</td>\n" + 
				"						<td id=\"msgFrom"+i.getMsgSeq()+">"+i.getSender()+"</td>\n" + 
				"						<td id=\"msgTitle"+i.getMsgSeq()+"\"><a onclick=\"viewMsg("+i.getMsgSeq()+"\")>"+i.getMsgTitle()+"</a></td>\n" + 
				"						<td id=\"msgDate"+i.getMsgSeq()+"\">"+i.getSendDate()+"</td>\n" + 
				"						<td><button class=\"btn btn-primary w-10\" onclick=\"sendmsgPopup("+i.getSender()+")\">클릭</button>\n" + 
				"						<td><a href=\"controller.do?command=delete&msgSeq="+i.getMsgSeq()+"\">삭제</a></td>\n\n" + 
				"					</tr>\n"+
				"						<div style=\"display:none\" id=\"msgContent"+i.getMsgSeq()+"\">"+i.getMsgContent()+"</div>";
	}
	received +=			"		<tr>\n" + 
				"			<td colspan=\"6\">\n" + 
				"			</td>\n" + 
				"		</tr></table>";

	}

		return received;
	}

	public String makeSent(List<Message> sdlist) {
		String received = "";
		received = "	<table>	<col width=\"2%\">\n" + 
				"		<col width=\"4%\">\n" + 
				"		<col width=\"6%\">\n" + 
				"		<col width=\"4%\">\n" + 
				"		<col width=\"2%\">\n" + 
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
				"						<td>"+(i.getRecieverChk()>0?"확인":"<b>미확인</b>")+"</td>\n" + 
				"						<td id=\"msgReceiver"+i.getMsgSeq()+">"+i.getReceiver()+"</td>\n" + 
				"						<td id=\"msgTitle"+i.getMsgSeq()+"\"><a onclick=\"viewMsg("+i.getMsgSeq()+"\")>"+i.getMsgTitle()+"</a></td>\n" + 
				"						<td id=\"msgDate"+i.getMsgSeq()+"\">"+i.getSendDate()+"</td>\n" + 
				"						<td><a href=\"controller.do?command=delete&msgSeq="+i.getMsgSeq()+"\">삭제</a></td>\n\n" + 
				"					</tr>\n"+
				"						<div style=\"display:none\" id=\"msgContent"+i.getMsgSeq()+"\">"+i.getMsgContent()+"</div>";
	}
	received +=			"		<tr>\n" + 
				"			<td colspan=\"5\">\n" + 
				"<input type=\"button\" value=\"쪽지 보내기\" onclick=\"sendmsgPopup()\">"+
				"			</td>\n" + 
				"		</tr></table>";

	}
		return received;

}
}

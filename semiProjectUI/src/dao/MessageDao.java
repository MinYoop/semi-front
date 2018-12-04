package dao;

import java.util.ArrayList;

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
	
	public int sendMessage(Message newMsg) {				//-----작업완료 

		
		int res = 0;
		
		SqlSession session = getSqlSessionFactory().openSession(true);
		res = session.insert(namespace+"sendMsg",newMsg);
		session.close();
		return res;
		
	}
	
	public List<Message> selectSent(int usrSeq, int page){ //------작업완료 		
		int listSize =10;
		
		int startNum = (page-1) * 10 + 1;
		int endNum = startNum + listSize - 1;
		PageSelector sent = new PageSelector(Integer.toString(usrSeq),startNum,endNum);
		
		List<Message> res = new ArrayList<Message>();
		
		SqlSession session = null;
		session=getSqlSessionFactory().openSession(true);   //openSession(true) : autoCommit
		res = session.selectList(namespace+"selectSent",sent);
		
		session.close();
		
		return res;
	}
	
	public List<Message> selectReceived(int usrSeq, int page){	
	
		
		List<Message> res = new ArrayList<Message>();
		
		SqlSession session = null;
		session=getSqlSessionFactory().openSession(true);   //openSession(true) : autoCommit
		res = session.selectList(namespace+"selectRecieved");
		
		session.close();
		
		return res;
	}
	
	public Message selectOne(int msgSeq) { 

		Message res =null;
		
		SqlSession session = null;
		
		try {
			session=getSqlSessionFactory().openSession(true);
		res = (Message) session.selectList(namespace+"selectOne",msgSeq);
			
		} catch(Exception e) {
			
		} finally {
			session.close();
		}

		return res;		
	}
	
	public int delBySender(int msgSeq) {

		int res = 0;
		
SqlSession session = null;
		
		try {
			session=getSqlSessionFactory().openSession(true);
		res = session.delete(namespace+"deleteBySender",msgSeq);
			
		} catch(Exception e) {
			
		} finally {
			session.close();
		}
		
		return res;
	}
	
	public int delByReceiver(int msgSeq) {


		int res = 0;
		
		SqlSession session = null;
				
				try {
					session=getSqlSessionFactory().openSession(true);
				res = session.delete(namespace+"deleteByReceiver",msgSeq);
					
				} catch(Exception e) {
					
				} finally {
					session.close();
				}
				
				return res;
	
	}
	
	public int selectNeverChk(int usrSeq) {
		//받은 사람이 usrSeq인 메세지들의 receiverchk가 0인 메세지의 개수 리턴  

		int res = 0;
		
		
		return res;
	}
	
	

}

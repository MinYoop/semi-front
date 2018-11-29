package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.SqlMapConfig;
import dto.Message;


public class MessageDao extends SqlMapConfig {
	
	private String namespace = "MsgSql.";
	
	public MessageDao() {
		super();
	}
	
	public int sendMessage(Message newMsg) {

		
		int res = 0;
		
		SqlSession session = getSqlSessionFactory().openSession(true);
		res = session.insert(namespace+"sendMsg",newMsg);
		session.close();
		return res;
	}
	
	public List<Message> selectSent(int usrSeq){		
	 
		
		List<Message> res = new ArrayList<Message>();
		
		SqlSession session = null;
		session=getSqlSessionFactory().openSession(true);   //openSession(true) : autoCommit
		res = session.selectList(namespace+"selectSent");
		
		session.close();
		
		return res;
	}
	
	public List<Message> selectRecieved(int usrSeq){	
	
		
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
				res = session.delete(namespace+"deleteBySender",msgSeq);
					
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

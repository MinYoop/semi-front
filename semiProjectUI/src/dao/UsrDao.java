package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.SqlMapConfig;
import dto.User;
import dao.SHA256;



public class UsrDao extends SqlMapConfig {
	
	private String namespace = "UsrSql.";
	
	public UsrDao() {
		super();
	}
		
	public int insertUsr(User newUsr) {
		
		int res = 0;
		
		SqlSession dbsession = getSqlSessionFactory().openSession(true);
		res = dbsession.insert(namespace+"insertUsr",newUsr);
		dbsession.close();
		return res;
	}
	
	public List<User> selectAll(){			//관리자 전용  
		
		List<User> res = new ArrayList<User>();
		
		SqlSession dbsession = null;
		dbsession=getSqlSessionFactory().openSession(true);   //openSession(true) : autoCommit
		res = dbsession.selectList(namespace+"selectAll");
		
		dbsession.close();
		
		return res;
	}
	
	public User selectOneBySeq(int usr_seq) {			//개인정보 조회시, 유저 평가 확인시 사용 

		
		User res =null;
		
		SqlSession dbsession = null;
		
		try {
			dbsession=getSqlSessionFactory().openSession(true);
		res = (User) dbsession.selectList(namespace+"selectOne",usr_seq);
			
		} catch(Exception e) {
			
		} finally {
			dbsession.close();
		}

		return res;		
	}
	
	public int delete(int usr_seq) {
		int res = 0;
		
		SqlSession dbsession = null;
		
		try {
			dbsession=getSqlSessionFactory().openSession(true);
		res = dbsession.delete(namespace+"delete",usr_seq);
			
		} catch(Exception e) {
			
		} finally {
			dbsession.close();
		}
		
		return res;
	}
	
	public int update(User usr) {
		int res = 0;
		
		return res;
	}

	public Object cryptusr(String email) { //sha256암호화한 값...
		
		return SHA256.getSHA256(email);
	}

	public User selectOne(String sns,String snsId) {
		// SELECT * FROM USER_TB WHERE SNS = ? AND SNSID = ?
		List<User> res = new ArrayList<User>();
		User param = new User();
		param.setSns(sns);
		param.setSnsId(snsId);
		SqlSession dbsession = null;
		
		
			dbsession=getSqlSessionFactory().openSession(true);
		res = dbsession.selectList(namespace+"selectOne",param);
			

			dbsession.close();
		

		return res.size()>0?res.get(0):null;		
	}
	
	
	
	
	
	
	
	
	

}

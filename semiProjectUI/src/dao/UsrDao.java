package dao;

import java.util.ArrayList;
import java.util.HashMap;
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
	
	public User selectOneByNickName(String nickName) {			//개인정보 조회시, 유저 평가 확인시 사용 

		
		List<User> res =new ArrayList<User>();
		
		SqlSession dbsession = null;
		
		try {
			dbsession=getSqlSessionFactory().openSession(true);
		res =  dbsession.selectList(namespace+"selectOneByNick",nickName);
			
		} catch(Exception e) {
			
		} finally {
			dbsession.close();
		}

		return res.get(0) != null?res.get(0):null;
		}
	
	
	public int delete(String nickname) {
		int res = 0;
		
		SqlSession dbsession = null;
		
		try {
			dbsession=getSqlSessionFactory().openSession(true);
		res = dbsession.delete(namespace+"delete",nickname);
			
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
		HashMap<String,String> param = new HashMap<String,String>();
		User res = new User();
		param.put("sns",sns);
		param.put("snsId",snsId);
		SqlSession dbsession = null;
		
		
			dbsession=getSqlSessionFactory().openSession(true);
		res = dbsession.selectOne(namespace+"selectOneUsr",param);
			

			dbsession.close();
			return res != null?res:null;

	}
	
	
	
	
	
	
	
	
	

}

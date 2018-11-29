package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.SqlMapConfig;
import dto.User;


public class UsrDao extends SqlMapConfig {
	
	private String namespace = "UsrSql.";
	
	public UsrDao() {
		super();
	}
		
	public int insertUsr(User newUsr) {
		
		int res = 0;
		
		SqlSession session = getSqlSessionFactory().openSession(true);
		res = session.insert(namespace+"insertUsr",newUsr);
		session.close();
		return res;
	}
	
	public List<User> selectAll(){			//관리자 전용  
		
		List<User> res = new ArrayList<User>();
		
		SqlSession session = null;
		session=getSqlSessionFactory().openSession(true);   //openSession(true) : autoCommit
		res = session.selectList(namespace+"selectAll");
		
		session.close();
		
		return res;
	}
	
	public User selectOne(int usr_seq) {			//개인정보 조회시, 유저 평가 확인시 사용 

		
		User res =null;
		
		SqlSession session = null;
		
		try {
			session=getSqlSessionFactory().openSession(true);
		res = (User) session.selectList(namespace+"selectOne",usr_seq);
			
		} catch(Exception e) {
			
		} finally {
			session.close();
		}

		return res;		
	}
	
	public int delete(int usr_seq) {
		int res = 0;
		
SqlSession session = null;
		
		try {
			session=getSqlSessionFactory().openSession(true);
		res = session.delete(namespace+"delete",usr_seq);
			
		} catch(Exception e) {
			
		} finally {
			session.close();
		}
		
		return res;
	}
	
	public int update(User usr) {
		int res = 0;
		
		return res;
	}
	
	
	
	
	
	
	
	
	
	

}

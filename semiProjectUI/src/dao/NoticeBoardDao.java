package dao;

import java.util.List;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import dto.Admin;
import dto.NoticeBoardDto;

public class NoticeBoardDao extends SqlMapConfig {
	
	private String namespace = "NoticeBoard.";
	

			public List<NoticeBoardDto> selectAll() {

				List<NoticeBoardDto> res = new ArrayList<NoticeBoardDto>();
				SqlSession session = null;

				// openSession(true) = autoCommit;
				session = getSqlSessionFactory().openSession(true);
				res = session.selectList(namespace + "selectAllNotice");

				session.close();

				return res;

			}
		
	
		public int insertNotice(NoticeBoardDto dto) {		
		
		SqlSession session = null;
		int res = 0;
		
			
			try {
				session = getSqlSessionFactory().openSession(true);
				res = session.insert(namespace + "insertNotice", dto);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			return res;
		
		
		
		
		}
	
	
	public int updateNotice(NoticeBoardDto dto) {			
		
			SqlSession session = null;
			int res = 0;
			
			try {// openSession(true) = autoCommit;
				session = getSqlSessionFactory().openSession(true);
				res = session.update(namespace + "updateNotice", dto);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			
			return res;
		}
		
	public NoticeBoardDto selectOne(int notice_seq) {	
		
		NoticeBoardDto res = null;
		SqlSession session = null;

		try {// openSession(true) = autoCommit;
				session = getSqlSessionFactory().openSession(true);
				res = session.selectOne(namespace + "selectOneNotice", notice_seq);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();			
	    }	
		return res;
	}
	
	
public Admin selectOneAdmin(String adminId) {	
		
		Admin res = new Admin();
		SqlSession session = null;

		try {// openSession(true) = autoCommit;
				session = getSqlSessionFactory().openSession(true);
				res = session.selectOne(namespace + "selectOneAdmin", adminId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();			
	    }	
		return res;
	}
	
	
	public int DeleteNotice(int notice_seq) {			
		SqlSession session = null;
		int res = 0;

		try {// openSession(true) = autoCommit;
			session = getSqlSessionFactory().openSession(true);
			res = session.delete(namespace + "deleteNotice", notice_seq);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return res;
	}

	
}

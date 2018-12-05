package dao;

import java.util.List;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import dto.NoticeBoard;

public class NoticeBoardDao extends SqlMapConfig {
	
	private String namespace = "IUSQL.";
	

			public List<NoticeBoard> selectAll() {

				List<NoticeBoard> res = new ArrayList<NoticeBoard>();
				SqlSession session = null;

				// openSession(true) = autoCommit;
				session = getSqlSessionFactory().openSession(true);
				res = session.selectList(namespace + "selectAll");

				session.close();

				return res;

			}
		
	
	public int insertNotice(NoticeBoard dto) {			//������ ���� ����
		
		SqlSession session = null;
		int res = 0;
		
			
			try {// openSession(true) = autoCommit;
				session = getSqlSessionFactory().openSession(true);
				res = session.insert(namespace + "insert", dto);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			return res;
		
		
		
		
		}
	
	
	public int updateNotice(NoticeBoard dto) {			//������ ���� ����
		
			SqlSession session = null;
			int res = 0;
			
			try {// openSession(true) = autoCommit;
				session = getSqlSessionFactory().openSession(true);
				res = session.update(namespace + "update", dto);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			
			return res;
		}
		
	public NoticeBoard selectOne(int noticeSeq) {	
		
		NoticeBoard res = null;
		SqlSession session = null;

		try {// openSession(true) = autoCommit;
				session = getSqlSessionFactory().openSession(true);
				res = session.selectOne(namespace + "selectOne", noticeSeq);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();			
	    }	
		return res;
	}
	
	
	public int DeleteNotice(int noticeSeq) {			//������ ���� ����
		SqlSession session = null;
		int res = 0;

		try {// openSession(true) = autoCommit;
			session = getSqlSessionFactory().openSession(true);
			res = session.delete(namespace + "delete", noticeSeq);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return res;
	}
	
	
}

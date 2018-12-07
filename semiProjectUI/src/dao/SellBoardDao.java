package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;




import dto.SellBoard;

public class SellBoardDao extends SqlMapConfig{
	
	private String namespace = "board.";
	
	public List<SellBoard> selectAll(){		
		List<SellBoard> allBoard = new ArrayList<SellBoard>();
		
		SqlSession session = null;
	      session = getSqlSessionFactory().openSession(true);   //openSession(true) : autoCommit
	      //res = session.selectList("com.my.myboard.selectAll");
	      allBoard = session.selectList(namespace+"selectAllSellBoard");
	      
	      session.close();
		
		return allBoard;
	}
	
	
	
	public SellBoard selectOne(int sellseq) {	//작업필요 

		SqlSession session = null;
		   SellBoard res = null;
		   
		   try {
			   session = getSqlSessionFactory().openSession(true);
			   res = session.selectOne(namespace+"selectOneSellBoard",sellseq);
		   }catch(Exception e) {
			   e.printStackTrace();
		   }finally {
			   session.close();
		   }
		   
		   return res;
	   }
        
	public boolean insert(SellBoard dto) {
		   
		   SqlSession session=null;
		   int res=0;
		   
		   try {
			   session = getSqlSessionFactory().openSession(true);
			   res=session.insert(namespace+"insertSellBoard",dto);
			   
		   }catch(Exception e) {
			   e.printStackTrace();
		   }finally {
			   session.close();
		   }
		   
		   return (res>0)?true:false;
	   }
	   
	   public boolean update(SellBoard dto) {
		   
		   SqlSession session=null;
		   int res=0;
		   
		   try {
			   session = getSqlSessionFactory().openSession(true);
			   res=session.insert(namespace+"updateSellBoard",dto);
			   
		   }catch(Exception e) {
			   e.printStackTrace();
		   }finally {
			   session.close();
		   }
		   
		   return res>0 ? true : false;
	   }
	   
	   public boolean delete(int sellseq) {
		   
		   SqlSession session = null;
		   int res = 0;
		   
		   try {
			   session = getSqlSessionFactory().openSession(true);
			   res = session.delete(namespace+"deleteSellBoard",sellseq);
		   }catch(Exception e) {
			   e.printStackTrace();
		   }finally {
			   session.close();
		   }
		   
		   return res>0?true:false;
	   }
	
//semiProjectUI

}
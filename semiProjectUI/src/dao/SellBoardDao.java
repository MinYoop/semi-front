package dao;

import java.util.ArrayList;
import java.util.HashMap;
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
	
	public List<String> contentcutter(String k) {
	 
		System.out.println("시작");
		System.out.println(k);

		int tmpintstart =0;
		int tmpintend = 0;
		int a = 0;
		int b = 0;
		List<String> tmpstr = new ArrayList<String>();
				
		while(a>-1) {//더 이상 없을 때 -1 을 뽑아내므로.
			
		tmpintstart = k.indexOf("<img", a);
		System.out.println(Integer.toString(tmpintstart));

		if(a>-1) {
			tmpintend =k.indexOf(".jpg\\\">", tmpintstart)+7;
			if(tmpintend>-1) {
				tmpstr.add(k.substring(tmpintstart, tmpintend));
				System.out.println(tmpstr.get(b));
			}
			a=tmpintend;
			b++;
		}
		
		
		}
		return tmpstr;
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
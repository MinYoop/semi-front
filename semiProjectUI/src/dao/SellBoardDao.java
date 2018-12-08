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
	
	public int insert(SellBoard dto) {		//작업필요 
		int res =0;
		return res;
	}
		
	public SellBoard selectOne(int parentboardno) {	//작업필요 

		return null;
    }
        
    public int insertArticle(SellBoard dto) {		//작업필요 
       int res = 0;

        String sql = " INSERT INTO ANSWERBOARD VALUES(BOARDNOSQ.NEXTVAL,?,?,?,?,?,?,SYSDATE)  ";

       
        return res;
    }

    public int delete(int freeSeq) {		//작업필요 delete, 거래 진행 상태 이후로는 delete 불

    	int res =0;
    	return res;
    }
	
//

}
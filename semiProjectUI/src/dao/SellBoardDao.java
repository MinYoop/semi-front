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
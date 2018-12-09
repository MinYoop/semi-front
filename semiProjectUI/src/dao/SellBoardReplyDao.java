package dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.SqlMapConfig;
import dto.SellBoardReply;



public class SellBoardReplyDao extends SqlMapConfig{
	
	private String namespace = "SellBoardReplySql.";
	
	public SellBoardReplyDao() {
		super();
	}
	
	public int CreateReplyBoard(int sellBoardSeq) {			
		//테이블 생성작업. 셀보드에 새 글 인서트시 함께 만들어야 하므로 셀보드서블릿에서 불러야 함.
		
		
		int res = 0;

		String sql= "CREATE TABLE SELL_BOARD_REPLY_TB" + Integer.toString(sellBoardSeq);

		   sql = sql + 
		   		"(" + 
		   		"    SB_REPLY_SEQ    NUMBER            NOT NULL, " + 
		   		"    SB_GROUPNUM     NUMBER            NOT NULL, " + 
		   		"    SB_GROUPSQ      NUMBER            NOT NULL, " + 
		   		"    SB_CONTENTTAB   NUMBER            NOT NULL, " + 
		   		"    SB_CONTENT      VARCHAR2(4000)    NOT NULL, " + 
		   		"    SB_WRITER       VARCHAR2(1000)    NOT NULL, " + 
		   		"    REG_DATE        DATE              NOT NULL, " + 
		   		"    SELL_NUM	     NUMBER            NOT NULL, " + 
		   		"    CONSTRAINT SELL_BOARD_REPLY_TB_PK PRIMARY KEY (SB_REPLY_SEQ)" + 
		   		")";

					

	HashMap<String,String> creatsql = new HashMap<String,String>();

	creatsql.put("sql", sql);

	
		SqlSession session = getSqlSessionFactory().openSession(true);
		res = session.update(namespace + "createReplyBoard", creatsql);
		session.close();
		return res;
		
		
		
	



	}
	
	public List<SellBoardReply> selectAll(){		//작업필요 
		List<SellBoardReply> allboard = new ArrayList<SellBoardReply>();
		return allboard;
	}
	
	public SellBoardReply selectOne(int parentboardno) {	//작업필요 

		return null;
    }
    
	public int updateFreeboard(SellBoardReply article) {	//작업필요 
		int res = 0;

		SqlSession session = getSqlSessionFactory().openSession(true);
		res = session.insert(namespace + "sendMsg", article);
		session.close();
		return res;
		
	}
	
    public int updateRestOrder(int groupno, int groupsq){//답글 insert 뒤 다음 답글들의 순서 정리(+1 아래로 미루기)
        int res =0;
        String sql = "UPDATE ANSWERBOARD SET GROUPSQ = GROUPSQ+1"+
        "WHERE GROUPNO = (SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO=?) "
       + "AND GROUPSQ>(SELECT GROUPSQ FROM ANSWERBOARD WHERE BOARDNO=?) ";
         //아래는 부모글의 그룹번호와 부모글의 그룹순서를 넣는 것
       String sql1 = "UPDATE ANSWERBOARD SET GROUPSQ = GROUPSQ+1 WHERE GROUPNO = ? AND GROUPSQ> ?) ";
       return res;
    }
    
    public int insertArticle(SellBoardReply dto) {		//작업필요 
    	return 0;
    }

    public int delete(int freeSeq) {		//작업필요 
    	int res =0;
    	return res;
    }
	
    


}

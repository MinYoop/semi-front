package dao;

import java.util.ArrayList;
import java.util.List;

import dto.FreeBoard;


public class FreeBoardDao {
	
	public List<FreeBoard> selectAll(){		//작업필요 
		List<FreeBoard> allboard = new ArrayList<FreeBoard>();
		return allboard;
	}
	
	
	 public int insertArticle(FreeBoard dto) {		//작업필요 
	
		
	public FreeBoard selectOne(int parentboardno) {	//작업필요 

		return null;
    }
    
	public int updateFreeboard(FreeBoard article) {	//작업필요 
		return 0;}
	
    public int updateRestOrder(int groupno, int groupsq){//답글 insert 뒤 다음 답글들의 순서 정리(+1 아래로 미루기) 
        
        String sql2 = "UPDATE ANSWERBOARD SET GROUPSQ = GROUPSQ+1"+
        "WHERE GROUPNO = (SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO=?) "
       + "AND GROUPSQ>(SELECT GROUPSQ FROM ANSWERBOARD WHERE BOARDNO=?) ";
         //아래는 부모글의 그룹번호와 부모글의 그룹순서를 넣는 것
       String sql = "UPDATE ANSWERBOARD SET GROUPSQ = GROUPSQ+1 WHERE GROUPNO = ? AND GROUPSQ> ?) ";
    }
    
   
       int res = 0;

        String sql = " INSERT INTO ANSWERBOARD VALUES(BOARDNOSQ.NEXTVAL,?,?,?,?,?,?,SYSDATE)  ";

    }

    public int delete(int freeSeq) {		//작업필요 
    	int res =0;
    	return res;
    }
	

}


	


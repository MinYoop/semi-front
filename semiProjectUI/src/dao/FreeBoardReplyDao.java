package dao;

import java.util.ArrayList;
import java.util.List;

import dto.FreeBoardReply;


public class FreeBoardReplyDao {
	
	public List<FreeBoardReply> selectAll(){		//작업필요 
		List<FreeBoardReply> allboard = new ArrayList<FreeBoardReply>();
		return allboard;
	}

	public FreeBoardReply selectOne(int parentboardno) {	//작업필요 

		return null;
    }
    
	public int updateFreeboard(FreeBoardReply article) {	//작업필요 
		return 0;}
	
    public int updateRestOrder(int groupno, int groupsq){//답글 insert 뒤 다음 답글들의 순서 정리(+1 아래로 미루기)
        
        String sql2 = "UPDATE ANSWERBOARD SET GROUPSQ = GROUPSQ+1"+
        "WHERE GROUPNO = (SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO=?) "
       + "AND GROUPSQ>(SELECT GROUPSQ FROM ANSWERBOARD WHERE BOARDNO=?) ";
         //아래는 부모글의 그룹번호와 부모글의 그룹순서를 넣는 것
       String sql = "UPDATE ANSWERBOARD SET GROUPSQ = GROUPSQ+1 WHERE GROUPNO = ? AND GROUPSQ> ?) ";
    }
    
    public int insertArticle(FreeBoardReply dto) {		//작업필요 
       int res = 0;

        String sql = " INSERT INTO ANSWERBOARD VALUES(BOARDNOSQ.NEXTVAL,?,?,?,?,?,?,SYSDATE)  ";

        try{
            pstm = con.prepareStatement(sql);
        pstm.setInt(1, dto.getGroupno());
        pstm.setInt(2, dto.getGroupsq()+1);
        pstm.setInt(3, dto.getTitletab()+1);
        pstm.setString(4, dto.getTitle());
        pstm.setString(5, dto.getContent());
        pstm.setString(6, dto.getWriter());
        System.out.println("03.query ready : " + sql);

        res = pstm.executeUpdate();

        if(res>0){
            commit(con);
        }
    } catch (SQLException e) {
		System.out.println("3/4단계 에러");
		e.printStackTrace();
	} finally {
		close(pstm);
		close(con);
		System.out.println("05.db 종료\n");
	}
       
        return res;
    }

    public int delete(int freeSeq) {		//작업필요 
    	int res =0;
    	return res;
    }
	

	

}


	


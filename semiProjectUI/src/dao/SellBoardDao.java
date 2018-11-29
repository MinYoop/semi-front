package dao;

import java.util.ArrayList;
import java.util.List;

import dto.SellBoard;

public class SellBoardDao {
	
	
	public List<SellBoard> selectAll(){		//작업필요 
		List<SellBoard> allboard = new ArrayList<SellBoard>();
		return allboard;
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

    public int delete(int freeSeq) {		//작업필요 delete, 거래 진행 상태 이후로는 delete 불

    	int res =0;
    	return res;
    }
	
//

}

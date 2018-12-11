package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.SqlMapConfig;
import dto.SellBoard; 

public class FavAndCompareDao extends SqlMapConfig {

	private String namespace = "FavAndCompare.";

	public FavAndCompareDao() {
		super();
	}

	public List<SellBoard> viewFav(List<Integer> favs){	
		
		List<SellBoard> list = new ArrayList<SellBoard>();
		
		SqlSession session = null;
		HashMap<String,Object> favinfo = new HashMap<String,Object>();
		favinfo.put("boardName", "SELL_BOARD_TB");
		favinfo.put("column","SELL_SEQ");
		favinfo.put("option", favs);
		
		session = getSqlSessionFactory().openSession(true); // openSession(true) : autoCommit
		list = session.selectList(namespace + "getList",favinfo );

		session.close();

		return list;
		
	}
	
}

	
	


package dao;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

import com.goods.dto.GoodsVO;


public class GoodsDAO {
	private GoodsDAO() {
		
	}

	private static GoodsDAO instance = new GoodsDAO();
	   
	public static GoodsDAO getInstance() {
		return instance;
	}
	
	// c Read u d
	
	public List<GoodsVO> selectAllGoods() {
		// 최근 등록한 상품 먼저 출력하기 
		
		String sql = "select * from goods order by code des";
		List<GoodsVO> list = new ArrayList<GoodsVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
	    	conn= DBManager.getConnection();
	    	pstmt = conn.prepareStatement(sql);
	    	rs = pstmt.executeQuery();
	    	while (rs.next()) {    //이동은 행(로우) 단위로
	    		GoodsVO gVo = new GoodsVO();
	    		gVo.setCode(rs.getInt("code"));
	    		gVo.setName(rs.getString("name"));
	    		gVo.setPrice(rs.getInt("price"));
	    		gVo.setPictureUrl(rs.getString("pictureUrl"));
	    		gVo.setDescription(rs.getString("description"));
	    		list.add(gVo);
	    		
	    	}// while문 
	    } catch(Exception e) {
	    	e.printStackTrace();
	    }finally {
	    	DBManager.close(conn, pstmt,rs);
	    }
	    return list;
	    
	}  //selectAllGoods() {
   //GoodsDAO {

 public void insertGoods(GoodsVO gVo) {
	 String sql ="insert into goods values(goods_seq.nextval,?,?,?,?)";
	 Connection conn= null;
	 PreparedStatement pstmt = null;
	 try {
		 conn=DBManager.getConnection();
		 pstmt= conn.prepareStatement(sql);
		 pstmt.setString(1, gVo.getName());
		 pstmt.setInt(2, gVo.getPrice());
		 pstmt.setString(3, gVo.getPictureUrl());
		 pstmt.setString(4, gVo.getDescription());
		 pstmt.executeUpdate();
	 } catch(Exception e) {
		 e.printStackTrace();
	 } finally {
		 DBManager.close(conn, pstmt);
	 }
 } 
 
 public GoodsVO selectGoodsByCode(String code) {
	 String sql="select * from goods where code=?";
	 GoodsVO gVo = null;
	 try {
		 Connection conn= null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		try {
			conn= DBManager.getConnection();
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				gVo = new GoodsVO();
				gVo.setCode(rs.getInt("code"));
				gVo.setName(rs.getString("name"));
				gVo.setPrice(rs.getInt("price"));
				gVo.setPictureUrl(rs.getString("pictureUrl"));
				gVo.setDescription(rs.getString("description"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt,rs);
		}
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	 return gVo;
 }
 
 // 클래스에 상품 정보 수정을 위한 메소드
 
 public void updateGoods(GoodsVO gVo) {
	 String sql="update goods set name=?, price=?, pictureurl=? , description=? , where code=?";
	 Connection conn=null;
	 PreparedStatement pstmt = null;
	 try {
		 conn=DBManager.getConnection();
		 pstmt = conn.prepareStatement(sql);
		 pstmt.setString(1, gVo.getName());
		 pstmt.setInt(2, gVo.getPrice());
		 pstmt.setString(3, gVo.getPictureUrl());
		 pstmt.setString(4, gVo.getDescription());
		 pstmt.setInt(5, gVo.getCode());
		 pstmt.executeUpdate();
		 
	 } catch(Exception e) {
		 e.printStackTrace();
	 }finally {
		 DBManager.close(conn, pstmt);
	 }
 }
 
 // 클래스에 상품 삭제를 위한 메소드 추가하기
 
 public void deleteGoods(String code) {
	 String sql="delete goods where code=?";
	 Connection conn= null;
	 PreparedStatement pstmt = null;
	 try {
		 conn=DBManager.getConnection();
		 pstmt=conn.prepareStatement(sql);
		 pstmt.setString(1, code);
		 pstmt.executeUpdate();
	 }catch (Exception e) {
		 e.printStackTrace();
	 } finally {
		 DBManager.close(conn, pstmt);
	 }
 }
 }
	
	


package dao;

import dto.Deal;

public class DealDao {

	public int UpdateBuyerDealNum(int sellSeq) {
		return 0;
		//구매자의 구매횟수 +1 
	}
	
	public int UpdateSellerDealNum(int sellSeq) {
		return sellSeq;
		//판매자의 판매횟수 +1 구매횟수와 동시에 올리면 판매 평가 없이 횟수가 올라가 평균점이 낮아지므로 따로 메소드 생
	}
	
	public String UpdateScore(int sellSeq) {
		//구매자,판매의 평균 점수 다시 계산하여 update
		return "";
	}
	
	public int insertDeal(int sellSeq) {
		//판매글의 status가 거래중으로 바뀔 때 Deal 튜플 생성 + 나머지 컬럼들과 함께 거래시작일시 등록됨 
		return 0;
	}
	
	public int updateComplete(int sellSeq) {
		return 0;
	}
	
	public Deal selectAllBought(int usrSeq) {
		return null;
	}
	
	public Deal selectAllSold(int usrSeq) {
		return null;
	}
	
	
}

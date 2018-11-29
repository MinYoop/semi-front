package dto;

import java.util.Date;

public class SellBoardForDistance {

    // 매물번호 
    private int sellSeq;

    // 판매자 
    private int seller;

    // 매매위치위도 
    private String tradeLat;

    // 매매위치경도 
    private String tradeLon;

    // 판매글 
    private String sellContent;

    // 거래상태 
    private String status;

    // 제목 
    private String title;

    // 등록시간 
    private Date regDate;
    
    //사용자와의 거리
    private String distance; //거리 메소드 리턴값은 더블로 받음.
    

    public int getSellSeq() {
        return sellSeq;
    }

    public void setSellSeq(int sellSeq) {
        this.sellSeq = sellSeq;
    }

    public int getSeller() {
        return seller;
    }

    public void setSeller(int seller) {
        this.seller = seller;
    }

    public String getTradeLat() {
        return tradeLat;
    }

    public void setTradeLat(String tradeLat) {
        this.tradeLat = tradeLat;
    }

    public String getTradeLon() {
        return tradeLon;
    }

    public void setTradeLon(String tradeLon) {
        this.tradeLon = tradeLon;
    }

    public String getSellContent() {
        return sellContent;
    }

    public void setSellContent(String sellContent) {
        this.sellContent = sellContent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}
    
    
    
    
}
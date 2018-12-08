package dto;


import java.util.Date;

public class SellBoard {

    // 매물번호 
    private int sellSeq;

    // 판매자 
    private String seller;

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

    // 카테고리 
    private String category;

    // 태그 
    private String tag;
    
    private double distance;

    public int getSellSeq() {
        return sellSeq;
    }

    public void setSellSeq(int sellSeq) {
        this.sellSeq = sellSeq;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
    
    
}
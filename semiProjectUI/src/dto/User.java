package dto;

//회원가입정보 
public class User {

 // 유저닉네임 
 private String nickName;

 // 이메일 
 private String email;

 // 상위주소 
 private String address1;

 // 하위주소 
 private String address2;
 private Integer zipCode;

 private String sns;

  private String snsId;

// 집위도 
 private String homeLat;

 // 집경도 
 private String homeLon;

 // 구매평가 
 private String fromBuyer;

 // 판매평가 
 private String fromSeller;

 // 구매횟수 
 private int buyCnt;

 // 판매횟수 
 private int sellCnt;
 
 


public String getNickName() {
     return nickName;
 }

 public void setNickName(String nickName) {
     this.nickName = nickName;
 }

 public String getEmail() {
     return email;
 }

 public void setEmail(String email) {
     this.email = email;
 }

 public String getAddress1() {
     return address1;
 }

 public void setAddress1(String address1) {
     this.address1 = address1;
 }

 public String getAddress2() {
     return address2;
 }

 public void setAddress2(String address2) {
     this.address2 = address2;
 }
 public Integer getZipCode() {
	 return zipCode;
 }
 
 public void setZipCode(Integer zipCode) {
	 this.zipCode = zipCode;
 }


 
 public String getSns() {
		return sns;
	}

 public void setSns(String sns) {
		this.sns = sns;
	}

 public String getSnsId() {
     return snsId;
 }

 public void setSnsId(String snsId) {
     this.snsId = snsId;
 }
 
 public String getHomeLat() {
     return homeLat;
 }

 public void setHomeLat(String homeLat) {
     this.homeLat = homeLat;
 }

 public String getHomeLon() {
     return homeLon;
 }

 public void setHomeLon(String homeLon) {
     this.homeLon = homeLon;
 }

 public String getFromBuyer() {
     return fromBuyer;
 }

 public void setFromBuyer(String fromBuyer) {
     this.fromBuyer = fromBuyer;
 }

 public String getFromSeller() {
     return fromSeller;
 }

 public void setFromSeller(String fromSeller) {
     this.fromSeller = fromSeller;
 }

 public int getBuyCnt() {
     return buyCnt;
 }

 public void setBuyCnt(int buyCnt) {
     this.buyCnt = buyCnt;
 }

 public int getSellCnt() {
     return sellCnt;
 }

 public void setSellCnt(int sellCnt) {
     this.sellCnt = sellCnt;
 }

public User() {
	super();
}

public User(String nickName, String email, String address1,
		String address2, Integer zipCode,  String sns, 
		String snsId,String homeLat, String homeLon) {
	super();
	this.nickName = nickName;
	this.email = email;
	this.address1 = address1;
	this.address2 = address2;
	this.zipCode = zipCode;
	this.sns=sns;
	this.snsId = snsId;
	this.homeLat = homeLat;
	this.homeLon = homeLon;
}

public User(String nickName, String email, String address1, String address2, Integer zipCode, String sns, String snsId,
		String homeLat, String homeLon, String fromBuyer, String fromSeller, int buyCnt, int sellCnt) {
	super();
	this.nickName = nickName;
	this.email = email;
	this.address1 = address1;
	this.address2 = address2;
	this.zipCode = zipCode;
	this.sns = sns;
	this.snsId = snsId;
	this.homeLat = homeLat;
	this.homeLon = homeLon;
	this.fromBuyer = fromBuyer;
	this.fromSeller = fromSeller;
	this.buyCnt = buyCnt;
	this.sellCnt = sellCnt;
}


 
}
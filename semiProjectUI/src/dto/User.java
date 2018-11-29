package dto;

//회원가입정보 
public class User {

	// 유저번호
	private int usrSeq;

	// 유저닉네임
	private String nickname;

	// 이메일
	private String email;

	// 상위주소
	private String address1;

	// 하위주소
	private String address2;

	// 유저의 sns id
	private String snsId;

	// 집위도 
	private String homeLat;

	// 집경도
	private String homeLon;
	
	private int zipCode;

	public int getUsrSeq() {
		return usrSeq;
	}

	public void setUsrSeq(int usrSeq) {
		this.usrSeq = usrSeq;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	// User 모델 복사
	public void CopyData(User param) {
		this.usrSeq = param.getUsrSeq();
		this.email = param.getEmail();
		this.address1 = param.getAddress1();
		this.address2 = param.getAddress2();
		this.snsId = param.getSnsId();
		this.homeLat = param.getHomeLat();
		this.homeLon = param.getHomeLon();
	}
}
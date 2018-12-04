package dto;

//회원가입정보 
public class User {

	// 유저번호
	private Integer usrSeq;

	// 유저닉네임
	private String nickName;

	// 이메일
	private String email;

	// 유저의 sns
	private String sns;

	// 유저의 sns id
	private String snsId;

	// 상위주소
	private String address1;

	// 하위주소
	private String address2;

	// 집위도
	private String homeLat;

	// 집경도
	private String homeLon;

	//우편번호 
	private Integer zipCode;

	public Integer getUsrSeq() {
		return usrSeq;
	}

	public void setUsrSeq(Integer usrSeq) {
		this.usrSeq = usrSeq;
	}

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

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public User(Integer usrSeq, String nickName, String email, String sns, String snsId, String address1,
			String address2, String homeLat, String homeLon, Integer zipCode) {
		super();
		this.usrSeq = usrSeq;
		this.nickName = nickName;
		this.email = email;
		this.sns = sns;
		this.snsId = snsId;
		this.address1 = address1;
		this.address2 = address2;
		this.homeLat = homeLat;
		this.homeLon = homeLon;
		this.zipCode = zipCode;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	
}
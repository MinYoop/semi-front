package dto;

//회원가입정보 
public class User {

 // 유저번호 
 private int usrSeq;

 // 이메일 
 private String email;

 // 상위주소 
 private String address1;

 // 하위주소 
 private String address2;

 // 유저의 sns id 
 private String snsId;

 // 휴대폰 번호 
 private String phone;

 // 유저비밀번호 
 private String password;

 // 집위도 
 private int homeLat;

 // 집경도 
 private int homeLon;

 // 세션ID 
 private String sessionId;

 // 온라인여부 
 private String online;

 public int getUsrSeq() {
     return usrSeq;
 }

 public void setUsrSeq(int usrSeq) {
     this.usrSeq = usrSeq;
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

 public String getPhone() {
     return phone;
 }

 public void setPhone(String phone) {
     this.phone = phone;
 }

 public String getPassword() {
     return password;
 }

 public void setPassword(String password) {
     this.password = password;
 }

 public int getHomeLat() {
     return homeLat;
 }

 public void setHomeLat(int homeLat) {
     this.homeLat = homeLat;
 }

 public int getHomeLon() {
     return homeLon;
 }

 public void setHomeLon(int homeLon) {
     this.homeLon = homeLon;
 }

 public String getSessionId() {
     return sessionId;
 }

 public void setSessionId(String sessionId) {
     this.sessionId = sessionId;
 }

 public String getOnline() {
     return online;
 }

 public void setOnline(String online) {
     this.online = online;
 }

 // UserTb 모델 복사
 public void CopyData(User param)
 {
     this.usrSeq = param.getUsrSeq();
     this.email = param.getEmail();
     this.address1 = param.getAddress1();
     this.address2 = param.getAddress2();
     this.snsId = param.getSnsId();
     this.phone = param.getPhone();
     this.password = param.getPassword();
     this.homeLat = param.getHomeLat();
     this.homeLon = param.getHomeLon();
     this.sessionId = param.getSessionId();
     this.online = param.getOnline();
 }
}
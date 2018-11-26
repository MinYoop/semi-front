package dto;

//주소테이블 
public class UsrLocation {

 // 유저번호 
 private int usrSeq;

 // 거래위도 
 private int dealLat;

 // 거래경도 
 private int dealLon;

 // 위치이름 
 private String locationName;

 public int getUsrSeq() {
     return usrSeq;
 }

 public void setUsrSeq(int usrSeq) {
     this.usrSeq = usrSeq;
 }

 public int getDealLat() {
     return dealLat;
 }

 public void setDealLat(int dealLat) {
     this.dealLat = dealLat;
 }

 public int getDealLon() {
     return dealLon;
 }

 public void setDealLon(int dealLon) {
     this.dealLon = dealLon;
 }

 public String getLocationName() {
     return locationName;
 }

 public void setLocationName(String locationName) {
     this.locationName = locationName;
 }

 // UsrLocationTb 모델 복사
 public void CopyData(UsrLocation param)
 {
     this.usrSeq = param.getUsrSeq();
     this.dealLat = param.getDealLat();
     this.dealLon = param.getDealLon();
     this.locationName = param.getLocationName();
 }
}
package dto;

//주소테이블 
public class UsrLocation {

 // 유저번호 
 private Integer usrSeq;

 // 거래위도 
 private String dealLat;

 // 거래경도 
 private String dealLon;

 // 위치이름 
 private String locationName;

 private String locSeq;

 public Integer getUsrSeq() {
     return usrSeq;
 }

 public void setUsrSeq(Integer usrSeq) {
     this.usrSeq = usrSeq;
 }

 public String getDealLat() {
     return dealLat;
 }

 public void setDealLat(String dealLat) {
     this.dealLat = dealLat;
 }

 public String getDealLon() {
     return dealLon;
 }

 public void setDealLon(String dealLon) {
     this.dealLon = dealLon;
 }

 public String getLocationName() {
     return locationName;
 }

 public void setLocationName(String locationName) {
     this.locationName = locationName;
 }


 public String getLocSeq() {
    return locSeq;
}

public void setLocSeq(String locSeq) {
    this.locSeq = locSeq;
}

 // UsrLocationTb 모델 복사
 public void CopyData(UsrLocation param)
 {
     this.usrSeq = param.getUsrSeq();
     this.dealLat = param.getDealLat();
     this.dealLon = param.getDealLon();
     this.locationName = param.getLocationName();
     this.locSeq = param.getLocSeq();
 }
}
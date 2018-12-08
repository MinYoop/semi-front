package dto;

import java.util.Date;

//거래테이블 
public class Deal {

 // 거래번호 
 private Integer dealSeq;

 // 매물번호 
 private Integer selnum;

 // 판매자 
 private String seller;

 // 구매자 
 private String buyer;

 // 거래시작일시 
 private Date startDate;

 // 거래종료일시 
 private Date endDate;
 
 

 public Integer getDealSeq() {
     return dealSeq;
 }

 public void setDealSeq(Integer dealSeq) {
     this.dealSeq = dealSeq;
 }

 public Integer getSelnum() {
     return selnum;
 }

 public void setSelnum(Integer selnum) {
     this.selnum = selnum;
 }

 public String getSeller() {
     return seller;
 }

 public void setSeller(String seller) {
     this.seller = seller;
 }

 public String getBuyer() {
     return buyer;
 }

 public void setBuyer(String buyer) {
     this.buyer = buyer;
 }

 public Date getStartDate() {
     return startDate;
 }

 public void setStartDate(Date startDate) {
     this.startDate = startDate;
 }

 public Date getEndDate() {
     return endDate;
 }

 public void setEndDate(Date endDate) {
     this.endDate = endDate;
 }

 // DealTb 모델 복사
 
}
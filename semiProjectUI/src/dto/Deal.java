package dto;

import java.util.Date;

//거래테이블 
public class Deal {

 // 거래번호 
 private int dealSeq;

 // 매물번호 
 private int selnum;

 // 판매자 
 private int seller;

 // 구매자 
 private int buyer;

 // 거래시작일시 
 private Date startDate;

 // 거래종료일시 
 private Date endDate;
 
 

 public int getDealSeq() {
     return dealSeq;
 }

 public void setDealSeq(int dealSeq) {
     this.dealSeq = dealSeq;
 }

 public int getSelnum() {
     return selnum;
 }

 public void setSelnum(int selnum) {
     this.selnum = selnum;
 }

 public int getSeller() {
     return seller;
 }

 public void setSeller(int seller) {
     this.seller = seller;
 }

 public int getBuyer() {
     return buyer;
 }

 public void setBuyer(int buyer) {
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
 public void CopyData(Deal param)
 {
     this.dealSeq = param.getDealSeq();
     this.selnum = param.getSelnum();
     this.seller = param.getSeller();
     this.buyer = param.getBuyer();
     this.startDate = param.getStartDate();
     this.endDate = param.getEndDate();
 }
}
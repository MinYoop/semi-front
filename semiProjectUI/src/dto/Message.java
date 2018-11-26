package dto;

import java.util.Date;

//쪽지 
public class Message {

 // 글번호 
 private int msgSeq;

 // 내용 
 private String msgContent;

 // 보내는사람 
 private int sender;

 // 받는사람 
 private int receiver;

 // 보내는사람조회여부 
 private int senderChk;

 // 받는사람조회여부 
 private int recieverChk;

 // 보내는사람삭제여부 
 private int senderDelChk;

 // 받는사람삭제여부 
 private int receiverDelChk;

 // 작성날짜시간 
 private Date sendDate;

 public int getMsgSeq() {
     return msgSeq;
 }

 public void setMsgSeq(int msgSeq) {
     this.msgSeq = msgSeq;
 }

 public String getMsgContent() {
     return msgContent;
 }

 public void setMsgContent(String msgContent) {
     this.msgContent = msgContent;
 }

 public int getSender() {
     return sender;
 }

 public void setSender(int sender) {
     this.sender = sender;
 }

 public int getReceiver() {
     return receiver;
 }

 public void setReceiver(int receiver) {
     this.receiver = receiver;
 }

 public int getSenderChk() {
     return senderChk;
 }

 public void setSenderChk(int senderChk) {
     this.senderChk = senderChk;
 }

 public int getRecieverChk() {
     return recieverChk;
 }

 public void setRecieverChk(int recieverChk) {
     this.recieverChk = recieverChk;
 }

 public int getSenderDelChk() {
     return senderDelChk;
 }

 public void setSenderDelChk(int senderDelChk) {
     this.senderDelChk = senderDelChk;
 }

 public int getReceiverDelChk() {
     return receiverDelChk;
 }

 public void setReceiverDelChk(int receiverDelChk) {
     this.receiverDelChk = receiverDelChk;
 }

 public Date getSendDate() {
     return sendDate;
 }

 public void setSendDate(Date sendDate) {
     this.sendDate = sendDate;
 }

 // MessageTb 모델 복사
 public void CopyData(Message param)
 {
     this.msgSeq = param.getMsgSeq();
     this.msgContent = param.getMsgContent();
     this.sender = param.getSender();
     this.receiver = param.getReceiver();
     this.senderChk = param.getSenderChk();
     this.recieverChk = param.getRecieverChk();
     this.senderDelChk = param.getSenderDelChk();
     this.receiverDelChk = param.getReceiverDelChk();
     this.sendDate = param.getSendDate();
 }
}
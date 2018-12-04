package dto;

import java.util.Date;

//쪽지 
public class Message {

 // 글번호 
 private Integer msgSeq;

 // 내용 
 private String msgContent;

 // 보내는사람 
 private Integer sender;

 // 받는사람 
 private Integer receiver;

 // 받는사람조회여부 
 private Integer recieverChk;

 // 보내는사람삭제여부 
 private Integer senderDelChk;

 // 받는사람삭제여부 
 private Integer receiverDelChk;

 // 작성날짜시간 
 private Date sendDate;

 public Integer getMsgSeq() {
     return msgSeq;
 }

 public void setMsgSeq(Integer msgSeq) {
     this.msgSeq = msgSeq;
 }

 public String getMsgContent() {
     return msgContent;
 }

 public void setMsgContent(String msgContent) {
     this.msgContent = msgContent;
 }

 public Integer getSender() {
     return sender;
 }

 public void setSender(Integer sender) {
     this.sender = sender;
 }

 public Integer getReceiver() {
     return receiver;
 }

 public void setReceiver(Integer receiver) {
     this.receiver = receiver;
 }

 public Integer getRecieverChk() {
     return recieverChk;
 }

 public void setRecieverChk(Integer recieverChk) {
     this.recieverChk = recieverChk;
 }

 public Integer getSenderDelChk() {
     return senderDelChk;
 }

 public void setSenderDelChk(Integer senderDelChk) {
     this.senderDelChk = senderDelChk;
 }

 public Integer getReceiverDelChk() {
     return receiverDelChk;
 }

 public void setReceiverDelChk(Integer receiverDelChk) {
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
     this.recieverChk = param.getRecieverChk();
     this.senderDelChk = param.getSenderDelChk();
     this.receiverDelChk = param.getReceiverDelChk();
     this.sendDate = param.getSendDate();
 }
}
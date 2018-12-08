package dto;

import java.util.Date;

//쪽지 
public class Message {

 // 글번호 
 private Integer msgSeq;
 
 private String msgTitle;

// 내용 
 private String msgContent;

 // 보내는사람 
 private String sender;

 // 받는사람 
 private String receiver;

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

 
 public String getMsgTitle() {
		return msgTitle;
	}

	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}
	
	
 public String getMsgContent() {
     return msgContent;
 }

 public void setMsgContent(String msgContent) {
     this.msgContent = msgContent;
 }

 public String getSender() {
     return sender;
 }

 public void setSender(String sender) {
     this.sender = sender;
 }

 public String getReceiver() {
     return receiver;
 }

 public void setReceiver(String receiver) {
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

 
 


public Message() {
	super();
}

public Message(String msgTitle, String msgContent, String sender, String receiver) {
	super();
	this.msgTitle = msgTitle;
	this.msgContent = msgContent;
	this.sender = sender;
	this.receiver = receiver;
	
}
 
 
 

}
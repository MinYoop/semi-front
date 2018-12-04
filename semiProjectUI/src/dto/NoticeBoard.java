package dto;

import java.util.Date;

//공지게시판 
public class NoticeBoard {

 // 글번호 
 private Integer noticeSeq;

 // 작성자 
 private String adminId;

 // 제목 
 private String title;

 // 내용 
 private String content;

 // 조회수 
 private Integer saw;

 // 등록일 
 private Date regDate;

 public Integer getNoticeSeq() {
     return noticeSeq;
 }

 public void setNoticeSeq(Integer noticeSeq) {
     this.noticeSeq = noticeSeq;
 }

 public String getAdminId() {
     return adminId;
 }

 public void setAdminId(String adminId) {
     this.adminId = adminId;
 }

 public String getTitle() {
     return title;
 }

 public void setTitle(String title) {
     this.title = title;
 }

 public String getContent() {
     return content;
 }

 public void setContent(String content) {
     this.content = content;
 }

 public Integer getSaw() {
     return saw;
 }

 public void setSaw(Integer saw) {
     this.saw = saw;
 }

 public Date getRegDate() {
     return regDate;
 }

 public void setRegDate(Date regDate) {
     this.regDate = regDate;
 }

 // NoticeBoardTb 모델 복사
 public void CopyData(NoticeBoard param)
 {
     this.noticeSeq = param.getNoticeSeq();
     this.adminId = param.getAdminId();
     this.title = param.getTitle();
     this.content = param.getContent();
     this.saw = param.getSaw();
     this.regDate = param.getRegDate();
 }
}
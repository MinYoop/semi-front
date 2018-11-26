package dto;

import java.util.Date;

//자유게시판 
public class FreeBoard {

 // 자유글번호 
 private int freeSeq;

 // 제목 
 private String title;

 // 내용 
 private String content;

 // 조회수 
 private int saw;

 // 추천 
 private int recommend;

 // 글그룹번호 
 private int groupNum;

 // 글그룹별순서 
 private int groupOrderNum;

 // 들여쓰기단계 
 private int titleTab;

 // 게시자 
 private int writer;

 // 등록일 
 private Date regDate;

 public int getFreeSeq() {
     return freeSeq;
 }

 public void setFreeSeq(int freeSeq) {
     this.freeSeq = freeSeq;
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

 public int getSaw() {
     return saw;
 }

 public void setSaw(int saw) {
     this.saw = saw;
 }

 public int getRecommend() {
     return recommend;
 }

 public void setRecommend(int recommend) {
     this.recommend = recommend;
 }

 public int getGroupNum() {
     return groupNum;
 }

 public void setGroupNum(int groupNum) {
     this.groupNum = groupNum;
 }

 public int getGroupOrderNum() {
     return groupOrderNum;
 }

 public void setGroupOrderNum(int groupOrderNum) {
     this.groupOrderNum = groupOrderNum;
 }

 public int getTitleTab() {
     return titleTab;
 }

 public void setTitleTab(int titleTab) {
     this.titleTab = titleTab;
 }

 public int getWriter() {
     return writer;
 }

 public void setWriter(int writer) {
     this.writer = writer;
 }

 public Date getRegDate() {
     return regDate;
 }

 public void setRegDate(Date regDate) {
     this.regDate = regDate;
 }

 // FreeboardTb 모델 복사
 public void CopyData(FreeBoard param)
 {
     this.freeSeq = param.getFreeSeq();
     this.title = param.getTitle();
     this.content = param.getContent();
     this.saw = param.getSaw();
     this.recommend = param.getRecommend();
     this.groupNum = param.getGroupNum();
     this.groupOrderNum = param.getGroupOrderNum();
     this.titleTab = param.getTitleTab();
     this.writer = param.getWriter();
     this.regDate = param.getRegDate();
 }
}
package dto;

import java.util.Date;

//자유게시판 
public class FreeBoard {

 // 자유글번호 
 private Integer freeSeq;

 // 제목 
 private String title;

 // 내용 
 private String content;

 // 조회수 
 private Integer saw;

 // 추천 
 private Integer recommend;

 // 글그룹번호 
 private Integer groupNum;

 // 글그룹별순서 
 private Integer groupOrderNum;

 // 들여쓰기단계 
 private Integer titleTab;

 // 게시자 
 private String writer;

 // 등록일 
 private Date regDate;

 public Integer getFreeSeq() {
     return freeSeq;
 }

 public void setFreeSeq(Integer freeSeq) {
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

 public Integer getSaw() {
     return saw;
 }

 public void setSaw(Integer saw) {
     this.saw = saw;
 }

 public Integer getRecommend() {
     return recommend;
 }

 public void setRecommend(Integer recommend) {
     this.recommend = recommend;
 }

 public Integer getGroupNum() {
     return groupNum;
 }

 public void setGroupNum(Integer groupNum) {
     this.groupNum = groupNum;
 }

 public Integer getGroupOrderNum() {
     return groupOrderNum;
 }

 public void setGroupOrderNum(Integer groupOrderNum) {
     this.groupOrderNum = groupOrderNum;
 }

 public Integer getTitleTab() {
     return titleTab;
 }

 public void setTitleTab(Integer titleTab) {
     this.titleTab = titleTab;
 }

 public String getWriter() {
     return writer;
 }

 public void setWriter(String writer) {
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
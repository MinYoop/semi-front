package dto;

import java.util.Date;

public class FreeBoardReply {

    // 자게댓글번호 
    private Integer fbReplySeq;

    // 그룹 
    private Integer fbGroupNum;

    // 그룹시퀀스 
    private Integer fbGroupSeq;

    // 칸띄움 
    private Integer fbTitleTab;

    // 댓글내용 
    private String fbContent;

    // 글쓴이 
    private String fbWriter;

    // 입력일 
    private Date regDate;

    // 자유글번호 
    private Integer freeSeq;

    public Integer getFbReplySeq() {
        return fbReplySeq;
    }

    public void setFbReplySeq(Integer fbReplySeq) {
        this.fbReplySeq = fbReplySeq;
    }

    public Integer getFbGroupNum() {
        return fbGroupNum;
    }

    public void setFbGroupNum(Integer fbGroupNum) {
        this.fbGroupNum = fbGroupNum;
    }

    public Integer getFbGroupSeq() {
        return fbGroupSeq;
    }

    public void setFbGroupSeq(Integer fbGroupSeq) {
        this.fbGroupSeq = fbGroupSeq;
    }

    public Integer getFbTitleTab() {
        return fbTitleTab;
    }

    public void setFbTitleTab(Integer fbTitleTab) {
        this.fbTitleTab = fbTitleTab;
    }

    public String getFbContent() {
        return fbContent;
    }

    public void setFbContent(String fbContent) {
        this.fbContent = fbContent;
    }

    public String getFbWriter() {
        return fbWriter;
    }

    public void setFbWriter(String fbWriter) {
        this.fbWriter = fbWriter;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Integer getFreeSeq() {
        return freeSeq;
    }

    public void setFreeSeq(Integer freeSeq) {
        this.freeSeq = freeSeq;
    }

    // FreeBoardReplyTb 모델 복사
    public void CopyData(FreeBoardReply param)
    {
        this.fbReplySeq = param.getFbReplySeq();
        this.fbGroupNum = param.getFbGroupNum();
        this.fbGroupSeq = param.getFbGroupSeq();
        this.fbTitleTab = param.getFbTitleTab();
        this.fbContent = param.getFbContent();
        this.fbWriter = param.getFbWriter();
        this.regDate = param.getRegDate();
        this.freeSeq = param.getFreeSeq();
    }
}
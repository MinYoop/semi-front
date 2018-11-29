package dto;

import java.util.Date;

public class FreeBoardReply {

    // 자게댓글번호 
    private int fbReplySeq;

    // 그룹 
    private int fbGroupNum;

    // 그룹시퀀스 
    private int fbGroupSeq;

    // 칸띄움 
    private int fbTitleTab;

    // 댓글내용 
    private String fbContent;

    // 글쓴이 
    private String fbWriter;

    // 입력일 
    private Date regDate;

    // 자유글번호 
    private int freeSeq;

    public int getFbReplySeq() {
        return fbReplySeq;
    }

    public void setFbReplySeq(int fbReplySeq) {
        this.fbReplySeq = fbReplySeq;
    }

    public int getFbGroupNum() {
        return fbGroupNum;
    }

    public void setFbGroupNum(int fbGroupNum) {
        this.fbGroupNum = fbGroupNum;
    }

    public int getFbGroupSeq() {
        return fbGroupSeq;
    }

    public void setFbGroupSeq(int fbGroupSeq) {
        this.fbGroupSeq = fbGroupSeq;
    }

    public int getFbTitleTab() {
        return fbTitleTab;
    }

    public void setFbTitleTab(int fbTitleTab) {
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

    public int getFreeSeq() {
        return freeSeq;
    }

    public void setFreeSeq(int freeSeq) {
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
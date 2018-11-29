package dto;

import java.util.Date;

public class SellBoardReply {

    // 판매글 댓글번호 
    private int sbReplySeq;

    // 그룹넘버 
    private int sbGroupnum;

    // 그룹시퀀스 
    private int sbGroupsq;

    // 칸띄움 
    private int sbTitletab;

    // 댓글내용 
    private String sbContent;

    // 글쓴이 
    private String sbWriter;

    // 입력일 
    private Date regDate;

    // 매물번호 
    private int sellNum;

    public int getSbReplySeq() {
        return sbReplySeq;
    }

    public void setSbReplySeq(int sbReplySeq) {
        this.sbReplySeq = sbReplySeq;
    }

    public int getSbGroupnum() {
        return sbGroupnum;
    }

    public void setSbGroupnum(int sbGroupnum) {
        this.sbGroupnum = sbGroupnum;
    }

    public int getSbGroupsq() {
        return sbGroupsq;
    }

    public void setSbGroupsq(int sbGroupsq) {
        this.sbGroupsq = sbGroupsq;
    }

    public int getSbTitletab() {
        return sbTitletab;
    }

    public void setSbTitletab(int sbTitletab) {
        this.sbTitletab = sbTitletab;
    }

    public String getSbContent() {
        return sbContent;
    }

    public void setSbContent(String sbContent) {
        this.sbContent = sbContent;
    }

    public String getSbWriter() {
        return sbWriter;
    }

    public void setSbWriter(String sbWriter) {
        this.sbWriter = sbWriter;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public int getSellNum() {
        return sellNum;
    }

    public void setSellNum(int sellNum) {
        this.sellNum = sellNum;
    }

    // SellBoardReplyTb 모델 복사
    public void CopyData(SellBoardReply param)
    {
        this.sbReplySeq = param.getSbReplySeq();
        this.sbGroupnum = param.getSbGroupnum();
        this.sbGroupsq = param.getSbGroupsq();
        this.sbTitletab = param.getSbTitletab();
        this.sbContent = param.getSbContent();
        this.sbWriter = param.getSbWriter();
        this.regDate = param.getRegDate();
        this.sellNum = param.getSellNum();
    }
}
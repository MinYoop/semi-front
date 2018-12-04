package dto;

import java.util.Date;

public class SellBoardReply {

    // 판매글 댓글번호 
    private Integer sbReplySeq;

    // 그룹넘버 
    private Integer sbGroupnum;

    // 그룹시퀀스 
    private Integer sbGroupsq;

    // 칸띄움 
    private Integer sbTitletab;

    // 댓글내용 
    private String sbContent;

    // 글쓴이 
    private String sbWriter;

    // 입력일 
    private Date regDate;

    // 매물번호 
    private Integer sellNum;

    public Integer getSbReplySeq() {
        return sbReplySeq;
    }

    public void setSbReplySeq(Integer sbReplySeq) {
        this.sbReplySeq = sbReplySeq;
    }

    public Integer getSbGroupnum() {
        return sbGroupnum;
    }

    public void setSbGroupnum(Integer sbGroupnum) {
        this.sbGroupnum = sbGroupnum;
    }

    public Integer getSbGroupsq() {
        return sbGroupsq;
    }

    public void setSbGroupsq(Integer sbGroupsq) {
        this.sbGroupsq = sbGroupsq;
    }

    public Integer getSbTitletab() {
        return sbTitletab;
    }

    public void setSbTitletab(Integer sbTitletab) {
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

    public Integer getSellNum() {
        return sellNum;
    }

    public void setSellNum(Integer sellNum) {
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
package dto;

import java.util.Date;

public class SellBoardReply {

    // 판매글 댓글번호 
    private Integer sbReplySeq;

    // 그룹넘버 
    private Integer sbGroupNum;

    // 그룹시퀀스 
    private Integer sbGroupSeq;

    // 칸띄움 
    private Integer sbTitleTab;

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

    public Integer getSbGroupNum() {
        return sbGroupNum;
    }

    public void setSbGroupNum(Integer sbGroupNum) {
        this.sbGroupNum = sbGroupNum;
    }

    public Integer getSbGroupSeq() {
        return sbGroupSeq;
    }

    public void setSbGroupSeq(Integer sbGroupSeq) {
        this.sbGroupSeq = sbGroupSeq;
    }

    public Integer getSbTitleTab() {
        return sbTitleTab;
    }

    public void setSbTitleTab(Integer sbTitleTab) {
        this.sbTitleTab = sbTitleTab;
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

	public SellBoardReply() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}
package dto;

import java.util.Date;

public class NoticeBoardDto {
	
	 private int notice_seq;
	 private String admin_id;
	 private String title;
	 private String content;
	 private int saw;
	 private Date reg_date;

	 public NoticeBoardDto(){
		 
	 }

	public NoticeBoardDto(int notice_seq, String admin_id, String title, String content, int saw, Date reg_date) {
		super();
		this.notice_seq = notice_seq;
		this.admin_id = admin_id;
		this.title = title;
		this.content = content;
		this.saw = saw;
		this.reg_date = reg_date;
	}
	
	
	public NoticeBoardDto(String admin_id, String title, String content) {
		super();
		this.admin_id = admin_id;
		this.title = title;
		this.content = content;
	}
	

	public NoticeBoardDto(int notice_seq, String title, String content) {
		super();
		this.notice_seq = notice_seq;
		this.title = title;
		this.content = content;
	}

	public int getNotice_seq() {
		return notice_seq;
	}

	public void setNotice_seq(int notice_seq) {
		this.notice_seq = notice_seq;
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
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

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	 
}
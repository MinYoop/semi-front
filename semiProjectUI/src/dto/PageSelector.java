package dto;

public class PageSelector {
	
	private String boardName;
	private int startNum;
	private int endNum;
	
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getEndNum() {
		return endNum;
	}
	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
	
	public PageSelector(String boardName, int startNum, int endNum) {
		super();
		this.boardName = boardName;
		this.startNum = startNum;
		this.endNum = endNum;
	}
	public PageSelector() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}

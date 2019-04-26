package kr.co.sist.vo;

public class SearchNoticeVO {
	
	private String searchKeyword;
	private int searchFlag, startNum, endNum, selectedPageIndex, pageCnt;
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public int getSearchFlag() {
		return searchFlag;
	}
	public void setSearchFlag(int searchFlag) {
		this.searchFlag = searchFlag;
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
	public int getSelectedPageIndex() {
		return selectedPageIndex;
	}
	public void setSelectedPageIndex(int selectedPageIndex) {
		this.selectedPageIndex = selectedPageIndex;
	}
	public int getPageCnt() {
		return pageCnt;
	}
	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}
}

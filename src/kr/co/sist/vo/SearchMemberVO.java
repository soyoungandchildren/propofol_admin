package kr.co.sist.vo;

public class SearchMemberVO {

	private String searchKeyword, searchFlag;
	private int startNum, endNum, selectedPageIndex, pageCnt, bigPage;
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public String getSearchFlag() {
		return searchFlag;
	}
	public void setSearchFlag(String searchFlag) {
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
	
	public int getBigPage() {
		return bigPage;
	}
	public void setBigPage(int bigPage) {
		this.bigPage = bigPage;
	}
	@Override
	public String toString() {
		return "SearchMemberVO [searchKeyword=" + searchKeyword + ", searchFlag=" + searchFlag + ", startNum="
				+ startNum + ", endNum=" + endNum + ", selectedPageIndex=" + selectedPageIndex + ", pageCnt=" + pageCnt
				+ ", getSearchKeyword()=" + getSearchKeyword() + ", getSearchFlag()=" + getSearchFlag()
				+ ", getStartNum()=" + getStartNum() + ", getEndNum()=" + getEndNum() + ", getSelectedPageIndex()="
				+ getSelectedPageIndex() + ", getPageCnt()=" + getPageCnt() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}

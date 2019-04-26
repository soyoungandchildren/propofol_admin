package kr.co.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.NoticeDAO;
import kr.co.sist.domain.SearchNotice;
import kr.co.sist.vo.SearchNoticeVO;
@Component
public class NoticeService {

	@Autowired(required=false)
	private NoticeDAO nDAO;
	
	public List<SearchNotice> searchNoticeList(SearchNoticeVO snVO) {
		List<SearchNotice> list = null;
		
		
		
		snVO.setStartNum(snVO.getSelectedPageIndex()*singlePageScale()-singlePageScale()+1);
		snVO.setEndNum(snVO.getStartNum()+singlePageScale()-1);
		
		list = nDAO.selectNotice(snVO);
		
		return list;
	}
	
	public int singlePageScale() {
		return 10;
	}
	
	public String totalPageIndexList() {
		int pageCount = nDAO.selectTotalPageCount();
		int idxCount = (int)Math.ceil((double)pageCount/singlePageScale());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=idxCount; i++) {
			
//			sb.append("<li class='page-item'><a class='page-link' href='javascript:moveIndex(")
//			  .append(i)
//			  .append(");'>")
//			  .append(i)
//			  .append("</a></li>");
			sb.append("<li class='page-item'><a class='page-link'>")
			  .append(i)
			  .append("</a></li>");
		}
		
		return sb.toString();
	}//totalPageIndex
	
	
}

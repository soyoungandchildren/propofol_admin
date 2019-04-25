package kr.co.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.NoticeDAO;
import kr.co.sist.domain.SearchNotice;
import kr.co.sist.vo.SearchNoticeVO;

public class NoticeService {

	
	
	public List<SearchNotice> searchNoticeList(SearchNoticeVO snVO) {
		List<SearchNotice> list = null;
		
		NoticeDAO nDAO = new NoticeDAO();
		
		snVO.setStartNum(snVO.getSelectedPageIndex()*singlePageScale()-singlePageScale()+1);
		snVO.setEndNum(snVO.getStartNum()+singlePageScale()-1);
		
		list = nDAO.selectNotice(snVO);
		
		return list;
	}
	
	public int singlePageScale() {
		return 10;
	}
	
	
}

package kr.co.sist.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.NoticeDAO;
import kr.co.sist.domain.NoticeDetail;
import kr.co.sist.domain.SearchNotice;
import kr.co.sist.vo.ModifyNoticeVO;
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
			
			sb.append("<li class='page-item'><a class='page-link' href='javascript:moveIndex(")
			  .append(i)
			  .append(");'>")
			  .append(i)
			  .append("</a></li>");
		}//end for
		
		return sb.toString();
	}//totalPageIndex
	
	
	public NoticeDetail searchNoticeDetail(int num) {
		NoticeDetail nd = nDAO.selectNoticeDetail(num);
		return nd;
	}//searchNoticeDetail
	
	
	public JSONObject modifyNoticeDetail(ModifyNoticeVO mnVO) {
		boolean resultFlag = false;
		String resultMsg = "변경 작업 중 오류가 발생했습니다. 나중에 다시 시도해주십시오.";
		Map<Object, Object> map = new HashMap<>();
				
		if(nDAO.updateNoticeDetail(mnVO)==1) {
			resultMsg = "공지사항을 성공적으로 수정하였습니다.";
			resultFlag = true;
		}//end if
		
		try {
			map.put("resultFlag", resultFlag);
			map.put("resultMsg", URLEncoder.encode(resultMsg, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		JSONObject json = new JSONObject(map);
		
		return json;
	}//modifyNoticeDetail
	
	
}//Class

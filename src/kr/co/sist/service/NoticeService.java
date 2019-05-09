package kr.co.sist.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.NoticeDAO;
import kr.co.sist.domain.NoticeDetail;
import kr.co.sist.domain.NoticeList;
import kr.co.sist.vo.ModifyNoticeVO;
import kr.co.sist.vo.SearchNoticeVO;
import kr.co.sist.vo.WriteNoticeVO;
@Component
public class NoticeService {

	@Autowired(required=false)
	private NoticeDAO nDAO;
	
	public List<NoticeList> searchNoticeList(SearchNoticeVO snVO) {
		List<NoticeList> list = null;
		if("글 제목".equals(snVO.getSearchFlag())) {
			snVO.setSearchFlag("searchToTitle");
		}else if("작성자".equals(snVO.getSearchFlag())) {
			snVO.setSearchFlag("searchToWriter");
		}//end else if
		
		snVO.setStartNum(snVO.getSelectedPageIndex()*singlePageScale()-singlePageScale()+1);
		snVO.setEndNum(snVO.getStartNum()+singlePageScale()-1);
		
		list = nDAO.selectNotice(snVO);
		
		return list;
	}
	
	public int singlePageScale() {
		return 10;
	}
	
	public int totalPageIndexList(SearchNoticeVO snVO) {
		int pageCount = nDAO.selectTotalPageCount(snVO);
		int idxCount = (int)Math.ceil((double)pageCount/singlePageScale());
		return idxCount;
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
		
		map.put("resultFlag", resultFlag);
		map.put("resultMsg", resultMsg);
		
		JSONObject json = new JSONObject(map);
		
		return json;
	}//modifyNoticeDetail
	
	
	public JSONObject writeNotice(WriteNoticeVO wnVO) {
		boolean resultFlag = false;
		String resultMsg = "공지사항 등록 중 오류가 발생했습니다. 나중에 다시 시도해주십시오.";
		Map<Object, Object> map = new HashMap<>();
		if(nDAO.insertNotice(wnVO)==1) {
			resultFlag = true;
			resultMsg = "공지사항을 성공적으로 등록하였습니다.";
		}//end if
		map.put("resultFlag", resultFlag);
		map.put("resultMsg", resultMsg);
		
		JSONObject json = new JSONObject(map);
		return json;
	}//writeNotice
	
	
	public JSONObject removeNotice(int num) {
		String resultMsg = "공지사항 삭제 중 오류가 발생했습니다. 나중에 다시 시도해주십시오.";
		
		if(nDAO.deleteNotice(num)==1) {
			resultMsg = "삭제하였습니다.";
		}//end if
		
		Map<Object, Object> map = new HashMap<>();
		map.put("resultMsg", resultMsg);
		
		JSONObject json = new JSONObject(map);
		return json;
	}//removeNotice
	
}//Class

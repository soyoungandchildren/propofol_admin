package kr.co.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.MemberDAO;
import kr.co.sist.domain.MemberList;
import kr.co.sist.vo.SearchMemberVO;

@Component
public class MemberService {

	@Autowired(required=false)
	private MemberDAO mDAO;
	
	public List<MemberList>  searchMemberList(SearchMemberVO smVO){
		smVO.setStartNum(smVO.getSelectedPageIndex()*singlePageScale()-singlePageScale()+1);
		smVO.setEndNum(smVO.getStartNum()+singlePageScale()-1);
		
		List<MemberList> list = mDAO.selectMemberList(smVO);
		
		
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).getPermit_st().equals("N")) {
				list.get(i).setPermit_st("대기 상태");
			}else if(list.get(i).getPermit_st().equals("Y")){
				list.get(i).setPermit_st("허용 상태");
			}//end else if
		}//end for
		
		return list;
	}//searchMemberList
	
	public int singlePageScale() {
		return 10;
	}
	
	public int totalPageIndexList() {
		int pageCount = mDAO.selectTotalPageCount();
		int idxCount = (int)Math.ceil((double)pageCount/singlePageScale());
		System.out.println("idx"+idxCount);
		
		return idxCount;
	}//totalPageIndex
	
}

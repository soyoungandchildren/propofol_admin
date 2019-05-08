package kr.co.sist.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.MemberDAO;
import kr.co.sist.domain.MemberInfo;
import kr.co.sist.domain.MemberList;
import kr.co.sist.vo.ChangeBanStatusVO;
import kr.co.sist.vo.ModifyMemberInfoVO;
import kr.co.sist.vo.SearchMemberVO;

@Component
public class MemberService {

	@Autowired(required=false)
	private MemberDAO mDAO;
	
	public List<MemberList>  searchMemberList(SearchMemberVO smVO){
		smVO.setStartNum(smVO.getSelectedPageIndex()*singlePageScale()-singlePageScale()+1);
		smVO.setEndNum(smVO.getStartNum()+singlePageScale()-1);
		if("아이디".equals(smVO.getSearchFlag())) {
			smVO.setSearchFlag("searchToId");
		}else if("이름".equals(smVO.getSearchFlag())) {
			smVO.setSearchFlag("searchToName");
		}//end else if
		
		List<MemberList> list = mDAO.selectMemberList(smVO);
		
		//null(미작성)상태는 DB에서 nvl함수로 '미작성'으로 처리중
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).getPermit_st().equals("N")) {
				list.get(i).setPermit_st("대기 상태");
			}else if(list.get(i).getPermit_st().equals("Y")){
				list.get(i).setPermit_st("허용 상태");
			}//end else if
			
			if("Y".equals(list.get(i).getIsbanned())){
				list.get(i).setIsbanned("차단 상태");
			}else {
				list.get(i).setIsbanned("");
			}//end else
		}//end for
		
		return list;
	}//searchMemberList
	
	public int singlePageScale() {
		return 10;
	}
	
	public int totalPageIndexList(SearchMemberVO smVO) {
		int pageCount = mDAO.selectTotalPageCount(smVO);
		int idxCount = (int)Math.ceil((double)pageCount/singlePageScale());
		
		return idxCount;
	}//totalPageIndex
	
	public MemberInfo searchMemberInfo(String user_id) {
		MemberInfo mi = mDAO.selectMemberInfo(user_id);
		
		if(mi.getPermit_st().equals("N")) {
			mi.setPermit_st("대기 상태");
		}else if(mi.getPermit_st().equals("Y")){
			mi.setPermit_st("허용 상태");
		}//end else if
			
		if("Y".equals(mi.getIsbanned())){
			mi.setIsbanned("차단 상태");
		}else{
			mi.setIsbanned("정상 계정");
		}//end else
		
		return mi;
	}//searchMemberInfo
	
	public JSONObject changeBanStatus(ChangeBanStatusVO cbsVO) {
		if("차단 상태".equals(cbsVO.getIsbanned())) {
			cbsVO.setIsbanned("N");
		}else if("정상 계정".equals(cbsVO.getIsbanned())) {
			cbsVO.setIsbanned("Y");
		}//end else if
		
		Map<Object, Object> map = new HashMap<>();
		String resultMsg = "회원 정보 변경에 실패하였습니다. 나중에 다시 시도해주세요.";
		boolean resultFlag = false;
		if(mDAO.updateBanStatus(cbsVO)==1) {
			resultFlag = true;
			resultMsg = "회원의 정보를 성공적으로 변경하였습니다.";
		}//end if
		map.put("resultFlag", resultFlag);
		map.put("resultMsg", resultMsg);
		
		JSONObject json = new JSONObject(map);
		return json;
	}//changeBanStatus
	
	public JSONObject modifyMemberInfo(ModifyMemberInfoVO mmiVO) {
		Map<Object, Object> map = new HashMap<>();
		String resultMsg = "회원 정보 수정 중 오류가 발생했습니다. 나중에 다시 시도해주세요.";
		
		if(mDAO.updateMemberInfo(mmiVO)==1) {
			resultMsg = "회원의 정보를 수정하였습니다.";
		}//end if
		
		map.put("resultMsg", resultMsg);
		JSONObject json = new JSONObject(map);
		return json;
	}//modifyMemberInfo
}//Class

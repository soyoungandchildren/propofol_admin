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
		if("���̵�".equals(smVO.getSearchFlag())) {
			smVO.setSearchFlag("searchToId");
		}else if("�̸�".equals(smVO.getSearchFlag())) {
			smVO.setSearchFlag("searchToName");
		}//end else if
		
		List<MemberList> list = mDAO.selectMemberList(smVO);
		
		//null(���ۼ�)���´� DB���� nvl�Լ��� '���ۼ�'���� ó����
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).getPermit_st().equals("N")) {
				list.get(i).setPermit_st("��� ����");
			}else if(list.get(i).getPermit_st().equals("Y")){
				list.get(i).setPermit_st("��� ����");
			}//end else if
			
			if("Y".equals(list.get(i).getIsbanned())){
				list.get(i).setIsbanned("���� ����");
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
			mi.setPermit_st("��� ����");
		}else if(mi.getPermit_st().equals("Y")){
			mi.setPermit_st("��� ����");
		}//end else if
			
		if("Y".equals(mi.getIsbanned())){
			mi.setIsbanned("���� ����");
		}else{
			mi.setIsbanned("���� ����");
		}//end else
		
		return mi;
	}//searchMemberInfo
	
	public JSONObject changeBanStatus(ChangeBanStatusVO cbsVO) {
		if("���� ����".equals(cbsVO.getIsbanned())) {
			cbsVO.setIsbanned("N");
		}else if("���� ����".equals(cbsVO.getIsbanned())) {
			cbsVO.setIsbanned("Y");
		}//end else if
		
		Map<Object, Object> map = new HashMap<>();
		String resultMsg = "ȸ�� ���� ���濡 �����Ͽ����ϴ�. ���߿� �ٽ� �õ����ּ���.";
		boolean resultFlag = false;
		if(mDAO.updateBanStatus(cbsVO)==1) {
			resultFlag = true;
			resultMsg = "ȸ���� ������ ���������� �����Ͽ����ϴ�.";
		}//end if
		map.put("resultFlag", resultFlag);
		map.put("resultMsg", resultMsg);
		
		JSONObject json = new JSONObject(map);
		return json;
	}//changeBanStatus
	
	public JSONObject modifyMemberInfo(ModifyMemberInfoVO mmiVO) {
		Map<Object, Object> map = new HashMap<>();
		String resultMsg = "ȸ�� ���� ���� �� ������ �߻��߽��ϴ�. ���߿� �ٽ� �õ����ּ���.";
		
		if(mDAO.updateMemberInfo(mmiVO)==1) {
			resultMsg = "ȸ���� ������ �����Ͽ����ϴ�.";
		}//end if
		
		map.put("resultMsg", resultMsg);
		JSONObject json = new JSONObject(map);
		return json;
	}//modifyMemberInfo
}//Class

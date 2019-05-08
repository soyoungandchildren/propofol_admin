package kr.co.sist.domain;

public class MemberInfo {
	private String user_id, name, birth, phone, inputdate, isbanned, permit_st;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getInputdate() {
		return inputdate;
	}
	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}
	public String getIsbanned() {
		return isbanned;
	}
	public void setIsbanned(String isbanned) {
		this.isbanned = isbanned;
	}
	public String getPermit_st() {
		return permit_st;
	}
	public void setPermit_st(String permit_st) {
		this.permit_st = permit_st;
	}
}

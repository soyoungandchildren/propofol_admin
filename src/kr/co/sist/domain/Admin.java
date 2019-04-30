package kr.co.sist.domain;

public class Admin {
	String admin_id, authority, inputdate, name, isremoved;

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getInputdate() {
		return inputdate;
	}

	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsremoved() {
		return isremoved;
	}

	public void setIsremoved(String isremoved) {
		this.isremoved = isremoved;
	}
}

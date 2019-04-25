package com.web.addressBook.domain;

public class birthday {
	private Integer bId;
	private String bName;
	private String bSex;
	private Integer bAge;
	private String bBirthday;
	private Integer flag;
	public Integer getbId() {
		return bId;
	}
	public void setbId(Integer bId) {
		this.bId = bId;
	}
	
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbSex() {
		return bSex;
	}
	public void setbSex(String bSex) {
		this.bSex = bSex;
	}
	public Integer getbAge() {
		return bAge;
	}
	public void setbAge(Integer bAge) {
		this.bAge = bAge;
	}
	public String getbBirthday() {
		return bBirthday;
	}
	public void setbBirthday(String bBirthday) {
		this.bBirthday = bBirthday;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "birthday [bId=" + bId + ", bName=" + bName + ", bSex=" + bSex + ", bAge=" + bAge + ", bBirthday="
				+ bBirthday + ", flag=" + flag + "]";
	}
	
}

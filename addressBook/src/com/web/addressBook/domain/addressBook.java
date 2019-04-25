package com.web.addressBook.domain;

public class addressBook {
	private int eId;
	private String eName;
	private String eSex;
	private String eAge;
	private String eTell1;
	private String eTell2;
	private String eTell3;
	private String eAddress;
	
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String geteSex() {
		return eSex;
	}
	public void seteSex(String eSex) {
		this.eSex = eSex;
	}
	public String geteAge() {
		return eAge;
	}
	public void seteAge(String eAge) {
		this.eAge = eAge;
	}
	public String geteTell1() {
		return eTell1;
	}
	public void seteTell1(String eTell1) {
		this.eTell1 = eTell1;
	}
	public String geteTell2() {
		return eTell2;
	}
	public void seteTell2(String eTell2) {
		this.eTell2 = eTell2;
	}
	public String geteTell3() {
		return eTell3;
	}
	public void seteTell3(String eTell3) {
		this.eTell3 = eTell3;
	}

	public String geteAddress() {
		return eAddress;
	}
	public void seteAddress(String eAddress) {
		this.eAddress = eAddress;
	}
	
	public addressBook() {
		super();
		
	}
	public addressBook(int eId, String eName, String eSex,String eAge, String eTell1, String eTell2, String eTell3,
			 String eAddress) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.eSex = eSex;
		this.eAge = eAge;
		this.eTell1 = eTell1;
		this.eTell2 = eTell2;
		this.eTell3 = eTell3;

		this.eAddress = eAddress;

	}
	public addressBook(String eName, String eSex, String eAge, String eTell1, String eTell2, String eTell3,
			 String eAddress) {
		super();
		this.eName = eName;
		this.eSex = eSex;
		this.eAge = eAge;
		this.eTell1 = eTell1;
		this.eTell2 = eTell2;
		this.eTell3 = eTell3;
		this.eAddress = eAddress;
	}
	
	
}

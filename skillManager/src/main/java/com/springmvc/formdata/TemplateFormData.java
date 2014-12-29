package com.springmvc.formdata;

import java.util.List;


public class TemplateFormData {
	
	private String firstname;

	private String lastname;
	
	private Integer age;
	
	private String fctclb;
	
	private String expclb;
	
	private String dispoclb;
	
	private String lastSchool;

	List<String> expSign;
	List<String> expSignLbl;
	List<String> cptTech;
	List<String> cptTechLbl;
	List<String> cptMtr;
	List<String> cptMtrLbl;
	List<String> fmt;
	List<String> fmtLbl;
	List<ExpProFormData> expPros;

	
	public String getLastSchool() {
		return lastSchool;
	}

	public void setLastSchool(String lastSchool) {
		this.lastSchool = lastSchool;
	}

	public List<String> getCptMtr() {
		return cptMtr;
	}

	public void setCptMtr(List<String> cptMtr) {
		this.cptMtr = cptMtr;
	}

	public List<String> getCptMtrLbl() {
		return cptMtrLbl;
	}

	public void setCptMtrLbl(List<String> cptMtrLbl) {
		this.cptMtrLbl = cptMtrLbl;
	}

	public List<String> getCptTech() {
		return cptTech;
	}

	public void setCptTech(List<String> cptTech) {
		this.cptTech = cptTech;
	}

	public List<String> getCptTechLbl() {
		return cptTechLbl;
	}

	public void setCptTechLbl(List<String> cptTechLbl) {
		this.cptTechLbl = cptTechLbl;
	}

	public List<String> getExpSignLbl() {
		return expSignLbl;
	}

	public void setExpSignLbl(List<String> expSignLbl) {
		this.expSignLbl = expSignLbl;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<String> getExpSign() {
		return expSign;
	}

	public void setExpSign(List<String> expSign) {
		this.expSign = expSign;
	}
	
	public String getFctclb() {
		return fctclb;
	}

	public void setFctclb(String fctclb) {
		this.fctclb = fctclb;
	}

	public String getExpclb() {
		return expclb;
	}

	public void setExpclb(String expclb) {
		this.expclb = expclb;
	}

	public List<String> getFmt() {
		return fmt;
	}

	public void setFmt(List<String> fmt) {
		this.fmt = fmt;
	}

	public List<String> getFmtLbl() {
		return fmtLbl;
	}

	public void setFmtLbl(List<String> fmtLbl) {
		this.fmtLbl = fmtLbl;
	}

	public String getDispoclb() {
		return dispoclb;
	}

	public void setDispoclb(String dispoclb) {
		this.dispoclb = dispoclb;
	}

	public List<ExpProFormData> getExpPros() {
		return expPros;
	}

	public void setExpPros(List<ExpProFormData> expPros) {
		this.expPros = expPros;
	}

}

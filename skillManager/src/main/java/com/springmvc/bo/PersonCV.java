package com.springmvc.bo;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="cv_personfields")
public class PersonCV {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstname;
	private String lastname;
	private Integer age;
	private String functionClb;
	private Integer yearsexp;
	
	@Temporal(TemporalType.DATE)
	private Date datedispo;
	private String lastschool;
	
	
	private List<PersonCVExpSign> expsSign;
	private List<PersonCVExpPro> expsPro;
	private List<PersonCVCptsTech> cptsTech;
	private List<PersonCVCptsMetier> cptsMetier;
	private List<PersonCVSchool> schools;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getFunctionClb() {
		return functionClb;
	}
	public void setFunctionClb(String functionClb) {
		this.functionClb = functionClb;
	}
	public Integer getYearsexp() {
		return yearsexp;
	}
	public void setYearsexp(Integer yearsexp) {
		this.yearsexp = yearsexp;
	}
	public Date getDatedispo() {
		return datedispo;
	}
	public void setDatedispo(Date datedispo) {
		this.datedispo = datedispo;
	}
	public String getLastschool() {
		return lastschool;
	}
	public void setLastschool(String lastschool) {
		this.lastschool = lastschool;
	}
	public List<PersonCVExpSign> getExpsSign() {
		return expsSign;
	}
	public void setExpsSign(List<PersonCVExpSign> expsSign) {
		this.expsSign = expsSign;
	}
	public List<PersonCVExpPro> getExpsPro() {
		return expsPro;
	}
	public void setExpsPro(List<PersonCVExpPro> expsPro) {
		this.expsPro = expsPro;
	}
	public List<PersonCVCptsTech> getCptsTech() {
		return cptsTech;
	}
	public void setCptsTech(List<PersonCVCptsTech> cptsTech) {
		this.cptsTech = cptsTech;
	}
	public List<PersonCVCptsMetier> getCptsMetier() {
		return cptsMetier;
	}
	public void setCptsMetier(List<PersonCVCptsMetier> cptsMetier) {
		this.cptsMetier = cptsMetier;
	}
	public List<PersonCVSchool> getSchools() {
		return schools;
	}
	public void setSchools(List<PersonCVSchool> schools) {
		this.schools = schools;
	}
	
	
	public PersonCV(String firstname, String lastname, Integer age,
			String functionClb, Integer yearsexp, Date datedispo,
			String lastschool, List<PersonCVExpSign> expsSign,
			List<PersonCVExpPro> expsPro, List<PersonCVCptsTech> cptsTech,
			List<PersonCVCptsMetier> cptsMetier, List<PersonCVSchool> schools) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.functionClb = functionClb;
		this.yearsexp = yearsexp;
		this.datedispo = datedispo;
		this.lastschool = lastschool;
		this.expsSign = expsSign;
		this.expsPro = expsPro;
		this.cptsTech = cptsTech;
		this.cptsMetier = cptsMetier;
		this.schools = schools;
	}
	
	public PersonCV() {
		
	}
	

}

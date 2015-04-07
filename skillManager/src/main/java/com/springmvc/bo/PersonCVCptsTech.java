package com.springmvc.bo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cv_cptstech")
public class PersonCVCptsTech {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private List<String> type;
	private List<String> technlogies;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<String> getCptTechLbl() {
		return type;
	}
	public void setCptTechLbl(List<String> cptTechLbl) {
		this.type = cptTechLbl;
	}
	public List<String> getCptTech() {
		return technlogies;
	}
	public void setCptTech(List<String> cptTech) {
		this.technlogies = cptTech;
	}
	
	public PersonCVCptsTech(List<String> cptTechLbl, List<String> cptTech) {
		super();
		this.type = cptTechLbl;
		this.technlogies = cptTech;
	}
	
	public PersonCVCptsTech() {
		
	}
	

}

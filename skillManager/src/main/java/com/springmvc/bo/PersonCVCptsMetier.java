package com.springmvc.bo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cv_cptsmetier")
public class PersonCVCptsMetier {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private List<String> job;
	private List<String> specificities;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<String> getJob() {
		return job;
	}
	public void setJob(List<String> job) {
		this.job = job;
	}
	public List<String> getSpecificities() {
		return specificities;
	}
	public void setSpecificities(List<String> specificities) {
		this.specificities = specificities;
	}
	
	public PersonCVCptsMetier(List<String> job, List<String> specificities) {
		super();
		this.job = job;
		this.specificities = specificities;
	}
	
	public PersonCVCptsMetier() {
		
	}
	
	

}

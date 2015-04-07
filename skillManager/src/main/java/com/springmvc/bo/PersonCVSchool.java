package com.springmvc.bo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cv_school")
public class PersonCVSchool {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private List<String> name;
	private List<String> title;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<String> getName() {
		return name;
	}
	public void setName(List<String> name) {
		this.name = name;
	}
	public List<String> getTitle() {
		return title;
	}
	public void setTitle(List<String> title) {
		this.title = title;
	}
	
	public PersonCVSchool(List<String> name, List<String> title) {
		super();
		this.name = name;
		this.title = title;
	}
	
	public PersonCVSchool() {
		
	}
	

}

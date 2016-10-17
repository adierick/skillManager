package com.springmvc.formdata;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.springmvc.bo.Formation;

@Component
public class FormationFormData {

	@Valid
	private Formation formation;
	private Long personId;
	
	
	public FormationFormData() {
		
	}


	public FormationFormData(Formation formation, Long personId) {
		super();
		this.formation = formation;
		this.personId = personId;
	}


	public Formation getFormation() {
		return formation;
	}


	public void setFormation(Formation formation) {
		this.formation = formation;
	}


	public Long getPersonId() {
		return personId;
	}


	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	
	
}

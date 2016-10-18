package com.springmvc.formdata;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.springmvc.bo.Career;

@Component
public class CareerFormData {
	
	@Valid
	private Career career;
	
	private Long personId;
	
	public CareerFormData(){
	}
	

	public CareerFormData(Career career, Long personId) {
		this.career = career;
		this.personId = personId;
	}


	public Career getCareer() {
		return career;
	}


	public void setCareer(Career career) {
		this.career = career;
	}


	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	
	
}

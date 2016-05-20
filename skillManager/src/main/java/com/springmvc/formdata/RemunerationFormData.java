package com.springmvc.formdata;


import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.springmvc.bo.Remuneration;

@Component
public class RemunerationFormData {
	@Valid
	private Remuneration remuneration;
	
	private Long personId;
	
	public RemunerationFormData(){
	}
	

	public RemunerationFormData(Remuneration remuneration, Long personId) {
		this.remuneration = remuneration;
		this.personId = personId;
	}




	public Remuneration getRemuneration() {
		return remuneration;
	}


	public void setRemuneration(Remuneration remuneration) {
		this.remuneration = remuneration;
	}


	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	
	
}

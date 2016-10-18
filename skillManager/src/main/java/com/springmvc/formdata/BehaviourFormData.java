package com.springmvc.formdata;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.springmvc.bo.Behaviour;

@Component
public class BehaviourFormData {

	@Valid
	private Behaviour behaviour;
	private Long personId;
	
	public BehaviourFormData() {
	}

	public BehaviourFormData(Behaviour behaviour, Long personId) {
		super();
		this.behaviour = behaviour;
		this.personId = personId;
	}

	public Behaviour getBehaviour() {
		return behaviour;
	}

	public void setBehaviour(Behaviour behaviour) {
		this.behaviour = behaviour;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}
		
}

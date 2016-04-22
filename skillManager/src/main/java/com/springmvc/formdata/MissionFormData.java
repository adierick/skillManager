package com.springmvc.formdata;


import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.springmvc.bo.Mission;





@Component
public class MissionFormData {
	@Valid
	private Mission mission;
	
	private Long personId;
	
	public MissionFormData(){
	}
	

	public MissionFormData(Mission mission, Long personId) {
		this.mission = mission;
		this.personId = personId;
	}


	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	
	
}

package com.springmvc.formdata;


import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.springmvc.bo.Mission;





@Component
public class MissionFormData {
	@Valid
	private Mission mission;
	
	public MissionFormData(){
	}
	
	public MissionFormData(Mission mission) {
		this.mission = mission;
	}
	public Mission getMission() {
		return mission;
	}
	public void setMission(Mission mission) {
		this.mission = mission;
	}
	
}

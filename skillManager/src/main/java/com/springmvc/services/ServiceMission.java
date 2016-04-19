package com.springmvc.services;

import java.util.List;

import com.springmvc.bo.Mission;

public interface ServiceMission extends IServiceMission{

	public List<Mission> listeMission();
	public List<Mission> listeAllMission();
	public Mission getMission(int idmission);

	public Mission mergeMission(Mission missionForMerge);

		
}

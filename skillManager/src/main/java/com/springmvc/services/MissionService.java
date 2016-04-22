/*
 * File: MissionService.java
 *
 * Goal: .
 *
 * History:
 * //  Creation of the file (ADI)
 */
package com.springmvc.services;

import java.util.List;

import com.springmvc.bo.Mission;

/**
 * The Interface MissionService.
 *
 * @author adi
 * @version 5.1, //2014
 */
public interface MissionService extends ISearchService<Mission> {
	
	/**
	 * Update Mission.
	 *
	 * @param mission the mission
	 */
	public void updateMission(Mission mission);
	
	/**
	 * Liste all Missions.
	 *
	 * @return the list
	 */
	public List<Mission> listeAllMissions();
	public List<Mission> listeAllMissions(int rowStart, int numberResults);
	
	/**
	 * Creates the Mission.
	 *
	 * @param Mission the Mission
	 * @return the Mission
	 */
	public Mission createMission(Mission mission);
	
	/**
	 * Gets the Mission.
	 *
	 * @param id the id
	 * @return the Mission
	 */
	public Mission getMission(Long id);
	
	/**
	 * Delete Mission.
	 *
	 * @param id the id
	 */
	public void deleteMission(Long id);
	
	
	public int missionCount();

}

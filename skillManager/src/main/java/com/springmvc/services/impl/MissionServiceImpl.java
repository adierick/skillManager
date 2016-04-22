/*
 * File: MissionServiceImpl.java
 *
 * Goal: .
 *
 * History:
 * //  Creation of the file (ADI)
 */
package com.springmvc.services.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.springmvc.bo.Mission;
import com.springmvc.bo.Person;
import com.springmvc.services.MissionService;
import com.springmvc.services.Service;


/**
 * The Class MissionServiceImpl.
 *
 * @author adi
 * @version 5.1, //2014
 */
@Component
@Transactional
public class MissionServiceImpl extends Service implements MissionService {


	/* (non-Javadoc)
	 * @see com.springmvc.services.MissionService#updateMission(com.springmvc.bo.Mission)
	 */
	public void updateMission(Mission mission) {
		getSession().update(mission);
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.MissionService#listeAllMissions()
	 */
	public List<Mission> listeAllMissions() {
		return getSession().createQuery(" from Mission").list();
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.MissionService#createMission(com.springmvc.bo.Mission)
	 */
	public Mission createMission(Mission mission) {
		getSession().save(mission);
		return mission;
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.MissionService#getMission(java.lang.Long)
	 */
	public Mission getMission(Long id) {
		//		return (Mission) getSession().get(Mission.class, id);
		Criteria sqlCriteria = getSession().createCriteria(Mission.class);
		sqlCriteria.add(Restrictions.eq("idmission", id)); 
		return (Mission) sqlCriteria.list().get(0);
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.MissionService#deleteMission(java.lang.Long)
	 */
	public void deleteMission(Long id) {
		getSession().delete(getMission(id));
	}

	/**
	 * Find.
	 *
	 * @param criteria the criteria
	 * @return the list
	 */
	public List<Mission> find(String criteria) {
		Criteria sqlCriteria = getSession().createCriteria(Mission.class);
		return sqlCriteria.list();
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.MissionService#find(java.lang.String, int, int)
	 */
	public List<Mission> find(String criteria, int rowStart, int numberResults) {
		Criteria sqlCriteria = getSession().createCriteria(Mission.class);
		sqlCriteria.setFirstResult(rowStart * numberResults);
		sqlCriteria.setMaxResults(numberResults);

		return sqlCriteria.list();
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.MissionService#listeAllMissions(int, int)
	 */
	public List<Mission> listeAllMissions(int rowStart, int numberResults) {

		Criteria sqlCriteria = getSession().createCriteria(Mission.class);
		sqlCriteria.setFirstResult(rowStart * numberResults);
		sqlCriteria.setMaxResults(numberResults);

		return sqlCriteria.list();
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.MissionService#missionCount()
	 */
	public int missionCount() {
		Criteria sqlCriteria = getSession().createCriteria(Mission.class);

		return sqlCriteria.list().size(); 
	}


}

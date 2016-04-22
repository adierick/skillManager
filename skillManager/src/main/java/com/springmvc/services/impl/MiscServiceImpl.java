/*
 * File: MISCServiceImpl.java
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

import com.springmvc.bo.MISC;
import com.springmvc.bo.Person;
import com.springmvc.services.MiscService;
import com.springmvc.services.Service;


@Component
@Transactional
public class MiscServiceImpl extends Service implements MiscService {

		
	/* (non-Javadoc)
	 * @see com.springmvc.services.MISCService#updateMISC(com.springmvc.bo.MISC)
	 */
	public void updateMISC(MISC MISC) {
		getSession().update(MISC);
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.MISCService#listeAllMISCs()
	 */
	public List<MISC> listeAllMISCs() {
		return getSession().createQuery(" from misc").list();
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.MISCService#createMISC(com.springmvc.bo.MISC)
	 */
	public MISC createMISC(MISC misc) {
		getSession().save(misc);
		return misc;
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.MISCService#getMISC(java.lang.Long)
	 */
	public MISC getMISC(Long id) {
		Criteria sqlCriteria = getSession().createCriteria(MISC.class);
		sqlCriteria.add(Restrictions.eq("id", id)); 
		return (MISC) sqlCriteria.list().get(0);
	}
	
	/* (non-Javadoc)
	 * @see com.springmvc.services.MISCService#deleteMISC(java.lang.Long)
	 */
	public void deleteMISC(Long id) {
		getSession().delete(id);
	}

	/**
	 * Find.
	 *
	 * @param criteria the criteria
	 * @return the list
	 */
	public List<MISC> find(String criteria) {
		Criteria sqlCriteria = getSession().createCriteria(MISC.class);
		sqlCriteria.setFetchMode("person", FetchMode.JOIN);
		return sqlCriteria.list();
	}
	
	/* (non-Javadoc)
	 * @see com.springmvc.services.MISCService#find(java.lang.String, int, int)
	 */
	public List<MISC> find(String criteria, int rowStart, int numberResults) {
		Criteria sqlCriteria = getSession().createCriteria(MISC.class);
		
		sqlCriteria.setFirstResult(rowStart * numberResults);
		sqlCriteria.setMaxResults(numberResults);
		
		return sqlCriteria.list();
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.MISCService#listeAllMISCs(int, int)
	 */
	public List<MISC> listeAllMISCs(int rowStart, int numberResults) {
		
		Criteria sqlCriteria = getSession().createCriteria(MISC.class);
		sqlCriteria.setFirstResult(rowStart * numberResults);
		sqlCriteria.setMaxResults(numberResults);
		
		return sqlCriteria.list();
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.MISCService#MISCCount()
	 */
	public int MISCCount() {
		Criteria sqlCriteria = getSession().createCriteria(MISC.class);
		
		return sqlCriteria.list().size(); 
	}


}

/*
 * File: RemunerationServiceImpl.java
 *
 * Goal: .
 *
 * History:
 * //  Creation of the file (ADI)
 */
package com.springmvc.services.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.bo.Remuneration;
import com.springmvc.services.RemunerationService;
import com.springmvc.services.Service;


/**
 * The Class RemunerationServiceImpl.
 *
 * @author adi
 * @version 5.1, //2014
 */
@Component
@Transactional
public class RemunerationServiceImpl extends Service implements RemunerationService {


	/* (non-Javadoc)
	 * @see com.springmvc.services.RemunerationService#updateRemuneration(com.springmvc.bo.Remuneration)
	 */
	public void updateRemuneration(Remuneration remuneration) {
		getSession().update(remuneration);
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.RemunerationService#listeAllRemunerations()
	 */
	public List<Remuneration> listeAllRemunerations() {
		return getSession().createQuery(" from Remuneration").list();
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.RemunerationService#createRemuneration(com.springmvc.bo.Remuneration)
	 */
	public Remuneration createRemuneration(Remuneration remuneration) {
		getSession().save(remuneration);
		return remuneration;
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.RemunerationService#getRemuneration(java.lang.Long)
	 */
	public Remuneration getRemuneration(Long id) {
		//		return (Remuneration) getSession().get(Remuneration.class, id);
		Criteria sqlCriteria = getSession().createCriteria(Remuneration.class);
		sqlCriteria.add(Restrictions.eq("idremuneration", id)); 
		return (Remuneration) sqlCriteria.list().get(0);
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.RemunerationService#deleteRemuneration(java.lang.Long)
	 */
	public void deleteRemuneration(Long id) {
		getSession().delete(getRemuneration(id));
	}

	/**
	 * Find.
	 *
	 * @param criteria the criteria
	 * @return the list
	 */
	public List<Remuneration> find(String criteria) {
		Criteria sqlCriteria = getSession().createCriteria(Remuneration.class);
		return sqlCriteria.list();
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.RemunerationService#find(java.lang.String, int, int)
	 */
	public List<Remuneration> find(String criteria, int rowStart, int numberResults) {
		Criteria sqlCriteria = getSession().createCriteria(Remuneration.class);
		sqlCriteria.setFirstResult(rowStart * numberResults);
		sqlCriteria.setMaxResults(numberResults);

		return sqlCriteria.list();
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.RemunerationService#listeAllRemunerations(int, int)
	 */
	public List<Remuneration> listeAllRemunerations(int rowStart, int numberResults) {

		Criteria sqlCriteria = getSession().createCriteria(Remuneration.class);
		sqlCriteria.setFirstResult(rowStart * numberResults);
		sqlCriteria.setMaxResults(numberResults);

		return sqlCriteria.list();
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.RemunerationService#remunerationCount()
	 */
	public int remunerationCount() {
		Criteria sqlCriteria = getSession().createCriteria(Remuneration.class);

		return sqlCriteria.list().size(); 
	}


}

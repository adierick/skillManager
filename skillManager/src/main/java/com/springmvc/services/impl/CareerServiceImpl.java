/*
 * File: CareerServiceImpl.java
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
import com.springmvc.bo.Career;
import com.springmvc.bo.Person;
import com.springmvc.services.CareerService;
import com.springmvc.services.Service;


/**
 * The Class CareerServiceImpl.
 *
 * @author adi
 * @version 5.1, //2014
 */
@Component
@Transactional
public class CareerServiceImpl extends Service implements CareerService {


	/* (non-Javadoc)
	 * @see com.springmvc.services.CareerService#updateCareer(com.springmvc.bo.Career)
	 */
	public void updateCareer(Career career) {
		getSession().update(career);
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.CareerService#listeAllCareers()
	 */
	public List<Career> listeAllCareers() {
		return getSession().createQuery(" from Career").list();
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.CareerService#createCareer(com.springmvc.bo.Career)
	 */
	public Career createCareer(Career career) {
		getSession().save(career);
		return career;
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.CareerService#getCareer(java.lang.Long)
	 */
	public Career getCareer(Long id) {
		//		return (Career) getSession().get(Career.class, id);
		Criteria sqlCriteria = getSession().createCriteria(Career.class);
		sqlCriteria.add(Restrictions.eq("idcareer", id)); 
		return (Career) sqlCriteria.list().get(0);
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.CareerService#deleteCareer(java.lang.Long)
	 */
	public void deleteCareer(Long id) {
		getSession().delete(getCareer(id));
	}

	/**
	 * Find.
	 *
	 * @param criteria the criteria
	 * @return the list
	 */
	public List<Career> find(String criteria) {
		Criteria sqlCriteria = getSession().createCriteria(Career.class);
		return sqlCriteria.list();
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.CareerService#find(java.lang.String, int, int)
	 */
	public List<Career> find(String criteria, int rowStart, int numberResults) {
		Criteria sqlCriteria = getSession().createCriteria(Career.class);
		sqlCriteria.setFirstResult(rowStart * numberResults);
		sqlCriteria.setMaxResults(numberResults);

		return sqlCriteria.list();
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.CareerService#listeAllCareers(int, int)
	 */
	public List<Career> listeAllCareers(int rowStart, int numberResults) {

		Criteria sqlCriteria = getSession().createCriteria(Career.class);
		sqlCriteria.setFirstResult(rowStart * numberResults);
		sqlCriteria.setMaxResults(numberResults);

		return sqlCriteria.list();
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.CareerService#careerCount()
	 */
	public int careerCount() {
		Criteria sqlCriteria = getSession().createCriteria(Career.class);

		return sqlCriteria.list().size(); 
	}


}

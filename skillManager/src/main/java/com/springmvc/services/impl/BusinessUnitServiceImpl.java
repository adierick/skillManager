/*
 * File: BusinessUnitServiceImpl.java
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

import com.springmvc.bo.BusinessUnit;
import com.springmvc.bo.Person;
import com.springmvc.services.BusinessUnitService;
import com.springmvc.services.Service;

/**
 * The Class BusinessUnitServiceImpl.
 *
 * @author adi
 * @version 5.1, //2014
 */
@Component
@Transactional
public class BusinessUnitServiceImpl extends Service implements BusinessUnitService {

		
	/* (non-Javadoc)
	 * @see com.springmvc.services.BusinessUnitService#updateBusinessUnit(com.springmvc.bo.BusinessUnit)
	 */
	public void updateBusinessUnit(BusinessUnit businessUnit) {
		getSession().update(businessUnit);
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.BusinessUnitService#listeAllBusinessUnits()
	 */
	public List<BusinessUnit> listeAllBusinessUnits() {
		return getSession().createQuery(" from BusinessUnit").list();
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.BusinessUnitService#createBusinessUnit(com.springmvc.bo.BusinessUnit)
	 */
	public BusinessUnit createBusinessUnit(BusinessUnit businessUnit) {
		getSession().save(businessUnit);
		return businessUnit;
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.BusinessUnitService#getBusinessUnit(java.lang.Long)
	 */
	public BusinessUnit getBusinessUnit(Long id) {
//		return (BusinessUnit) getSession().get(BusinessUnit.class, id);
		Criteria sqlCriteria = getSession().createCriteria(BusinessUnit.class);
		sqlCriteria.add(Restrictions.eq("id", id)); 
		return (BusinessUnit) sqlCriteria.list().get(0);
	}
	
	/* (non-Javadoc)
	 * @see com.springmvc.services.BusinessUnitService#deleteBusinessUnit(java.lang.Long)
	 */
	public void deleteBusinessUnit(Long id) {
		BusinessUnit businessUnit = getBusinessUnit(id);
		List<Person> listPersonBuList = businessUnit.getPersons();
		if (listPersonBuList.isEmpty()) {
			getSession().delete(getBusinessUnit(id));
		} else {
			for (Person person : listPersonBuList) {
				System.out.println(person);
			}
		}
	}

	/**
	 * Find.
	 *
	 * @param criteria the criteria
	 * @return the list
	 */
	public List<BusinessUnit> find(String criteria) {
		Criteria sqlCriteria = getSession().createCriteria(BusinessUnit.class);
		sqlCriteria.add(Restrictions.like("label", "%"+criteria+"%"));
		sqlCriteria.setFetchMode("persons", FetchMode.JOIN);
		return sqlCriteria.list();
	}
	
	/* (non-Javadoc)
	 * @see com.springmvc.services.BusinessUnitService#find(java.lang.String, int, int)
	 */
	public List<BusinessUnit> find(String criteria, int rowStart, int numberResults) {
		Criteria sqlCriteria = getSession().createCriteria(BusinessUnit.class);
		sqlCriteria.add(Restrictions.like("label", "%"+criteria+"%"));
		
		sqlCriteria.setFirstResult(rowStart * numberResults);
		sqlCriteria.setMaxResults(numberResults);
		
		return sqlCriteria.list();
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.BusinessUnitService#listeAllBusinessUnits(int, int)
	 */
	public List<BusinessUnit> listeAllBusinessUnits(int rowStart, int numberResults) {
		
		Criteria sqlCriteria = getSession().createCriteria(BusinessUnit.class);
		sqlCriteria.setFirstResult(rowStart * numberResults);
		sqlCriteria.setMaxResults(numberResults);
		
		return sqlCriteria.list();
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.BusinessUnitService#businessUnitCount()
	 */
	public int businessUnitCount() {
		Criteria sqlCriteria = getSession().createCriteria(BusinessUnit.class);
		
		return sqlCriteria.list().size(); 
	}

}

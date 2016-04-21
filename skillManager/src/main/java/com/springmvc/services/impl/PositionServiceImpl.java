/*
 * File: PositionServiceImpl.java
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
import com.springmvc.bo.Position;
import com.springmvc.bo.Person;
import com.springmvc.services.PositionService;
import com.springmvc.services.Service;


/**
 * The Class PositionServiceImpl.
 *
 * @author adi
 * @version 5.1, //2014
 */
@Component
@Transactional
public class PositionServiceImpl extends Service implements PositionService {

		
	/* (non-Javadoc)
	 * @see com.springmvc.services.PositionService#updatePosition(com.springmvc.bo.Position)
	 */
	public void updatePosition(Position position) {
		getSession().update(position);
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.PositionService#listeAllPositions()
	 */
	public List<Position> listeAllPositions() {
		return getSession().createQuery(" from Position").list();
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.PositionService#createPosition(com.springmvc.bo.Position)
	 */
	public Position createPosition(Position position) {
		getSession().save(position);
		return position;
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.PositionService#getPosition(java.lang.Long)
	 */
	public Position getPosition(Long id) {
//		return (Position) getSession().get(Position.class, id);
		Criteria sqlCriteria = getSession().createCriteria(Position.class);
		sqlCriteria.add(Restrictions.eq("id", id)); 
		return (Position) sqlCriteria.list().get(0);
	}
	
	/* (non-Javadoc)
	 * @see com.springmvc.services.PositionService#deletePosition(java.lang.Long)
	 */
	public void deletePosition(Long id) {
		Position position = getPosition(id);
		List<Person> listPersonBuList = position.getPersons();
		if (listPersonBuList.isEmpty()) {
			getSession().delete(getPosition(id));
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
	public List<Position> find(String criteria) {
		Criteria sqlCriteria = getSession().createCriteria(Position.class);
		sqlCriteria.add(Restrictions.like("code", "%"+criteria+"%"));
		sqlCriteria.setFetchMode("persons", FetchMode.JOIN);
		return sqlCriteria.list();
	}
	
	/* (non-Javadoc)
	 * @see com.springmvc.services.PositionService#find(java.lang.String, int, int)
	 */
	public List<Position> find(String criteria, int rowStart, int numberResults) {
		Criteria sqlCriteria = getSession().createCriteria(Position.class);
		sqlCriteria.add(Restrictions.like("code", "%"+criteria+"%"));
		
		sqlCriteria.setFirstResult(rowStart * numberResults);
		sqlCriteria.setMaxResults(numberResults);
		
		return sqlCriteria.list();
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.PositionService#listeAllPositions(int, int)
	 */
	public List<Position> listeAllPositions(int rowStart, int numberResults) {
		
		Criteria sqlCriteria = getSession().createCriteria(Position.class);
		sqlCriteria.setFirstResult(rowStart * numberResults);
		sqlCriteria.setMaxResults(numberResults);
		
		return sqlCriteria.list();
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.PositionService#positionCount()
	 */
	public int positionCount() {
		Criteria sqlCriteria = getSession().createCriteria(Position.class);
		
		return sqlCriteria.list().size(); 
	}


}

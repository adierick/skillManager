/*
 * File: PersonServiceImpl.java
 *
 * Goal: .
 *
 * History:
 * //  Creation of the file (ADI)
 */
package com.springmvc.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.springmvc.bo.BusinessUnit;
import com.springmvc.bo.Person;
import com.springmvc.bo.dto.webservice.PersonDto;
//import com.springmvc.bo.dto.webservice.PersonDto;
import com.springmvc.services.PersonService;
import com.springmvc.services.Service;
//import com.springmvc.services.Service;

/**
 * The Class PersonServiceImpl.
 *
 * @author adi
 * @version 5.1, //2014
 */
@Component
@Transactional
public class PersonServiceImpl extends Service implements PersonService {

		
	/* (non-Javadoc)
	 * @see com.springmvc.services.PersonService#updatePerson(com.springmvc.bo.Person)
	 */
	@Override
	public void updatePerson(Person person) {
		getSession().update(person);
	}
	
	@Override
	public Person mergePerson(Person person) {
		return (Person)getSession().merge(person);
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.PersonService#listeAllPersons()
	 */
	@Override
	public List<Person> listeAllPersons() {
		return getSession().createQuery(" from Person").list();
	}
	
	@Override
	public List<PersonDto> getAllPersons() {
		List<Person> persons = listeAllPersons();
		List<PersonDto> personsDto = new ArrayList<>();
		for (Person person : persons){
			personsDto.add(new PersonDto(person));
		}
		return personsDto;
	}
	
	@Override
	public List<Person> listeAllActivePersons() {
		return getSession().createQuery(" from Person where bu is not null").list();
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.PersonService#createPerson(com.springmvc.bo.Person)
	 */
	@Override
	public Person createPerson(Person person) {
		getSession().save(person);
		return person;
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.PersonService#getPerson(java.lang.Long)
	 */
	@Override
	public Person getPerson(Long id) {
		return (Person) getSession().get(Person.class, id);
	}
	@Override
	public Person getPerson(String matricule) {
		Criteria sqlCriteria = getSession().createCriteria(Person.class);
		sqlCriteria.add(Restrictions.eq("matricule", matricule)); 
		return (Person) sqlCriteria.list().get(0);
	}
	
	/* (non-Javadoc)
	 * @see com.springmvc.services.PersonService#deletePerson(java.lang.Long)
	 */
	@Override
	public void deletePerson(Long id) {
		getSession().delete(getPerson(id));
	}
	@Override
	public void deletePerson(String matricule) {
		getSession().delete(getPerson(matricule));
	}
	
	/**
	 * Find.
	 *
	 * @param criteria the criteria
	 * @return the list
	 */
	@Override
	public List<Person> find(String criteria) {
		Criteria sqlCriteria = getSession().createCriteria(Person.class);
		sqlCriteria.add(
				Restrictions.or(
						Restrictions.or(
								Restrictions.like("matricule", "%"+criteria+"%"), 
								Restrictions.like("login", "%"+criteria+"%")), 
								Restrictions.or(
										Restrictions.like("firstname", "%"+criteria+"%"), 
										Restrictions.like("lastname", "%"+criteria+"%"))));
		return sqlCriteria.list();
	}
	
	/* (non-Javadoc)
	 * @see com.springmvc.services.PersonService#find(java.lang.String, int, int)
	 */
	@Override
	public List<Person> find(String criteria, int rowStart, int numberResults) {
		Criteria sqlCriteria = getSession().createCriteria(Person.class);
		sqlCriteria.add(
				Restrictions.or(
						Restrictions.or(
								Restrictions.like("matricule", "%"+criteria+"%"), 
								Restrictions.like("login", "%"+criteria+"%")), 
								Restrictions.or(
										Restrictions.like("firstname", "%"+criteria+"%"), 
										Restrictions.like("lastname", "%"+criteria+"%"))));
		
		sqlCriteria.setFirstResult(rowStart * numberResults);
		sqlCriteria.setMaxResults(numberResults);
		
		return sqlCriteria.list();
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.PersonService#listeAllPersons(int, int)
	 */
	@Override
	public List<Person> listeAllPersons(int rowStart, int numberResults) {
		
		Criteria sqlCriteria = getSession().createCriteria(Person.class);
		sqlCriteria.setFirstResult(rowStart * numberResults);
		sqlCriteria.setMaxResults(numberResults);
		
		return sqlCriteria.list();
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.PersonService#personCount()
	 */
	@Override
	public int personCount() {
		Criteria sqlCriteria = getSession().createCriteria(Person.class);
		
		return sqlCriteria.list().size(); 
	}

	@Override
	public List<BusinessUnit> listeAllBusinessUnits() {
		return getSession().createQuery(" from BusinessUnit").list();
	}

	@Override
	public Collection<Person> listpersonBu(BusinessUnit bu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonDto> getPersonsByBu(String buLabel) {
		Criteria sqlCriteria = getSession().createCriteria(Person.class);
		sqlCriteria.setFetchMode("bu", FetchMode.JOIN);
		sqlCriteria.add(Restrictions.eq("bu.label", buLabel)); 
		List<Person> persons = sqlCriteria.list();
		List<PersonDto> personsDto = new ArrayList<PersonDto>();
		for (Person p : persons){
			personsDto.add(new PersonDto(p));
		}
		return personsDto;
	}


}

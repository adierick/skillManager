/*
 * File: PersonService.java
 *
 * Goal: .
 *
 * History:
 * //  Creation of the file (ADI)
 */
package com.springmvc.services;

import java.util.Collection;
import java.util.List;

import com.springmvc.bo.BusinessUnit;
import com.springmvc.bo.Person;
import com.springmvc.bo.dto.webservice.PersonDto;

/**
 * The Interface PersonService.
 *
 * @author adi
 * @version 5.1, //2014
 */
public interface PersonService extends ISearchService<Person> {
	
	/**
	 * Update Person.
	 *
	 * @param person the person
	 */
	public void updatePerson(Person person);
	public Person mergePerson(Person person);
	
	/**
	 * Liste all Persons.
	 *
	 * @return the list
	 */
	public List<Person> listeAllPersons();
	public List<PersonDto> getAllPersons();
	public List<Person> listeAllActivePersons();
	public List<Person> listeAllPersons(int rowStart, int numberResults);
	
	public List<BusinessUnit> listeAllBusinessUnits();
	
	/**
	 * Creates the Person.
	 *
	 * @param Person the Person
	 * @return the Person
	 */
	public Person createPerson(Person person);
	
	/**
	 * Gets the Person.
	 *
	 * @param id the id
	 * @return the Person
	 */
	public Person getPerson(Long id);
	public Person getPerson(String matricule);
	
	/**
	 * Delete Person.
	 *
	 * @param id the id
	 */
	public void deletePerson(Long id);
	public void deletePerson(String matricule);
	
	
	public int personCount();
	public Collection<Person> listpersonBu(BusinessUnit bu);

}

package com.springmvc.webservices.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.bo.dto.webservice.PersonDto;
import com.springmvc.services.BusinessUnitService;
import com.springmvc.services.PersonService;
import com.springmvc.webservices.service.SkillManagerWS;
import com.springmvc.webservices.types.PersonListResponse;

@Transactional
public class SkillManagerWSImpl implements SkillManagerWS {

	/** The service. */
	@Autowired
	private PersonService personService;
	@Autowired
	private BusinessUnitService buService;
		
	@Override
	public PersonListResponse getPersonList() {	
		PersonListResponse personListResponse = new PersonListResponse();
		try {
			List<PersonDto> personnes = personService.getAllPersons();
			personListResponse.setPersonList(personnes);
			personListResponse.setSuccess(true);					
		} catch (Exception e) {
			personListResponse.setSuccess(false);
		}
		return personListResponse;
	}

	@Override
	public PersonListResponse getPersonListByBU(String buLabel) {		
		PersonListResponse personListResponse = new PersonListResponse();
		try {
			List<PersonDto> persons = personService.getPersonsByBu(buLabel);
			personListResponse.setPersonList(persons);
			personListResponse.setSuccess(true);									
		} catch (Exception e) {
			personListResponse.setSuccess(false);
		}
		return personListResponse;
	}

}

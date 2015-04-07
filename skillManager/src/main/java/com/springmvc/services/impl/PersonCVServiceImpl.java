package com.springmvc.services.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.springmvc.bo.PersonCV;
import com.springmvc.formdata.TemplateFormData;
import com.springmvc.services.PersonCVService;
import com.springmvc.services.Service;

public class PersonCVServiceImpl extends Service implements PersonCVService {
	
	@Override
	public void updateCV(PersonCV personCV) {
		getSession().merge(personCV);
		
	}

	@Override
	public PersonCV saveCV(PersonCV personCV) {
		getSession().save(personCV);
		return personCV;
	}

	@Override
	public PersonCV getPersonCV(Long id) {
		return (PersonCV) getSession().get(PersonCV.class, id);
		
	}
	
	@Override
	public PersonCV getPersonCV(String lastname) {
		Criteria sqlCriteria = getSession().createCriteria(PersonCV.class);
		sqlCriteria.add(Restrictions.eq("lastname", lastname));
		List result = sqlCriteria.list();
		
		if(result.size() == 0) {
			return null;
		}
		return (PersonCV) sqlCriteria.list().get(0);
		
	}

	@Override
	public void deletePersonCV(Long id) {
		getSession().delete(getPersonCV(id));
		
	}

	@Override
	public List<PersonCV> listAllPersonsCV() {
		return getSession().createQuery("from PersonCV").list();
	}
	
	@Override
	public List<TemplateFormData> find(String criteria, int rowStart, int numberResults) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<TemplateFormData> find(String criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

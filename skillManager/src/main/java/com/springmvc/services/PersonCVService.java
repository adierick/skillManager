package com.springmvc.services;

import java.util.Collection;
import java.util.List;

import com.springmvc.bo.PersonCV;
import com.springmvc.formdata.TemplateFormData;

public interface PersonCVService  extends ISearchService<TemplateFormData> {
	
	public void updateCV(PersonCV personCV);

	
	public PersonCV saveCV(PersonCV personCV);

	
	public PersonCV getPersonCV(Long id);
	
	
	public PersonCV getPersonCV(String lastname);

	
	public void deletePersonCV(Long id);

	
	public List<PersonCV> listAllPersonsCV();
	
	@Override
	public List<TemplateFormData> find(String criteria, int rowStart, int numberResults);

	
	@Override
	public Collection<TemplateFormData> find(String criteria);

	

}

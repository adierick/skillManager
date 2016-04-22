package com.springmvc.web.editor;

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang.StringUtils;

import com.springmvc.Context;
import com.springmvc.bo.BusinessUnit;
import com.springmvc.bo.Person;
import com.springmvc.services.BusinessUnitService;
import com.springmvc.services.PersonService;

public class PersonEditor extends PropertyEditorSupport {

	private final PersonService service;

	public PersonEditor() {
		super();
		service = (PersonService) Context.getInstance().getApplicationContext().getBean(PersonService.class);
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(StringUtils.isNotBlank(text)){
			setValue(service.getPerson(Long.parseLong(text)));
		}
		else{
			setValue(null);
		}
	}

	@Override
	public String getAsText() {
		Person s = (Person) getValue();
		if (s == null) {
			return null;
		} else {
			return s.toString();
		}
	}

}

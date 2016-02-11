package com.springmvc.webservices.types;

import java.util.List;

import com.springmvc.bo.Person;

public class PersonListResponse {
	
	private List<Person> personList;
	private boolean isSuccess;
	
	
	public PersonListResponse() {}
	
	
	public PersonListResponse(List<Person> personList, boolean isSuccess) {
		this.personList = personList;
		this.isSuccess = isSuccess;
	}

	
	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}	
	
	
	
}

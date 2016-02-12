package com.springmvc.webservices.types;

import java.util.List;

import com.springmvc.bo.dto.webservice.PersonDto;

public class PersonListResponse {
	
	private List<PersonDto> personList;
	private boolean isSuccess;
	
	
	public PersonListResponse() {}
	
	
	public PersonListResponse(List<PersonDto> personList, boolean isSuccess) {
		this.personList = personList;
		this.isSuccess = isSuccess;
	}

	
	public List<PersonDto> getPersonList() {
		return personList;
	}

	public void setPersonList(List<PersonDto> personList) {
		this.personList = personList;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}	
	
	
	
}

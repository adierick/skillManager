package com.springmvc.webservices.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.springmvc.webservices.types.PersonListResponse;

@WebService
public interface SkillManagerWS {
	
	@WebMethod
	public PersonListResponse getPersonList();
	
	@WebMethod
	public PersonListResponse getPersonListByBU(
			@WebParam(name="buCode") String buCode);

	
	
	
}

package com.springmvc.services;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.springmvc.bo.Person;


@Component
@Transactional
public  class ServiceListCollab implements IServiceListCollab{
//	@Autowired
//	private IListeCollabDAO dao;
	
	public List<Person> rechercherCollab(){
		return null;
	}
}

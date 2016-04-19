package com.springmvc.services;

import java.util.List;

import com.springmvc.bo.Person;
import com.springmvc.bo.Remuneration;

public interface IServiceRemuneration {
	List<Remuneration> afficheRemuneration();

	List<Remuneration> listeAllRemuneration();

	Remuneration getRemuneration(Long idREMUNERATION);

	Remuneration getRemuneration(String client);

	List<Remuneration> find(String criteria, int rowStart, int numberResults);

	List<Person> find(String criteria);
}

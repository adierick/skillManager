package com.springmvc.services;

import java.util.List;

import com.springmvc.bo.Remuneration;


public interface ServiceRemuneration extends IServiceRemuneration{
	@Override
	public List<Remuneration> listeAllRemuneration();

	@Override
	public List<Remuneration> afficheRemuneration();
	public List<Remuneration> listeRemuneration();

//	Remuneration getRemuneration(Long idREMUNERATION);
//
//	List<Remuneration> find(String criteria, int rowStart, int numberResults);
}

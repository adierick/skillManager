/*
 * File: RemunerationService.java
 *
 * Goal: .
 *
 * History:
 * //  Creation of the file (ADI)
 */
package com.springmvc.services;

import java.util.List;

import com.springmvc.bo.Remuneration;

/**
 * The Interface RemunerationService.
 *
 * @author adi
 * @version 5.1, //2014
 */
public interface RemunerationService extends ISearchService<Remuneration> {
	
	/**
	 * Update Remuneration.
	 *
	 * @param remuneration the remuneration
	 */
	public void updateRemuneration(Remuneration remuneration);
	
	/**
	 * Liste all Remunerations.
	 *
	 * @return the list
	 */
	public List<Remuneration> listeAllRemunerations();
	public List<Remuneration> listeAllRemunerations(int rowStart, int numberResults);
	
	/**
	 * Creates the Remuneration.
	 *
	 * @param Remuneration the Remuneration
	 * @return the Remuneration
	 */
	public Remuneration createRemuneration(Remuneration remuneration);
	
	/**
	 * Gets the Remuneration.
	 *
	 * @param id the id
	 * @return the Remuneration
	 */
	public Remuneration getRemuneration(Long id);
	
	/**
	 * Delete Remuneration.
	 *
	 * @param id the id
	 */
	public void deleteRemuneration(Long id);
	
	
	public int remunerationCount();

}

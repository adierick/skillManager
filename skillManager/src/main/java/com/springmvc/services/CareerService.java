/*
 * File: CareerService.java
 *
 * Goal: .
 *
 * History:
 * //  Creation of the file (ADI)
 */
package com.springmvc.services;

import java.util.List;

import com.springmvc.bo.Career;

/**
 * The Interface CareerService.
 *
 * @author adi
 * @version 5.1, //2014
 */
public interface CareerService extends ISearchService<Career> {
	
	/**
	 * Update Career.
	 *
	 * @param career the career
	 */
	public void updateCareer(Career career);
	
	/**
	 * Liste all Careers.
	 *
	 * @return the list
	 */
	public List<Career> listeAllCareers();
	public List<Career> listeAllCareers(int rowStart, int numberResults);
	
	/**
	 * Creates the Career.
	 *
	 * @param Career the Career
	 * @return the Career
	 */
	public Career createCareer(Career career);
	
	/**
	 * Gets the Career.
	 *
	 * @param id the id
	 * @return the Career
	 */
	public Career getCareer(Long id);
	
	/**
	 * Delete Career.
	 *
	 * @param id the id
	 */
	public void deleteCareer(Long id);
	
	
	public int careerCount();

}

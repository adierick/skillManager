/*
 * File: BusinessUnitService.java
 *
 * Goal: .
 *
 * History:
 * //  Creation of the file (ADI)
 */
package com.springmvc.services;

import java.util.List;

import com.springmvc.bo.BusinessUnit;

/**
 * The Interface BusinessUnitService.
 *
 * @author adi
 * @version 5.1, //2014
 */
public interface BusinessUnitService extends ISearchService<BusinessUnit> {
	
	/**
	 * Update BusinessUnit.
	 *
	 * @param businessUnit the businessUnit
	 */
	public void updateBusinessUnit(BusinessUnit businessUnit);
	
	/**
	 * Liste all BusinessUnits.
	 *
	 * @return the list
	 */
	public List<BusinessUnit> listeAllBusinessUnits();
	public List<BusinessUnit> listeAllBusinessUnits(int rowStart, int numberResults);
	
	/**
	 * Creates the BusinessUnit.
	 *
	 * @param BusinessUnit the BusinessUnit
	 * @return the BusinessUnit
	 */
	public BusinessUnit createBusinessUnit(BusinessUnit businessUnit);
	
	/**
	 * Gets the BusinessUnit.
	 *
	 * @param id the id
	 * @return the BusinessUnit
	 */
	public BusinessUnit getBusinessUnit(Long id);
	
	/**
	 * Delete BusinessUnit.
	 *
	 * @param id the id
	 */
	public void deleteBusinessUnit(Long id);
	
	
	public int businessUnitCount();

}

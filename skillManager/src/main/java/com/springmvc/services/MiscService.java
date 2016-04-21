package com.springmvc.services;

import java.util.List;

import com.springmvc.bo.MISC;


// TODO: Auto-generated Javadoc
/**
 * The Interface MiscService.
 *
 * @author adierick.ext
 */
public interface MiscService  {
	
	/**
	 * Update misc.
	 *
	 * @param MISC the misc
	 */
	public void updateMISC(MISC MISC);
	
	/**
	 * Liste all mis cs.
	 *
	 * @return the list
	 */
	public List<MISC> listeAllMISCs();
	
	/**
	 * Liste all mis cs.
	 *
	 * @param rowStart the row start
	 * @param numberResults the number results
	 * @return the list
	 */
	public List<MISC> listeAllMISCs(int rowStart, int numberResults);
	
	/**
	 * Creates the misc.
	 *
	 * @param MISC the misc
	 * @return the misc
	 */
	public MISC createMISC(MISC MISC);
	
	/**
	 * Gets the misc.
	 *
	 * @param id the id
	 * @return the misc
	 */
	public MISC getMISC(Long id);
	
	/**
	 * Delete misc.
	 *
	 * @param id the id
	 */
	public void deleteMISC(Long id);
	
	
	/**
	 * MISC count.
	 *
	 * @return the int
	 */
	public int MISCCount();

}

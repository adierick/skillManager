package com.springmvc.services;

import java.util.List;

import com.springmvc.bo.Position;

/**
 * The Interface PositionService.
 *
 * @author adi
 * @version 5.1, //2014
 */
public interface PositionService extends ISearchService<Position> {
	
	/**
	 * Update Position.
	 *
	 * @param position the position
	 */
	public void updatePosition(Position position);
	
	/**
	 * Liste all Positions.
	 *
	 * @return the list
	 */
	public List<Position> listeAllPositions();
	public List<Position> listeAllPositions(int rowStart, int numberResults);
	
	/**
	 * Creates the Position.
	 *
	 * @param Position the Position
	 * @return the Position
	 */
	public Position createPosition(Position position);
	
	/**
	 * Gets the Position.
	 *
	 * @param id the id
	 * @return the Position
	 */
	public Position getPosition(Long id);
	
	/**
	 * Delete Position.
	 *
	 * @param id the id
	 */
	public void deletePosition(Long id);
	
	
	public int positionCount();

}

/*
 * File: ItemService.java
 *
 * Goal: .
 *
 * History:
 * //  Creation of the file (ADI)
 */
package com.springmvc.services;

import java.util.List;

import com.springmvc.bo.Category;
import com.springmvc.bo.Item;

/**
 * The Interface ItemService.
 *
 * @author fxd
 * @version 5.1, //2014
 */
public interface ItemService extends ISearchService<Item> {
	
	/**
	 * Update Item.
	 *
	 * @param item the item
	 */
	public void updateItem(Item item);
	
	/**
	 * Liste all Items.
	 *
	 * @return the list
	 */
	public List<Item> listeAllItems();
	public List<Item> listeAllItems(int rowStart, int numberResults);
		

	/**
	 * Liste all Items ordered by category.
	 *
	 * @return the list
	 */
	public List<Item> listeAllItemsOrderByCategory();
	
	/**
	 * Creates the Item.
	 *
	 * @param Item the Item
	 * @return the Item
	 */
	public Item createItem(Item item);
	
	/**
	 * Gets the Item.
	 *
	 * @param id the id
	 * @return the Item
	 */
	public Item getItem(Long id);
	public Item getItem(String code);
	
	/**
	 * Delete Item.
	 *
	 * @param id the id
	 */
	public void deleteItem(Long id);
	
	
	public int itemCount();
	
	public List<Item> listeItemsFromCategory(Category category);

	public void mergeItem(Item item);
}

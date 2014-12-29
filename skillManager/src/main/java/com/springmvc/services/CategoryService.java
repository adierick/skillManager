package com.springmvc.services;

import java.util.List;

import com.springmvc.bo.Category;
import com.springmvc.bo.Item;

public interface CategoryService extends ISearchService<Category> {
	
	/**
	 * Update Category.
	 *
	 * @param category the category
	 */
	public void updateCategory(Category category);
	
	/**
	 * List all Categories.
	 *
	 * @return the list
	 */
	public List<Category> listeAllCategories();
	public List<Category> listeAllCategories(int rowStart, int numberResults);
	
	/**
	 * Creates the Category.
	 *
	 * @param Category the Category
	 * @return the Category
	 */
	public Category createCategory(Category category);
	
	/**
	 * Gets the Category.
	 *
	 * @param id the id
	 * @return the Category
	 */
	public Category getCategory(Long id);
	public Category getCategory(String code);
	
	/**
	 * Delete Category.
	 *
	 * @param id the id
	 */
	public void deleteCategory(Long id);
	
	
	public int categoryCount();
	
}

/*
 * File: ItemServiceImpl.java
 *
 * Goal: .
 *
 * History:
 * //  Creation of the file (ADI)
 */
package com.springmvc.services.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.bo.Category;
import com.springmvc.bo.Item;
import com.springmvc.services.ItemService;
import com.springmvc.services.Service;

/**
 * The Class ItemServiceImpl.
 *
 * @author fxd
 * @version 5.1, //2014
 */
@Component
@Transactional
public class ItemServiceImpl extends Service implements ItemService {

		
	/* (non-Javadoc)
	 * @see com.springmvc.services.ItemService#updateItem(com.springmvc.bo.Item)
	 */
	@Override
	public void updateItem(Item item) {
		getSession().update(item);
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.ItemService#listeAllItems()
	 */
	@Override
	public List<Item> listeAllItems() {
		return getSession().createQuery(" from Item").list();
	}
	
	@Override
	public List<Item> listeAllItems(Category category) {
		return getSession().getNamedQuery("findItemByCategory").setEntity("category", category).list();
	}	

	/* (non-Javadoc)
	 * @see com.springmvc.services.ItemService#createItem(com.springmvc.bo.Item)
	 */
	@Override
	public Item createItem(Item item) {
		getSession().save(item);
		return item;
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.ItemService#getItem(java.lang.Long)
	 */
	@Override
	public Item getItem(Long id) {
		return (Item) getSession().get(Item.class, id);
	}
	@Override
	public Item getItem(String code) {
		Criteria sqlCriteria = getSession().createCriteria(Item.class);
		sqlCriteria.add(Restrictions.eq("code", code)); 
		return (Item) sqlCriteria.list().get(0);
	}
	
	/* (non-Javadoc)
	 * @see com.springmvc.services.ItemService#deleteItem(java.lang.Long)
	 */
	@Override
	public void deleteItem(Long id) {
		getSession().delete(getItem(id));
	}
	
	/**
	 * Find.
	 *
	 * @param criteria the criteria
	 * @return the list
	 */
	@Override
	public List<Item> find(String criteria) {
		Criteria sqlCriteria = getSession().createCriteria(Item.class);
		sqlCriteria.add(Restrictions.like("code", "%"+criteria+"%"));
		sqlCriteria.setFetchMode("skills", FetchMode.JOIN);
		return sqlCriteria.list();
	}
	
	/* (non-Javadoc)
	 * @see com.springmvc.services.ItemService#find(java.lang.String, int, int)
	 */
	@Override
	public List<Item> find(String criteria, int rowStart, int numberResults) {
		Criteria sqlCriteria = getSession().createCriteria(Item.class);
		sqlCriteria.add(
				Restrictions.or(
						Restrictions.like("code", "%"+criteria+"%"), 
						Restrictions.like("trs_label_key", "%"+criteria+"%")));
		
		sqlCriteria.setFirstResult(rowStart * numberResults);
		sqlCriteria.setMaxResults(numberResults);
		
		return sqlCriteria.list();
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.ItemService#listeAllItems(int, int)
	 */
	@Override
	public List<Item> listeAllItems(int rowStart, int numberResults) {
		
		Criteria sqlCriteria = getSession().createCriteria(Item.class);
		sqlCriteria.setFirstResult(rowStart * numberResults);
		sqlCriteria.setMaxResults(numberResults);
		
		return sqlCriteria.list();
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.ItemService#itemCount()
	 */
	@Override
	public int itemCount() {
		Criteria sqlCriteria = getSession().createCriteria(Item.class);
		
		return sqlCriteria.list().size(); 
	}

	@Override
	public void mergeItem(Item item) {
		getSession().merge(item);
	}

}

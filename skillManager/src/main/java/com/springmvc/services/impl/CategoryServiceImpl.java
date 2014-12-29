package com.springmvc.services.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.bo.Category;
import com.springmvc.bo.Item;
import com.springmvc.services.CategoryService;
import com.springmvc.services.Service;

@Component
@Transactional
public class CategoryServiceImpl extends Service implements CategoryService {

		
	/* (non-Javadoc)
	 * @see com.springmvc.services.CategoryService#updateCategory(com.springmvc.bo.Category)
	 */
	public void updateCategory(Category category) {
		getSession().update(category);
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.CategoryService#listeAllCategorys()
	 */
	public List<Category> listeAllCategories() {
		return getSession().createQuery(" from Category").list();
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.CategoryService#createCategory(com.springmvc.bo.Category)
	 */
	public Category createCategory(Category category) {
		getSession().save(category);
		return category;
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.CategoryService#getCategory(java.lang.Long)
	 */
	public Category getCategory(Long id) {
		return (Category) getSession().get(Category.class, id);
	}
	public Category getCategory(String code) {
		Criteria sqlCriteria = getSession().createCriteria(Category.class);
		sqlCriteria.add(Restrictions.eq("code", code)); 
		return (Category) sqlCriteria.list().get(0);
	}
	
	/* (non-Javadoc)
	 * @see com.springmvc.services.CategoryService#deleteCategory(java.lang.Long)
	 */
	public void deleteCategory(Long id) {
		getSession().delete(getCategory(id));
	}
	
	/**
	 * Find.
	 *
	 * @param criteria the criteria
	 * @return the list
	 */
	public List<Category> find(String criteria) {
		Criteria sqlCriteria = getSession().createCriteria(Category.class);
		sqlCriteria.add(Restrictions.like("code", "%"+criteria+"%"));
		//sqlCriteria.setFetchMode("items", FetchMode.JOIN);
		return sqlCriteria.list();
	}
	
	/* (non-Javadoc)
	 * @see com.springmvc.services.CategoryService#find(java.lang.String, int, int)
	 */
	public List<Category> find(String criteria, int rowStart, int numberResults) {
		Criteria sqlCriteria = getSession().createCriteria(Category.class);
		sqlCriteria.add(
				Restrictions.or(
						Restrictions.like("code", "%"+criteria+"%"), 
						Restrictions.like("trs_label_key", "%"+criteria+"%")));
		
		sqlCriteria.setFirstResult(rowStart * numberResults);
		sqlCriteria.setMaxResults(numberResults);
		
		return sqlCriteria.list();
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.CategoryService#listeAllCategorys(int, int)
	 */
	public List<Category> listeAllCategories(int rowStart, int numberResults) {
		
		Criteria sqlCriteria = getSession().createCriteria(Category.class);
		sqlCriteria.setFirstResult(rowStart * numberResults);
		sqlCriteria.setMaxResults(numberResults);
		
		return sqlCriteria.list();
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.CategoryService#categoryCount()
	 */
	public int categoryCount() {
		Criteria sqlCriteria = getSession().createCriteria(Category.class);
		
		return sqlCriteria.list().size(); 
	}


}

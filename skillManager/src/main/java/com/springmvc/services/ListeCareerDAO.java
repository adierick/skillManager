package com.springmvc.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.springmvc.bo.Career;


@Repository
public class ListeCareerDAO implements ICareerDAO{
	
	@PersistenceContext
	private EntityManager entityManager;
	public List<Career> listeCareer() {
		// TODO Auto-generated method stub
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Career> lCriteriaQuery = lCriteriaBuilder.createQuery(Career.class);
		final Root<Career> lRoot = lCriteriaQuery.from(Career.class);
		lCriteriaQuery.select(lRoot);
		final TypedQuery<Career> lTypeQuery = entityManager.createQuery(lCriteriaQuery);
		return lTypeQuery.getResultList();
	}
}

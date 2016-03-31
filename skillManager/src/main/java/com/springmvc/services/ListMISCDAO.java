package com.springmvc.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.springmvc.bo.MISC;

@Repository
public class ListMISCDAO implements IMISCDAO{
	private EntityManager entityManager;
	@Override
	public List<MISC> listeMISC() {
		// TODO Auto-generated method stub
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<MISC> lCriteriaQuery = lCriteriaBuilder.createQuery(MISC.class);
		final Root<MISC> lRoot = lCriteriaQuery.from(MISC.class);
		lCriteriaQuery.select(lRoot);
		final TypedQuery<MISC> lTypeQuery = entityManager.createQuery(lCriteriaQuery);
		return lTypeQuery.getResultList();
	}

}

package com.springmvc.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.springmvc.bo.Remuneration;

@Repository
public class ListeRemunerationDAO implements IRemunerationDAO{
	private EntityManager entityManager;
	@Override
	public List<Remuneration> listeRemuneration() {
		// TODO Auto-generated method stub
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Remuneration> lCriteriaQuery = lCriteriaBuilder.createQuery(Remuneration.class);
		final Root<Remuneration> lRoot = lCriteriaQuery.from(Remuneration.class);
		lCriteriaQuery.select(lRoot);
		final TypedQuery<Remuneration> lTypeQuery = entityManager.createQuery(lCriteriaQuery);
		return lTypeQuery.getResultList();
	}
}

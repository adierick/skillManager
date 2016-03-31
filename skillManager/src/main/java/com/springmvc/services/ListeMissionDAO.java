package com.springmvc.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.springmvc.bo.Mission;

@Repository
public class ListeMissionDAO implements IMissionDAO {

		private EntityManager entityManager;
	@Override
	public List<Mission> listeMission() {
		// TODO Auto-generated method stub
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Mission> lCriteriaQuery = lCriteriaBuilder.createQuery(Mission.class);
		final Root<Mission> lRoot = lCriteriaQuery.from(Mission.class);
		lCriteriaQuery.select(lRoot);
		final TypedQuery<Mission> lTypeQuery = entityManager.createQuery(lCriteriaQuery);
		return lTypeQuery.getResultList();
	}

}

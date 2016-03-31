package com.springmvc.services;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import com.springmvc.bo.Person;
import com.springmvc.bo.Position;

@Repository
public class ListeCollabDAO implements IListeCollabDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7255205848338937723L;
	@PersistenceContext
	private EntityManager entityManager;
	public List<Person> rechercherCollab() {
		// TODO Auto-generated method stub
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Person> lCriteriaQuery = lCriteriaBuilder.createQuery(Person.class);
		final Root<Person> lRoot = lCriteriaQuery.from(Person.class);
		lCriteriaQuery.select(lRoot);
		final TypedQuery<Person> lTypeQuery = entityManager.createQuery(lCriteriaQuery);
		return lTypeQuery.getResultList();
	}

	public List<Position> listePosition(){
		final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Position> lCriteriaQuery = lCriteriaBuilder.createQuery(Position.class);
		final Root<Position> lRoot = lCriteriaQuery.from(Position.class);
		lCriteriaQuery.select(lRoot);
		final TypedQuery<Position> lTypeQuery = entityManager.createQuery(lCriteriaQuery);
		return lTypeQuery.getResultList();
	}
}
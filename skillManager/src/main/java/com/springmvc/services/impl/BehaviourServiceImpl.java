package com.springmvc.services.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.bo.Behaviour;
import com.springmvc.services.BehaviourService;
import com.springmvc.services.Service;

@Component
@Transactional
public class BehaviourServiceImpl extends Service implements BehaviourService {

	public List<Behaviour> find(String criteria, int rowStart, int numberResults) {
		Criteria sqlCriteria = getSession().createCriteria(Behaviour.class);
		sqlCriteria.setFirstResult(rowStart * numberResults);
		sqlCriteria.setMaxResults(numberResults);

		return sqlCriteria.list();
	}

	public Collection<Behaviour> find(String criteria) {
		Criteria sqlCriteria = getSession().createCriteria(Behaviour.class);
		return sqlCriteria.list();
	}

	public void updateBehaviour(Behaviour behaviour) {
		getSession().update(behaviour);
	}

	public List<Behaviour> listeAllBehaviours() {
		return getSession().createQuery("from Behaviour").list();
	}

	public List<Behaviour> listeAllBehaviours(int rowStart, int numberResults) {
		Criteria sqlCriteria = getSession().createCriteria(Behaviour.class);
		sqlCriteria.setFirstResult(rowStart * numberResults);
		sqlCriteria.setMaxResults(numberResults);

		return sqlCriteria.list();
	}

	public Behaviour createBehaviour(Behaviour behaviour) {
		getSession().save(behaviour);
		return behaviour;
	}

	public Behaviour getBehaviour(Long id) {
		Criteria sqlCriteria = getSession().createCriteria(Behaviour.class);
		sqlCriteria.add(Restrictions.eq("idBehavioralCompetence", id)); 
		return (Behaviour) sqlCriteria.list().get(0);
	}

	public void deleteBehaviour(Long id) {
		getSession().delete(getBehaviour(id));
		
	}

	public int behaviourCount() {
		Criteria sqlCriteria = getSession().createCriteria(Behaviour.class);

		return sqlCriteria.list().size(); 
	}

}

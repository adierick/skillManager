/*
 * File: SkillServiceImpl.java
 *
 * Goal: .
 *
 * History:
 * //  Creation of the file (ADI)
 */
package com.springmvc.services.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.bo.Person;
import com.springmvc.bo.Skill;
import com.springmvc.services.Service;
import com.springmvc.services.SkillService;

/**
 * The Class SkillServiceImpl.
 *
 * @author fxd
 * @version 5.1, //2014
 */
@Component
@Transactional
public class SkillServiceImpl extends Service implements SkillService {

		
	/* (non-Javadoc)
	 * @see com.springmvc.services.SkillService#updateSkill(com.springmvc.bo.Skill)
	 */
	public void updateSkill(Skill skill) {
		getSession().update(skill);
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.SkillService#listeAllSkills()
	 */
	public List<Skill> listeAllSkills() {
		return getSession().createQuery(" from Skill").list();
	}
	public List<Skill> listeAllSkills(Person person) {
		return getSession().getNamedQuery("findSkillByPerson").setEntity("person", person).list();
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.SkillService#createSkill(com.springmvc.bo.Skill)
	 */
	public Skill createSkill(Skill skill) {
		getSession().save(skill);
		return skill;
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.SkillService#getSkill(java.lang.Long)
	 */
	public Skill getSkill(Long id) {
		return (Skill) getSession().get(Skill.class, id);
	}
	
	/* (non-Javadoc)
	 * @see com.springmvc.services.SkillService#deleteSkill(java.lang.Long)
	 */
	public void deleteSkill(Long id) {
		getSession().delete(getSkill(id));
	}
	
	/**
	 * Find.
	 *
	 * @param criteria the criteria
	 * @return the list
	 */
	public List<Skill> find(String criteria) {
		Criteria sqlCriteria = getSession().createCriteria(Skill.class);
		return sqlCriteria.list();
	}
	
	public List<Skill> findAll(String criteria) {
		Criteria sqlCriteria = getSession().createCriteria(Skill.class);
		sqlCriteria.createAlias( "person", "person" );
		sqlCriteria.createAlias( "person.bu", "bu" );
		sqlCriteria.add(
				 Restrictions.disjunction()
                 	.add(Restrictions.like("person.matricule", "%"+criteria+"%"))
                 	.add(Restrictions.like("person.login", "%"+criteria+"%"))
					.add(Restrictions.like("person.firstname", "%"+criteria+"%"))
					.add(Restrictions.like("person.lastname", "%"+criteria+"%"))
					.add(Restrictions.like("bu.label", "%"+criteria+"%"))
					);
		return sqlCriteria.list();
	}
	
	/* (non-Javadoc)
	 * @see com.springmvc.services.SkillService#find(java.lang.String, int, int)
	 */
	public List<Skill> find(String criteria, int rowStart, int numberResults) {
		Criteria sqlCriteria = getSession().createCriteria(Skill.class);
		
		sqlCriteria.setFirstResult(rowStart * numberResults);
		sqlCriteria.setMaxResults(numberResults);
		
		return sqlCriteria.list();
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.SkillService#listeAllSkills(int, int)
	 */
	public List<Skill> listeAllSkills(int rowStart, int numberResults) {
		
		Criteria sqlCriteria = getSession().createCriteria(Skill.class);
		sqlCriteria.setFirstResult(rowStart * numberResults);
		sqlCriteria.setMaxResults(numberResults);
		
		return sqlCriteria.list();
	}

	/* (non-Javadoc)
	 * @see com.springmvc.services.SkillService#skillCount()
	 */
	public int skillCount() {
		Criteria sqlCriteria = getSession().createCriteria(Skill.class);
		
		return sqlCriteria.list().size(); 
	}

}

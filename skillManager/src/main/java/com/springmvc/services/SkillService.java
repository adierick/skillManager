/*
 * File: SkillService.java
 *
 * Goal: .
 *
 * History:
 * //  Creation of the file (ADI)
 */
package com.springmvc.services;

import java.util.Collection;
import java.util.List;

import com.springmvc.bo.Person;
import com.springmvc.bo.Skill;

/**
 * The Interface SkillService.
 *
 * @author fxd
 * @version 5.1, //2014
 */
public interface SkillService extends ISearchService<Skill> {
	
	/**
	 * Update Skill.
	 *
	 * @param skill the skill
	 */
	public void updateSkill(Skill skill);
	
	/**
	 * Liste all Skills.
	 *
	 * @return the list
	 */
	public List<Skill> listeAllSkills();
	public List<Skill> listeAllSkills(Person person);
	public List<Skill> listeAllSkills(int rowStart, int numberResults);
	
	public Collection<Skill> findAll(String criteria);
	
	/**
	 * Creates the Skill.
	 *
	 * @param Skill the Skill
	 * @return the Skill
	 */
	public Skill createSkill(Skill skill);
	
	/**
	 * Gets the Skill.
	 *
	 * @param id the id
	 * @return the Skill
	 */
	public Skill getSkill(Long id);
	
	/**
	 * Delete Skill.
	 *
	 * @param id the id
	 */
	public void deleteSkill(Long id);
	
	
	public int skillCount();
}

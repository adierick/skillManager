package com.springmvc.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.springmvc.bo.Item;
import com.springmvc.bo.Person;
import com.springmvc.bo.Skill;
import com.springmvc.services.ItemService;
import com.springmvc.services.SkillService;

public class SkillUtils {

	/**
	 * Refresh list skill.
	 *
	 * @param person the person
	 * @return 
	 */
	public static List<Skill> refreshListSkill(Person person, SkillService service, ItemService serviceItem) {
		List<Skill> listeSkills = service.listeAllSkills(person);
		
		if(listeSkills!=null){
			List<Long> itemAlreadySkilled = new ArrayList<Long>();
			for (Skill skill: listeSkills) {
				itemAlreadySkilled.add(skill.getItem().getId());
			}
			
			List<Item> items = serviceItem.listeAllItems();
			for (Item item : items) {
				if(!itemAlreadySkilled.contains(item.getId())) {
					Skill newSkill = new Skill(person, item, 0);
					listeSkills.add(newSkill);
				}
			}
		}
		
		Collections.sort(listeSkills);
		return listeSkills;
	}
	public static List<Skill> refreshOnlyAvailableListSkill(Person person, SkillService service, ItemService serviceItem) {
		List<Skill> listeSkills = service.listeAllSkills(person);
		
		if(listeSkills!=null){
			List<Long> itemAlreadySkilled = new ArrayList<Long>();
			for (Skill skill: listeSkills) {
				itemAlreadySkilled.add(skill.getItem().getId());
			}
		}
		
		Collections.sort(listeSkills);
		return listeSkills;
	}
}

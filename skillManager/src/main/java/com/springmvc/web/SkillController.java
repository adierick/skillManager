/*
 * File: SkillController.java
 *
 * Goal: .
 *
 * History:
 * //  Creation of the file (ADI)
 */
package com.springmvc.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.Context;
import com.springmvc.IConstants;
import com.springmvc.bo.Item;
import com.springmvc.bo.Person;
import com.springmvc.bo.Skill;
import com.springmvc.services.ItemService;
import com.springmvc.services.PersonService;
import com.springmvc.services.SkillService;
import com.springmvc.utils.ITranslations;
import com.springmvc.utils.Security;
import com.springmvc.utils.Translation;

/**
 * The Class SkillController.
 *
 * @author adi
 * @version 5.1, //2014
 */
@Controller
@RequestMapping("/skill/*")
public class SkillController {

	/** The liste skills. */
	private List<Skill> listeSkills;
	
	/** The service. */
	private final SkillService service = Context.getInstance().getApplicationContext().getBean(SkillService.class);
	
	/** The service person. */
	private final PersonService servicePerson = Context.getInstance().getApplicationContext().getBean(PersonService.class);
	
	/** The service item. */
	private final ItemService serviceItem = Context.getInstance().getApplicationContext().getBean(ItemService.class);

	/** Constants */
	private static final String SUCCESS_LIST = "skill/listeSkills"; 
	private static final String ERROR_FORWARD = "redirect:"+"/main/login/login.do";
	
	/**
	 * Constructor for skill controller.
	 */
	public SkillController() {
		super();
	} 
	
	/**
	 * Liste skills.
	 *
	 * @param matricule the matricule
	 * @param model the model
	 * @return 
	 */
	@RequestMapping(value="/skill/listeSkills.do")
	public String listeSkills(@RequestParam("matricule") String matricule, Model model, HttpSession session, HttpServletRequest request) throws IOException{
		Security secure = Security.getInstance();
		if (secure.verifyPersoOrAdmin(matricule,session, request)) {
			Person person = servicePerson.getPerson(matricule);
			refreshListSkill(person);
			model.addAttribute("skillsList", listeSkills);
			return SUCCESS_LIST;
		} else {
			return ERROR_FORWARD;
		}

	}
	
	/**
	 * Update person.
	 *
	 * @param matricule the matricule
	 * @param lvl the lvl
	 * @param id the id
	 * @param itemId the item id
	 * @param model the model
	 * @param session the session
	 * @return the string
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	@RequestMapping(value="/skill/updateSkills.do")
	public String updatePerson(@RequestParam("matricule") String matricule, 
			@RequestParam("lvl") String lvl,
			@RequestParam("id") String id, 
			@RequestParam("itemId") String itemId, 
			Model model,
			HttpSession session) throws NumberFormatException {
		
		// get person from matricule
		Person person = servicePerson.getPerson(matricule);
		Person connected = (Person) session.getAttribute(IConstants.USER_SESSION);
		
		Skill skill = null;
		
		// authorized update only for connected user do the update
		if(person.getId().equals(connected.getId())) {
			// get level
			int level = Integer.valueOf(lvl);
			
			// get skill to update
//			if(!id.isEmpty()) {
			if(!(id==null || id.equals(""))) {
				skill = service.getSkill(Long.parseLong(id));
			}
			// create new skill if doesn't exist yet for this item/person
			if(skill==null) {
				skill = new Skill(person, serviceItem.getItem(Long.parseLong(itemId)), level);
			}
			
			// update level
			skill.setLevel(level);
			// update skill
			if(!(id==null || id.equals(""))) {
				service.updateSkill(skill);
			} else {
				service.createSkill(skill);
			}
			
			// update user in session
			session.setAttribute(IConstants.USER_SESSION, person);
		}
		
		// refresh list skill
		refreshListSkill(person);
		model.addAttribute("skillsList", listeSkills);
		
		if(skill!=null) {
			model.addAttribute(IConstants.VALIDATION_MSG, Translation.getInstance().getTranslation(ITranslations.SKILL_DATA_SAVED, new Object[]{skill.getItem().getCode()}));
		}
		
		return SUCCESS_LIST;
	}
	
	/**
	 * Refresh list skill.
	 *
	 * @param person the person
	 */
	private void refreshListSkill(Person person) {
		listeSkills = service.listeAllSkills(person);
		
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
	}
	
}

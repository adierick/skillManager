package com.springmvc.web;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.Context;
import com.springmvc.IConstants;
import com.springmvc.bo.Behaviour;
import com.springmvc.bo.BusinessUnit;
import com.springmvc.bo.Career;
import com.springmvc.bo.MISC;
import com.springmvc.bo.ManagementLevel;
import com.springmvc.bo.Mission;
import com.springmvc.bo.Person;
import com.springmvc.bo.Position;
import com.springmvc.bo.Skill;
import com.springmvc.formdata.BehaviourFormData;
import com.springmvc.formdata.CareerFormData;
import com.springmvc.formdata.MissionFormData;
import com.springmvc.formdata.PersonFormData;
import com.springmvc.services.BehaviourService;
import com.springmvc.services.CareerService;
import com.springmvc.services.ItemService;
import com.springmvc.services.MiscService;
import com.springmvc.services.MissionService;
import com.springmvc.services.PersonService;
import com.springmvc.services.PictureService;
import com.springmvc.services.PositionService;
import com.springmvc.services.SkillService;
import com.springmvc.utils.ITranslations;
import com.springmvc.utils.PersonUtils;
import com.springmvc.utils.Security;
import com.springmvc.utils.SkillUtils;
import com.springmvc.utils.Translation;
import com.springmvc.web.editor.BusinessUnitEditor;
import com.springmvc.web.editor.PersonEditor;
import com.springmvc.web.editor.PositionEditor;

@Controller
@RequestMapping(value="/collaborater/*")
public class CollabController {
	
	private final PersonService servicePerson = Context.getInstance().getApplicationContext().getBean(PersonService.class);
	private final ItemService serviceItem = Context.getInstance().getApplicationContext().getBean(ItemService.class);
	private final PictureService pictureService = Context.getInstance().getApplicationContext().getBean(PictureService.class);
		
	private final SkillService serviceSkill = Context.getInstance().getApplicationContext().getBean(SkillService.class);
	
	private final MiscService miscService = Context.getInstance().getApplicationContext().getBean(MiscService.class);
	private final MissionService missionService = Context.getInstance().getApplicationContext().getBean(MissionService.class);
	private final CareerService careerService = Context.getInstance().getApplicationContext().getBean(CareerService.class);
	private final BehaviourService behaviourService = Context.getInstance().getApplicationContext().getBean(BehaviourService.class);
	private final PositionService positionService = Context.getInstance().getApplicationContext().getBean(PositionService.class);
	
	@RequestMapping(value="/collaborater/listeEmploies.do")
	public String afficher(ModelMap pModel){
		//lancement du service et récupération de données en base pour person
		final List<Person> listCollab = servicePerson.listeAllPersons();
		pModel.addAttribute("listeCollaborateurs", listCollab);
		return "collaborater/listeEmploies";
	}
	
	/**
	 * Person detail.
	 *
	 * @param id the id
	 * @param model the model
	 * @throws IOException 
	 */
	@RequestMapping(method=RequestMethod.GET, value="/collaborater/editionCollaboraterAsManager.do")
	public String personDetailAsManager(@RequestParam("matricule") String matricule, Model model ,HttpSession session, HttpServletRequest request) throws IOException {
		Person person = servicePerson.getPerson(matricule);
		List<Skill> listeSkills = SkillUtils.refreshListSkill(person, serviceSkill, serviceItem);
		model.addAttribute("collabEdition", listeSkills);
		return PersonUtils.loadPersonDetailAsManager(matricule, model, session, request, servicePerson, pictureService);
	}

	@RequestMapping(method=RequestMethod.POST, value="/collaborater/updateMission.do")
	public String updateMission(@ModelAttribute("mission") MissionFormData mission, Model model, HttpSession session, HttpServletRequest request) throws IOException {
		Security secure = Security.getInstance();
		if (secure.verifyLogin(request)) {
			Person person = servicePerson.getPerson(mission.getPersonId());
			
			if(mission!=null && mission.getMission()!=null) {
				Mission missionToSave = mission.getMission();
				missionToSave.setPersons(person);
				
				missionService.createMission(missionToSave);
			}
			
			model.addAttribute(IConstants.VALIDATION_MSG, Translation.getInstance().getTranslation(ITranslations.PERSONNAL_DATA_SAVED));			
			return PersonUtils.loadPersonDetailAsManager(person.getMatricule(), model, session, request, servicePerson, pictureService);

		}
		else return PersonUtils.ERROR_FORWARD;
	}
	@RequestMapping(method=RequestMethod.POST, value="/collaborater/updateCareer.do")
	public String updateMission(@ModelAttribute("career") CareerFormData career, Model model, HttpSession session, HttpServletRequest request) throws IOException {
		Security secure = Security.getInstance();
		if (secure.verifyLogin(request)) {
			Person person = servicePerson.getPerson(career.getPersonId());
			
			if(career!=null && career.getCareer()!=null) {
				Career careerToSave = career.getCareer();
				careerToSave.setPersons(person);
				
				careerService.createCareer(careerToSave);
			}
			
			model.addAttribute(IConstants.VALIDATION_MSG, Translation.getInstance().getTranslation(ITranslations.PERSONNAL_DATA_SAVED));			
			return PersonUtils.loadPersonDetailAsManager(person.getMatricule(), model, session, request, servicePerson, pictureService);
			
		}
		else return PersonUtils.ERROR_FORWARD;
	}

	
	@RequestMapping(method=RequestMethod.POST, value="/collaborater/updateBehaviour.do")
	public String updateBehaviour(@ModelAttribute("behaviour") BehaviourFormData behaviour, Model model, HttpSession session, HttpServletRequest request) throws IOException {
		Security secure = Security.getInstance();
		if (secure.verifyLogin(request)) {
			Person person = servicePerson.getPerson(behaviour.getPersonId());
			
			if(behaviour!=null && behaviour.getBehaviour()!=null) {
				Behaviour behaviourToSave = behaviour.getBehaviour();
				behaviourToSave.setPersones(person);
				
				behaviourService.createBehaviour(behaviourToSave);
			}
			
			model.addAttribute(IConstants.VALIDATION_MSG, Translation.getInstance().getTranslation(ITranslations.PERSONNAL_DATA_SAVED));			
			return PersonUtils.loadPersonDetailAsManager(person.getMatricule(), model, session, request, servicePerson, pictureService);
			
		}
		else return PersonUtils.ERROR_FORWARD;
	}

	@RequestMapping(method=RequestMethod.POST, value="/collaborater/update.do")
	public String updatePerson(@ModelAttribute("person") PersonFormData person, Model model, HttpSession session, HttpServletRequest request) throws IOException {

		Person personForMerge;
		Security secure = Security.getInstance();
		if (secure.verifyLogin(request)) {

			personForMerge = servicePerson.getPerson(person.getPerson().getId());	
			
			/** mise à jour de la table person **/
			personForMerge.setFirstname(person.getPerson().getFirstname());
			personForMerge.setLastname(person.getPerson().getLastname());
			personForMerge.setBirth_date(person.getPerson().getBirth_date());
			personForMerge.setTel(person.getPerson().getTel());
			personForMerge.setHobby(person.getPerson().getHobby());
			personForMerge.setDate_activity_pro(person.getPerson().getDate_activity_pro());
			personForMerge.setDate_entry_sii(person.getPerson().getDate_entry_sii());
			personForMerge.setPosition_coeff(person.getPerson().getPosition_coeff());
			personForMerge.setBu(person.getPerson().getBu());
			personForMerge.setManager_(person.getPerson().getManager_());
			
			/** mise à jour de la table position **/
			personForMerge.setPosition(person.getPerson().getPosition());
			
			/** mise à jour de la table misc associé **/
			MISC misc = null;
			if(personForMerge.getMisc()==null) {
				//create new one
				misc = new MISC(null, person.getPerson().getMisc().getMisc_description(), personForMerge);
				misc = miscService.createMISC(misc);
			} else {
				misc = miscService.getMISC(personForMerge.getMisc().getIdactivity_prestation());
				misc.setMisc_description(person.getPerson().getMisc().getMisc_description());
//				personForMerge.getMisc().setMisc_description(person.getPerson().getMisc().getMisc_description());
				miscService.updateMISC(misc);
			}
			
			personForMerge.setMisc(misc);
			
			Person personMerged = servicePerson.mergePerson(personForMerge);

			model.addAttribute(IConstants.VALIDATION_MSG, Translation.getInstance().getTranslation(ITranslations.PERSONNAL_DATA_SAVED));			
			return PersonUtils.loadPersonDetailAsManager(personMerged.getMatricule(), model, session, request, servicePerson, pictureService);

		}
		else return PersonUtils.ERROR_FORWARD;

	}
	
	
	@ModelAttribute("listBu")
	public Collection<BusinessUnit> populateBusinessUnit() {
		return servicePerson.listeAllBusinessUnits();
	}
	
	@ModelAttribute("listManagement")
	public List<ManagementLevel> managementLevel() {
	        return Arrays.asList(ManagementLevel.values());
	}

	@ModelAttribute("listManager")
	public Collection<Person> populateManager() {
		return servicePerson.getManagerList();
	}
	
	@ModelAttribute("listPosition")
	public Collection<Position> populatePosition() {
		return positionService.listeAllPositions();
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.registerCustomEditor(BusinessUnit.class, new BusinessUnitEditor());
		dataBinder.registerCustomEditor(Person.class, new PersonEditor());
		dataBinder.registerCustomEditor(Position.class, new PositionEditor());
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd-MM-yyyy"), true));
	}
	
}
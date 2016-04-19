package com.springmvc.web;


import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.springmvc.bo.BusinessUnit;
import com.springmvc.bo.Person;
import com.springmvc.bo.Remuneration;
import com.springmvc.bo.Skill;
import com.springmvc.formdata.PersonFormData;
import com.springmvc.services.ItemService;
import com.springmvc.services.PersonService;
import com.springmvc.services.PictureService;
import com.springmvc.services.ServiceRemuneration;
import com.springmvc.services.SkillService;
import com.springmvc.utils.ITranslations;
import com.springmvc.utils.PersonUtils;
import com.springmvc.utils.Security;
import com.springmvc.utils.SkillUtils;
import com.springmvc.utils.Translation;
import com.springmvc.web.editor.BusinessUnitEditor;

@Controller
@RequestMapping(value="/collaborater/*")
public class CollabController {
//	public List<Person> listePersons;
//	public List<Mission> listeMission;
//	public List<Remuneration> listeRemuneration;
//	public List<Career> listeCareer;
//	public List<MISC> listMISC;
	//@Autowired
	//private IServiceListCollab service;
	
	private final PersonService servicePerson = Context.getInstance().getApplicationContext().getBean(PersonService.class);
	private final ItemService serviceItem = Context.getInstance().getApplicationContext().getBean(ItemService.class);
	private final PictureService pictureService = Context.getInstance().getApplicationContext().getBean(PictureService.class);
		
	private final SkillService serviceSkill = Context.getInstance().getApplicationContext().getBean(SkillService.class);
//	private final ServiceMission serviceMission = Context.getInstance().getApplicationContext().getBean(ServiceMission.class);
	private final ServiceRemuneration serviceRemuneration = Context.getInstance().getApplicationContext().getBean(ServiceRemuneration.class);
//	private final ServiceCareer serviceCareer = Context.getInstance().getApplicationContext().getBean(ServiceCareer.class);
//	private final ServiceMISC serviceMISC = Context.getInstance().getApplicationContext().getBean(ServiceMISC.class);

	@RequestMapping(value="/collaborater/listeEmploies.do")
//	@RequestMapping(method = RequestMethod.GET)
	public String afficher(ModelMap pModel){
		//lancement du service et récupération de données en base pour person
		final List<Person> listCollab = servicePerson.listeAllPersons();
		pModel.addAttribute("listeCollaborateurs", listCollab);
		return "collaborater/listeEmploies";
	}
	
	/*
	@RequestMapping(value="/collaborater/editionCHFR.do")
	public String afficherRMCA(ModelMap pModel){
		//lancement du service et récupération de données en base pour person
		return "collaborater/CHFR";
	}
*/	
/*	
	@RequestMapping(method=RequestMethod.GET, value="/collaborater/editionCollaborater.do")
	public String personDetail(@RequestParam("matricule") String matricule, Model model ,HttpSession session, HttpServletRequest request) throws IOException {
		boolean isManager = Security.getInstance().verifyManager(session, request);
		
		Person collabEdition = servicePerson.getPerson(matricule);
		//List<Skill> listeSkills = SkillUtils.refreshListSkill(person, serviceSkill, serviceItem);
		
		model.addAttribute("collabEdition", collabEdition);
		
		if (isManager) {
			return PersonUtils.loadPersonDetailAsManager(matricule, model, session, request, servicePerson, pictureService);
		}
		return PersonUtils.loadPersonDetail(matricule, model, session, request, servicePerson, pictureService);
	}
*/

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
//		List<Remuneration> listRemuneration = serviceRemuneration.listeAllRemuneration();
//		model.addAttribute("listeRemunerations", listRemuneration);
		return PersonUtils.loadPersonDetailAsManager(matricule, model, session, request, servicePerson, pictureService);
	}

	@RequestMapping(value="/collaborater/RMCA.do")
	public String AfficherRMCA(ModelMap pModel){
//		final List<Remuneration> listRemuneration = serviceRemuneration.listeAllRemuneration();
//		pModel.addAttribute("listeRemunerations", listRemuneration);
//		final List<Mission> listMission = serviceMission.listeAllMission();
//		pModel.addAttribute("listeMissions", listMission);
//		final List<Career> listCareer = serviceCareer.listeAllCareer();
//		pModel.addAttribute("listeCareers", listCareer);
//		final List<MISC> listMISC = serviceMISC.listeAllMISC();
//		pModel.addAttribute("listeMISC", listMISC);
		return "collaborater/RMCA";
	}

	@RequestMapping(value="/collaborater/CHFR.do")
	public String AfficherCHFR(ModelMap pModel){
//		final List<Behaviour> listBehaviour = service.listeAllBehaviour();
//		pModel.addAttribute("listeBehaviours", listBehaviour);
//		final List<History_MGT> listHistoryMGT = service.listeHistory_MGT();
//		pModel.addAttribute("listeHistory_MGT", listHistoryMGT);
//		final List<Formation> listFormation = service.listeAllFormation();
//		pModel.addAttribute("listeFormations", listFormation);
//		final List<Remarks> listRemarks = service.listeAllRemarks();
//		pModel.addAttribute("listeRemarks", listRemarks);
		return "collaborater/CHFR";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/collaborater/update.do")
	public String updatePerson(@ModelAttribute("person") PersonFormData person, Model model, HttpSession session, HttpServletRequest request) throws IOException {

		Person personForMerge;
		Security secure = Security.getInstance();
		if (secure.verifyLogin(request)) {

			personForMerge = servicePerson.getPerson(person.getPerson().getId());	
			
			personForMerge.setFirstname(person.getPerson().getFirstname());
			personForMerge.setLastname(person.getPerson().getLastname());
//			personForMerge.setBirth_date(person.getPerson().getBirth_date());
			personForMerge.setTel(person.getPerson().getTel());
			personForMerge.setHobby(person.getPerson().getHobby());
//			personForMerge.setDate_activity_pro(person.getPerson().getDate_activity_pro());
//			personForMerge.setDate_entry_sii(person.getPerson().getDate_entry_sii());
			personForMerge.setPosition_coeff(person.getPerson().getPosition_coeff());
//			personForMerge.setMissions(person.getPerson().getMissions());
//			personForMerge.setPosition(person.getPerson().getPosition());
//			personForMerge.setManager_(person.getPerson().getManager_());
//			personForMerge.setBu(person.getPerson().getBu());
//			personForMerge.setMisc(person.getPerson().getMisc());
			
			// mmisc = iscService.getMisc(id);
			// misc.setDescr(...);
			// miscService.merge(misc);
			
			personForMerge.getMisc().setMisc_description(person.getPerson().getMisc().getMisc_description());
			
			Person personMerged = servicePerson.mergePerson(personForMerge);

			model.addAttribute(IConstants.VALIDATION_MSG, Translation.getInstance().getTranslation(ITranslations.PERSONNAL_DATA_SAVED));			
			return PersonUtils.loadPersonDetailAsManager(personMerged.getMatricule(), model, session, request, servicePerson, pictureService);

		}
		else return PersonUtils.ERROR_FORWARD;

	}
	
//	@RequestMapping(method=RequestMethod.POST, value="/collaborater/updateMission.do")
//	public String updateMission(@ModelAttribute("mission") MissionFormData mission, Model model, HttpSession session, HttpServletRequest request) throws IOException {
//
//		Mission missionForMerge;
//		Security secure = Security.getInstance();
//		if (secure.verifyLogin(request)) {
//			
//			missionForMerge = serviceMission.getMission(mission.getMission().getIdmission());
//			
//			missionForMerge.setEntitedMission(mission.getMission().getEntitedMission());
//			
//			Mission missionForMerged = serviceMission.mergeMission(missionForMerge);
//	
//			model.addAttribute(IConstants.VALIDATION_MSG, Translation.getInstance().getTranslation(ITranslations.PERSONNAL_DATA_SAVED));
//		
//			return "collaborater/editionMission";
//
//		}
//		else return "collaborater/listeEmploies";
//	}
	
	
	
	@ModelAttribute("listBu")
	public Collection<BusinessUnit> populateBusinessUnit() {
		return servicePerson.listeAllBusinessUnits();
	}
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.registerCustomEditor(BusinessUnit.class, new BusinessUnitEditor());
	}
	
}
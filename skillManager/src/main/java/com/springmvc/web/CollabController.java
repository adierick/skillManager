package com.springmvc.web;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.Context;
import com.springmvc.bo.Career;
import com.springmvc.bo.MISC;
import com.springmvc.bo.Mission;
import com.springmvc.bo.Person;
import com.springmvc.bo.Remuneration;
import com.springmvc.services.PersonService;

@Controller
@RequestMapping(value="/collaborater/*")
public class CollabController {
	public List<Person> listePersons;
	public List<Mission> listeMission;
	public List<Remuneration> listeRemuneration;
	public List<Career> listeCareer;
	public List<MISC> listMISC;
	//@Autowired
	//private IServiceListCollab service;
	
	private final PersonService servicePerson = Context.getInstance().getApplicationContext().getBean(PersonService.class);
//	private final MissionService serviceMission = Context.getInstance().getApplicationContext().getBean(MissionService.class);
//	private final RemunerationService serviceRemuneration = Context.getInstance().getApplicationContext().getBean(RemunerationService.class);
//	private final CareerService serviceCareer = Context.getInstance().getApplicationContext().getBean(CareerService.class);
//	private final MISCService serviceMISC = Context.getInstance().getApplicationContext().getBean(MISCService.class);

	@RequestMapping(value="/collaborater/listeEmploies.do")
//	@RequestMapping(method = RequestMethod.GET)
	public String afficher(ModelMap pModel){
		//lancement du service et récupération de données en base pour person
		final List<Person> listCollab = servicePerson.listeAllPersons();
		pModel.addAttribute("listeCollaborateurs", listCollab);
		return "collaborater/listeEmploies";
		
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

}
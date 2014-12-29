/*
 * File: PersonController.java
 *
 * Goal: .
 *
 * History:
 * //  Creation of the file (ADI)
 */
package com.springmvc.web;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
import com.springmvc.formdata.PersonFormData;
import com.springmvc.formdata.PersonFormDataAdmin;
import com.springmvc.services.PersonService;
import com.springmvc.utils.ITranslations;
import com.springmvc.utils.MyBlowfish;
import com.springmvc.utils.Security;
import com.springmvc.utils.Translation;
import com.springmvc.web.editor.BusinessUnitEditor;

/**
 * The Class PersonController.
 *
 * @author adi
 * @version 5.1, //2014
 */
@Controller
@RequestMapping("/person/*")
public class PersonController {

	/** The liste persons. */
	private List<Person> listePersons;
	
	/** The service. */
	private PersonService service = (PersonService) Context.getInstance().getApplicationContext().getBean(PersonService.class);

	private static final String ERROR_FORWARD = "redirect:"+"/main/login/login.do";
	private static final String SUCCESS_LIST = "person/listePersons";
	/** Modification view for admin*/
	private static final String SUCCESS_EDIT = "person/editionPerson";
	/** Modification view for collaborator (restrict field)*/
	private static final String SUCCESS_COLAB_EDIT= "person/editionPersonCollab";
	
	/**
	 * Constructor for person controller.
	 */
	public PersonController() {
		super();
	} 
	
	/**
	 * Liste persons.
	 *
	 * @param model the model
	 * @throws IOException 
	 */
	@RequestMapping(value="/person/listePersons.do")
	public String listePersons(Model model, HttpSession session, HttpServletRequest request) throws IOException{

		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {
			listePersons = service.listeAllPersons();
			model.addAttribute("personsList", listePersons);
			
			return SUCCESS_LIST;
		} else {
			return ERROR_FORWARD;
		}
	}
	
	/**
	 * Person detail.
	 *
	 * @param id the id
	 * @param model the model
	 * @throws IOException 
	 */
	@RequestMapping(method=RequestMethod.GET, value="/person/editionPerson.do")
	public String personDetail(@RequestParam("matricule") String matricule, Model model ,HttpSession session, HttpServletRequest request) throws IOException {

		Security secure = Security.getInstance();
		if (secure.verifyPersoOrAdmin(matricule, session, request)){
			Person personForForm = service.getPerson(matricule);
			model.addAttribute("person", new PersonFormData(personForForm));
			model.addAttribute("type", "update");
			session.setAttribute(IConstants.ID_COLLAB, personForForm.getId());
			return SUCCESS_COLAB_EDIT;
		} else {
			return ERROR_FORWARD;
		}
		
		
	}
	
	/**
	 * Person detail.
	 *
	 * @param id the id
	 * @param model the model
	 * @throws IOException 
	 */
	@RequestMapping(method=RequestMethod.GET, value="/person/editionPersonAsAdmin.do")
	public String personDetailAsAdmin(@RequestParam("matricule") String matricule, Model model ,HttpSession session, HttpServletRequest request) throws IOException {

		Security secure = Security.getInstance();
		if (secure.verifyPersoOrAdmin(matricule, session, request)){
			Person personForForm = service.getPerson(matricule);
			model.addAttribute("person", new PersonFormData(personForForm));
			model.addAttribute("type", "update");
			session.setAttribute(IConstants.ID_COLLAB, personForForm.getId());
			if(secure.verifyAdmin(session, request)){
				return SUCCESS_EDIT;
			}else{
				return ERROR_FORWARD;
			}
		} else {
			return ERROR_FORWARD;
		}
		
		
	}
	
	/**
	 * Update person.
	 *
	 * @param person the person
	 * @param model the model
	 * @return the string
	 * @throws IOException 
	 */
	@RequestMapping(method=RequestMethod.POST, value="/person/update.do")
	public String updatePerson(@ModelAttribute("person") @Valid PersonFormData person, BindingResult binding, Model model, HttpSession session, HttpServletRequest request) throws IOException {
		
		Person personForMerge;
		Security secure = Security.getInstance();
		if (secure.verifyLogin(request)) {
			
			if(binding.hasErrors()) {
				model.addAttribute("type", "update");
				return SUCCESS_COLAB_EDIT;	
			}else{
				personForMerge = service.getPerson((Long)session.getAttribute(IConstants.ID_COLLAB));
			}
			
			MyBlowfish bf = new MyBlowfish();
		    bf.setSecretKey(IConstants.CRYPT_PWD);
		    personForMerge.setPassword(new BigInteger(bf.crypt(person.getFirstPassword())).toString());
			Person personMerged = service.mergePerson(personForMerge);
			session.setAttribute(IConstants.USER_SESSION, personMerged);	
			
			model.addAttribute(IConstants.VALIDATION_MSG, Translation.getInstance().getTranslation(ITranslations.PERSONNAL_DATA_SAVED));
			return SUCCESS_COLAB_EDIT;

		}
		else return ERROR_FORWARD;

	}
	
	/**
	 * @param person
	 * @param binding
	 * @param model
	 * @param session
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(method=RequestMethod.POST, value="/person/updateAsAdmin.do")
	public String updatePersonAsAdmin(@ModelAttribute("person") @Valid PersonFormDataAdmin person, BindingResult binding, Model model, HttpSession session, HttpServletRequest request) throws IOException{
		
		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {
			Person connected;
			Person personForm;
			
			if(binding.hasErrors()) {
				model.addAttribute("type", "update");
				return SUCCESS_EDIT;
			}else{
				connected = (Person) session.getAttribute(IConstants.USER_SESSION);
				personForm = person.getPerson();
				personForm.setId((Long)session.getAttribute(IConstants.ID_COLLAB));
			}
			
			if(!StringUtils.isBlank(person.getFirstPassword())){
				MyBlowfish bf = new MyBlowfish();
			    bf.setSecretKey(IConstants.CRYPT_PWD);
			    personForm.setPassword(new BigInteger(bf.crypt(person.getFirstPassword())).toString());
			}else{
				/** retrieve the current password if any new was send*/
				personForm.setPassword(service.getPerson((Long)session.getAttribute(IConstants.ID_COLLAB)).getPassword());
			}
			
			Person personMerged = service.mergePerson(personForm);
			if(connected.getId().equals((Long)session.getAttribute(IConstants.ID_COLLAB))) {
				session.setAttribute(IConstants.USER_SESSION, personMerged);
			}		
			
			model.addAttribute(IConstants.VALIDATION_MSG, Translation.getInstance().getTranslation(ITranslations.PERSONNAL_DATA_SAVED));
			return SUCCESS_EDIT;
			
		}
		else return ERROR_FORWARD;
	}
	
	/**
	 * @param person
	 * @param binding
	 * @param model
	 * @param session
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(method=RequestMethod.POST, value="/person/createAsAdmin.do")
	public String createPersonAsAdmin(@ModelAttribute("person") @Valid PersonFormData person, BindingResult binding, Model model, HttpSession session, HttpServletRequest request) throws IOException{
		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {
			Person personForm;
			
			if(binding.hasErrors()) {
				model.addAttribute("type", "create");
				return SUCCESS_EDIT;
			}else{
				personForm = person.getPerson();
			}
			
			MyBlowfish bf = new MyBlowfish();
		    bf.setSecretKey(IConstants.CRYPT_PWD);
		    personForm.setPassword(new BigInteger(bf.crypt(person.getFirstPassword())).toString());
		
		    service.createPerson(personForm);		
			
			model.addAttribute(IConstants.VALIDATION_MSG, Translation.getInstance().getTranslation(ITranslations.PERSONNAL_DATA_SAVED));
			return SUCCESS_EDIT;
			
		}
		else return ERROR_FORWARD;
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/person/delete.do")
	public String deletePerson(@RequestParam("matricule") String matricule, Model model, HttpSession session, HttpServletRequest request) throws IOException {
		
		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {
			service.deletePerson(matricule);
			listePersons(model,session,request);
			model.addAttribute(IConstants.VALIDATION_MSG, Translation.getInstance().getTranslation(ITranslations.PERSONNAL_DATA_DELETED));
			return SUCCESS_LIST;
		} else {
			return ERROR_FORWARD;
		}

	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/person/create.do")
	public String createPerson(Model model, HttpSession session, HttpServletRequest request) throws IOException {
		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {
			model.addAttribute("person", new PersonFormData(new Person()));
			model.addAttribute("type", "create");
			return SUCCESS_EDIT;
		} else {
			return ERROR_FORWARD;
		}
	}
	
	/**
	 * Permet d'afficher la liste de societes dans la jsp avec ${listeSocietes}
	 * @return
	 */
	@ModelAttribute("listBu")
    public Collection<BusinessUnit> populateBusinessUnit() {
	    return service.listeAllBusinessUnits();
	}
	
	@InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(BusinessUnit.class, new BusinessUnitEditor());
    }
}

/*
 * File: BusinessUnitController.java
 *
 * Goal: .
 *
 * History:
 * //  Creation of the file (ADI)
 */
package com.springmvc.web;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.poi.hsmf.datatypes.PropertyValue.LongPropertyValue;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.Context;
import com.springmvc.IConstants;
import com.springmvc.bo.BusinessUnit;
import com.springmvc.bo.Person;
import com.springmvc.services.BusinessUnitService;
import com.springmvc.services.PersonService;
import com.springmvc.services.impl.BusinessUnitServiceImpl;
import com.springmvc.services.impl.PersonServiceImpl;
import com.springmvc.utils.ITranslations;
import com.springmvc.utils.Translation;
import com.springmvc.utils.Security;

/**
 * The Class BusinessUnitController.
 *
 * @version 5.1, //2014
 */
@Controller
@RequestMapping("/businessunit/*")
public class BusinessUnitController {

	/** The liste persons. */
	private List<BusinessUnit> listeBusinessUnits;
	
	/** The service. */
	private BusinessUnitService service = (BusinessUnitService) Context.getInstance().getApplicationContext().getBean(BusinessUnitService.class);
	private PersonService servicePerson = (PersonService) Context.getInstance().getApplicationContext().getBean(PersonService.class);

	private static final String ERROR_FORWARD = "redirect:"+"/main/login/login.do";
	private static final String SUCCESS_LIST = "businessunit/listeBusinessUnits";
	private static final String SUCCESS_EDIT = "businessunit/editionBusinessUnit";
	
	/**
	 * Constructor for BusinessUnit controller.
	 */
	public BusinessUnitController() {
		super();
//		BusinessUnit businessunit = new BusinessUnit(1L, "JAVA");
//		service.createBusinessUnit(BusinessUnit);
	} 
	
	/**
	 * Liste BusinessUnits.
	 *
	 * @param model
	 *            the model
	 * @return 
	 * @throws IOException 
	 */
	@RequestMapping(value="/businessunit/listeBusinessUnits.do")
	public String listeBusinessUnits(Model model, HttpSession session,
			HttpServletRequest request) throws IOException {
		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {
			listeBusinessUnits = service.listeAllBusinessUnits();
			model.addAttribute("businessunitsList", listeBusinessUnits);
			return SUCCESS_LIST;
		} else {
			return ERROR_FORWARD;
		}
		
	}
	
	/**
	 * BusinessUnit detail.
	 *
	 * @param id
	 *            the id
	 * @param model
	 *            the model
	 * @return 
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	@RequestMapping(method=RequestMethod.GET, value="/businessunit/editionBusinessUnit.do")
	public String businessunitDetail(@RequestParam("id") Integer id, Model model, HttpSession session, HttpServletRequest request) throws NumberFormatException, IOException {
		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {
			BusinessUnit bu = service.getBusinessUnit(Long.parseLong("" + id));
			Collection<Person> listPersons = servicePerson.listpersonBu(bu);
			model.addAttribute("listPersons", listPersons);
			model.addAttribute("businessunit", bu);
			model.addAttribute("type", "update");
			return SUCCESS_EDIT;
		} else {
			return ERROR_FORWARD;
		}

	}
	
	/**
	 * Update businessunit.
	 *
	 * @param person
	 *            the businessunit
	 * @param model
	 *            the model
	 * @return the string
	 * @throws IOException 
	 */
	@RequestMapping(method=RequestMethod.POST, value="/businessunit/update.do")
	public String updateBusinessUnit(@ModelAttribute("businessunit") @Valid BusinessUnit businessunit, Model model, HttpSession session, HttpServletRequest request) throws IOException {
		String forward = "";
		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {
//			if(!businessunit.getLabel().isEmpty()) {
			if(!(businessunit.getLabel()==null || businessunit.getLabel().equals(""))) {
				if(businessunit.getId()!=null) {
					service.updateBusinessUnit(businessunit);
					forward = SUCCESS_EDIT;
				} else {
					service.createBusinessUnit(businessunit);
					listeBusinessUnits(model, session, request);
					forward =  SUCCESS_LIST;
				}
			}
			
			listeBusinessUnits(model, session, request);
			model.addAttribute(IConstants.VALIDATION_MSG, Translation.getInstance().getTranslation(ITranslations.BU_DATA_SAVED));
		}
		else forward = ERROR_FORWARD;
		
		return forward;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/businessunit/delete.do")
	public String deleteBusinessUnit(@RequestParam("id") Integer id, Model model, HttpSession session, HttpServletRequest request) throws IOException {
		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {
			Collection<Person> listPersons = servicePerson.listpersonBu(service.getBusinessUnit(Long.parseLong("" + id)));
			if (!listPersons.isEmpty()) {
				model.addAttribute("message", "Attention cette Business Unit contient des personnes");
				model.addAttribute("listPersons", listPersons);
			}

			else {
				service.deleteBusinessUnit(Long.parseLong(""+id));
			}
			model.addAttribute(IConstants.VALIDATION_MSG, Translation
					.getInstance()
					.getTranslation(ITranslations.BU_DATA_DELETED));
			listeBusinessUnits(model, session, request);
			return SUCCESS_LIST;
		}
		else return ERROR_FORWARD;
			
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/businessunit/create.do")
	public String createBusinessUnit(Model model, HttpSession session, HttpServletRequest request) throws IOException {
		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {
			model.addAttribute("businessunit", new BusinessUnit());
			model.addAttribute("type", "create");
			return SUCCESS_EDIT;
		}
		else return ERROR_FORWARD;
	}
}

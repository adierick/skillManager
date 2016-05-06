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
import com.springmvc.bo.Position;
import com.springmvc.services.BusinessUnitService;
import com.springmvc.services.PersonService;
import com.springmvc.services.PositionService;
import com.springmvc.utils.ITranslations;
import com.springmvc.utils.Security;
import com.springmvc.utils.Translation;

/**
 * The Class PositionController.
 *
 * @version 5.1, //2014
 */
@Controller
@RequestMapping("/position/*")
public class PositionController {

	/** The liste persons. */
	private List<Position> listePositions;
	
	/** The service. */
	private PositionService service = (PositionService) Context.getInstance().getApplicationContext().getBean(PositionService.class);
	
	/** The service person. */
	private PersonService servicePerson = (PersonService) Context.getInstance().getApplicationContext().getBean(PersonService.class);

	/** The Constant ERROR_FORWARD. */
	private static final String ERROR_FORWARD = "redirect:"+"/main/login/login.do";
	
	/** The Constant SUCCESS_LIST. */
	private static final String SUCCESS_LIST = "position/listePositions";
	
	/** The Constant SUCCESS_EDIT. */
	private static final String SUCCESS_EDIT = "position/editionPosition";
	
	/**
	 * Instantiates a new position controller.
	 */
	public PositionController() {
		super();
	} 
	
	/**
	 * Liste positions.
	 *
	 * @param model the model
	 * @param session the session
	 * @param request the request
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@RequestMapping(value="/position/listePositions.do")
	public String listePositions(Model model, HttpSession session,
			HttpServletRequest request) throws IOException {
		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {
			listePositions = service.listeAllPositions();
			model.addAttribute("positionList", listePositions);
			return SUCCESS_LIST;
		} else {
			return ERROR_FORWARD;
		}
		
	}
	
	/**
	 * BusinessUnit detail.
	 *
	 * @param id            the id
	 * @param model            the model
	 * @param session the session
	 * @param request the request
	 * @return the string
	 * @throws NumberFormatException the number format exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@RequestMapping(method=RequestMethod.GET, value="/position/editionPosition.do")
	public String positionDetail(@RequestParam("id") Integer id, Model model, HttpSession session, HttpServletRequest request) throws NumberFormatException, IOException {
		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {
			Position position = service.getPosition(Long.parseLong("" + id));
//			Collection<Person> listPersons = servicePerson.listpersonBu(bu);
//			model.addAttribute("listPersons", listPersons);
			model.addAttribute("position", position);
			model.addAttribute("type", "update");
			return SUCCESS_EDIT;
		} else {
			return ERROR_FORWARD;
		}

	}
	
	/**
	 * Update position.
	 *
	 * @param position the position
	 * @param model the model
	 * @param session the session
	 * @param request the request
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@RequestMapping(method=RequestMethod.POST, value="/position/update.do")
	public String updatePosition(@ModelAttribute("position") @Valid Position position, Model model, HttpSession session, HttpServletRequest request) throws IOException {
		String forward = "";
		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {
				if(position.getId()!=null) {
					Position positionToMerge = service.getPosition(position.getId());
					positionToMerge.setCode(position.getCode());
					positionToMerge.setTrs_label_key(position.getTrs_label_key());
					
					service.updatePosition(positionToMerge);
					forward = SUCCESS_EDIT;
				} else {
					service.createPosition(position);
					listePositions(model, session, request);
					forward =  SUCCESS_LIST;
				}
			
			listePositions(model, session, request);
			model.addAttribute(IConstants.VALIDATION_MSG, Translation.getInstance().getTranslation(ITranslations.POSITION_DATA_SAVED));
		}
		else forward = ERROR_FORWARD;
		
		return forward;
	}
	
	/**
	 * Delete position.
	 *
	 * @param id the id
	 * @param model the model
	 * @param session the session
	 * @param request the request
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@RequestMapping(method=RequestMethod.POST, value="/position/delete.do")
	public String deletePosition(@RequestParam("id") Integer id, Model model, HttpSession session, HttpServletRequest request) throws IOException {
		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {
			Collection<Person> listPersons = servicePerson.listpersonPosition(service.getPosition(Long.parseLong("" + id)));
			if (!listPersons.isEmpty()) {
				model.addAttribute("message", "Attention cette fonction est affecté à des personnes");
				model.addAttribute("listPersons", listPersons);
				model.addAttribute(IConstants.ERROR_MSG, listPersons);
			}

			else {
				service.deletePosition(Long.parseLong(""+id));
				model.addAttribute(IConstants.VALIDATION_MSG, Translation
						.getInstance()
						.getTranslation(ITranslations.POSITION_DATA_DELETED));
			}
			listePositions(model, session, request);
			return SUCCESS_LIST;
		}
		else return ERROR_FORWARD;
			
	}
	
	/**
	 * Creates the position.
	 *
	 * @param model the model
	 * @param session the session
	 * @param request the request
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@RequestMapping(method=RequestMethod.POST, value="/position/create.do")
	public String createPosition(Model model, HttpSession session, HttpServletRequest request) throws IOException {
		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {
			model.addAttribute("position", new Position());
			model.addAttribute("type", "create");
			return SUCCESS_EDIT;
		}
		else return ERROR_FORWARD;
	}
}

/*
 * File: SearchController.java
 *
 * Goal: .
 *
 * History:
 * //  Creation of the file (ADI)
 */
package com.springmvc.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.Context;
import com.springmvc.bo.BusinessUnit;
import com.springmvc.bo.Item;
import com.springmvc.bo.Person;
import com.springmvc.bo.Skill;
import com.springmvc.model.SearchCriteria;
import com.springmvc.model.SearchResult;
import com.springmvc.model.SearchType;
import com.springmvc.services.BusinessUnitService;
import com.springmvc.services.ISearchTypeConstant;
import com.springmvc.services.ItemService;
import com.springmvc.services.PersonService;
import com.springmvc.services.SearchService;
import com.springmvc.services.SkillService;
import com.springmvc.utils.ExportExcel;
import com.springmvc.utils.Security;
import com.springmvc.utils.Translation;
import com.springmvc.web.editor.SearchTypeEditor;

/**
 * The Class SearchController.
 *
 * @author adi
 * @version 5.1, //2014
 */
@Controller
@RequestMapping("/search/*")
public class SearchController {

	/** The search service. */
	private final SearchService searchService = Context.getInstance().getApplicationContext().getBean(SearchService.class);

	/** The business unit service. */
	private final BusinessUnitService businessUnitService = Context.getInstance().getApplicationContext().getBean(BusinessUnitService.class); 

	/** The person service. */
	private final PersonService personService = Context.getInstance().getApplicationContext().getBean(PersonService.class); 

	/** The item service. */
	private final ItemService itemService = Context.getInstance().getApplicationContext().getBean(ItemService.class); 

	private final SkillService skillService = Context.getInstance().getApplicationContext().getBean(SkillService.class);

	/** The result list. */
	List<SearchResult> resultList;

	/** The search criteria. */
	SearchCriteria searchCriteria;

	/** The Constant COL_BU. */
	private static final String COL_BU = "1";

	/** The Constant COL_LASTNAME. */
	private static final String COL_LASTNAME = "2";

	/** The Constant COL_FIRSTNAME. */
	private static final String COL_FIRSTNAME = "3";

	/** The Constant COL_SKILL_CODE. */
	private static final String COL_SKILL_CODE = "4";

	/** The Constant COL_SKILL_LABEL. */
	private static final String COL_SKILL_LABEL = "5";

	/** The Constant COL_SKILL_LEVEL. */
	private static final String COL_SKILL_LEVEL = "6";
	
	private static final String SUCCESS_SEARCH = "search/search";
	private static final String SUCCESS_RESULT = "search/searchResult";
	private static final String ERROR_FORWARD = "redirect:"+"/main/login/login.do";


	/**
	 * Constructor for controller.
	 */
	public SearchController() {
		super();
	} 

	/**
	 * Form.
	 *
	 * @param model the model
	 * @return 
	 */
	@RequestMapping(method=RequestMethod.GET, value="/search/search.do")
	public String search(Model model, HttpSession session, HttpServletRequest request) throws IOException{
		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {
			model.addAttribute("searchCriteria", new SearchCriteria());
			return SUCCESS_SEARCH;
		}
		else return ERROR_FORWARD;
		
	}

	/**
	 * Permet d'afficher la liste de type dans la jsp avec ${searchTypes}.
	 *
	 * @return the collection
	 */
	@ModelAttribute("searchTypes")
	public Collection<SearchType> populateTypes() {
		return searchService.getAllTypes();
	}

	/**
	 * Search form.
	 *
	 * @param searchCriteria the search criteria
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(method=RequestMethod.POST, value="/search/search.do")
	public String searchForm(@ModelAttribute("searchCriteria") SearchCriteria searchCriteria, Model model, HttpSession session, HttpServletRequest request) throws IOException{
		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {
			this.searchCriteria = searchCriteria;
			String criteria = searchCriteria.getCriteria();
			SearchType searchType = searchCriteria.getType();
	
			resultList = new ArrayList<SearchResult>();
	
			if(searchType.getId().equals(ISearchTypeConstant.TYPE_ITEM)) {
				resultList = searchByItem(criteria);
			}
			if(searchType.getId().equals(ISearchTypeConstant.TYPE_BU)) {
				resultList = searchByBu(criteria);
			}
			if(searchType.getId().equals(ISearchTypeConstant.TYPE_COLLAB)) {
				resultList = searchByCollab(criteria);
			}
			if(searchType.getId().equals(ISearchTypeConstant.TYPE_ALL)) {
				resultList = searchByAll(criteria);
			}
	
			if(searchCriteria.getExport()==1) {
				ExportExcel.exportExcel(resultList, searchCriteria);
			}
			//reset export flag
			searchCriteria.setExport(0);
			
			model.addAttribute("searchCriteria", searchCriteria);
			model.addAttribute("searchResult", resultList);
	
			return SUCCESS_RESULT;
		}
		else return ERROR_FORWARD;
		
	}

	/**
	 * Sort form.
	 *
	 * @param colIndex the col index
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(method=RequestMethod.GET, value="/search/sortTable.do")
	public String sortForm(@RequestParam("colIndex") String colIndex, Model model) {
		
		if(colIndex.equals(COL_BU)) {
			Collections.sort(resultList, new Comparator<SearchResult>() {
				
				public int compare(SearchResult arg0, SearchResult arg1) {
					return arg0.getBuLabel().compareTo(arg1.getBuLabel());
				}
			});
		} else if(colIndex.equals(COL_FIRSTNAME)) {
			Collections.sort(resultList, new Comparator<SearchResult>() {
				
				public int compare(SearchResult arg0, SearchResult arg1) {
					return arg0.getFirstName().compareTo(arg1.getFirstName());
				}
			});
		} else if(colIndex.equals(COL_LASTNAME)) {
			Collections.sort(resultList, new Comparator<SearchResult>() {
				
				public int compare(SearchResult arg0, SearchResult arg1) {
					return arg0.getLastName().compareTo(arg1.getLastName());
				}
			});
		} else if(colIndex.equals(COL_SKILL_CODE)) {
			Collections.sort(resultList, new Comparator<SearchResult>() {
				
				public int compare(SearchResult arg0, SearchResult arg1) {
					return arg0.getItemCode().compareTo(arg1.getItemCode());
				}
			});
		} else if(colIndex.equals(COL_SKILL_LABEL)) {
			Collections.sort(resultList, new Comparator<SearchResult>() {
				
				public int compare(SearchResult arg0, SearchResult arg1) {
					return arg0.getItemLabel().compareTo(arg1.getItemLabel());
				}
			});
		} else if(colIndex.equals(COL_SKILL_LEVEL)) {
			Collections.sort(resultList, new Comparator<SearchResult>() {
				
				public int compare(SearchResult arg0, SearchResult arg1) {
					return (arg0.getLevel()>arg1.getLevel())?1:-1;
				}
			});
		}
		
//		switch (colIndex) {
//		case COL_BU:
//			Collections.sort(resultList, new Comparator<SearchResult>() {
//				
//				public int compare(SearchResult arg0, SearchResult arg1) {
//					return arg0.getBuLabel().compareTo(arg1.getBuLabel());
//				}
//			});
//			break;
//		case COL_FIRSTNAME:
//			Collections.sort(resultList, new Comparator<SearchResult>() {
//				
//				public int compare(SearchResult arg0, SearchResult arg1) {
//					return arg0.getFirstName().compareTo(arg1.getFirstName());
//				}
//			});
//			break;
//		case COL_LASTNAME:
//			Collections.sort(resultList, new Comparator<SearchResult>() {
//				
//				public int compare(SearchResult arg0, SearchResult arg1) {
//					return arg0.getLastName().compareTo(arg1.getLastName());
//				}
//			});
//			break;
//		case COL_SKILL_CODE:
//			Collections.sort(resultList, new Comparator<SearchResult>() {
//				
//				public int compare(SearchResult arg0, SearchResult arg1) {
//					return arg0.getItemCode().compareTo(arg1.getItemCode());
//				}
//			});
//			break;
//		case COL_SKILL_LABEL:
//			Collections.sort(resultList, new Comparator<SearchResult>() {
//				
//				public int compare(SearchResult arg0, SearchResult arg1) {
//					return arg0.getItemLabel().compareTo(arg1.getItemLabel());
//				}
//			});
//			break;
//		case COL_SKILL_LEVEL:
//			Collections.sort(resultList, new Comparator<SearchResult>() {
//				
//				public int compare(SearchResult arg0, SearchResult arg1) {
//					return (arg0.getLevel()>arg1.getLevel())?1:-1;
//				}
//			});
//			break;
//		default:
//			break;
//		}

		model.addAttribute("searchCriteria", searchCriteria);
		model.addAttribute("searchResult", resultList);

		return SUCCESS_RESULT;
	}

	/**
	 * Inits the binder.
	 *
	 * @param dataBinder the data binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.registerCustomEditor(SearchType.class, new SearchTypeEditor());
	}

	/**
	 * Search by item.
	 *
	 * @param criteria the criteria
	 * @return the list
	 */
	private List<SearchResult> searchByItem(String criteria) {
		List<Long> alreadyAdded = new ArrayList<Long>();
		List<SearchResult> resultList = new ArrayList<SearchResult>();
		List<Item> listItem = (List<Item>) itemService.find(criteria.toUpperCase());
		for (Item item : listItem) {
			String itemLabel = Translation.getInstance().getTranslation(item.getTrs_label_key());
			String itemCode = item.getCode();

			List<Skill> skillList = item.getSkills();

			for (Skill skill : skillList) {
				Integer level = skill.getLevel();
				Person person = skill.getPerson();
				BusinessUnit bu = person.getBu();

				if(!alreadyAdded.contains(skill.getId())) {
					alreadyAdded.add(skill.getId());
					SearchResult search = new SearchResult(bu.getLabel(),
							person.getLastname(),
							person.getFirstname(),
							itemLabel,
							itemCode,
							level);
					resultList.add(search);
				}
			}
		}
		return resultList;
	}

	/**
	 * Search by bu.
	 *
	 * @param criteria the criteria
	 * @return the list
	 */
	private List<SearchResult> searchByBu(String criteria) {
		List<Long> alreadyAdded = new ArrayList<Long>();
		List<SearchResult> resultList = new ArrayList<SearchResult>();

		List<BusinessUnit> buList = (List<BusinessUnit>) businessUnitService.find(criteria);
		for (BusinessUnit businessUnit : buList) {
			String buLabel = businessUnit.getLabel();

			List<Person> persons = businessUnit.getPersons();
			for (Person person : persons) {
				List<Skill> skillList = skillService.listeAllSkills(person);
				for (Skill skill : skillList) {
					if(!alreadyAdded.contains(skill.getId())) {
						alreadyAdded.add(skill.getId());
						SearchResult search = new SearchResult(buLabel,
								person.getLastname(),
								person.getFirstname(),
								skill.getItem().getCode(),
								Translation.getInstance().getTranslation(skill.getItem().getTrs_label_key()),
								skill.getLevel());
						resultList.add(search);
					}
				}
			}
		}
		return resultList;
	}

	/**
	 * Search by collab.
	 *
	 * @param criteria the criteria
	 * @return the list
	 */
	private List<SearchResult> searchByCollab(String criteria) {
		List<Long> alreadyAdded = new ArrayList<Long>();
		List<SearchResult> resultList = new ArrayList<SearchResult>();
		
		List<Person> personList = (List<Person>) personService.find(criteria);
		for (Person person : personList) {
			List<Skill> skillList = skillService.listeAllSkills(person);
			for (Skill skill : skillList) {
				if(!alreadyAdded.contains(skill.getId())) {
					alreadyAdded.add(skill.getId());
					SearchResult search = new SearchResult(person.getBu().getLabel(),
							person.getLastname(),
							person.getFirstname(),
							skill.getItem().getCode(),
							Translation.getInstance().getTranslation(skill.getItem().getTrs_label_key()),
							skill.getLevel());
					resultList.add(search);
				}
			}
		}
		return resultList;
	}

	/**
	 * Search by all.
	 *
	 * @param criteria the criteria
	 * @return the list
	 */
	private List<SearchResult> searchByAll(String criteria) {
		List<Long> alreadyAdded = new ArrayList<Long>();
		List<SearchResult> resultList = new ArrayList<SearchResult>();
		
		List<Skill> skillList = (List<Skill>) skillService.findAll(criteria);
		for (Skill skill : skillList) {
			Integer level = skill.getLevel();
			Person person = skill.getPerson();
			BusinessUnit bu = person.getBu();

			String itemLabel = Translation.getInstance().getTranslation(skill.getItem().getTrs_label_key());
			String itemCode = skill.getItem().getCode();
			
			if(!alreadyAdded.contains(skill.getId())) {
				alreadyAdded.add(skill.getId());
				SearchResult search = new SearchResult(bu.getLabel(),
						person.getLastname(),
						person.getFirstname(),
						itemLabel,
						itemCode,
						level);
				resultList.add(search);
			}
		}
		return resultList;
	}
}

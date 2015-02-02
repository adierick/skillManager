package com.springmvc.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.Context;
import com.springmvc.IConstants;
import com.springmvc.bo.Category;
import com.springmvc.bo.Item;
import com.springmvc.services.CategoryService;
import com.springmvc.services.ItemService;
import com.springmvc.utils.ITranslations;
import com.springmvc.utils.Translation;
import com.springmvc.utils.Security;
import com.springmvc.web.editor.CategoryEditor;

@Controller
@RequestMapping("/category/*")
public class CategoryController {

	/** The list categories. */
	private List<Category> listCategory;
	private Map<String, Item> itemCache;
	
	/** The service. */
	private CategoryService service = (CategoryService) Context.getInstance().getApplicationContext().getBean(CategoryService.class);
	private ItemService itemService = (ItemService) Context.getInstance().getApplicationContext().getBean(ItemService.class);
	
	private static final String SUCCESS_LIST = "category/listeCategories";
	private static final String SUCCESS_EDIT = "category/editionCategory";
	private static final String SUCCESS_EDITSKILLS = "category/editionCategorySkills";
	private static final String ERROR_FORWARD = "redirect:"+"/main/login/login.do";

	
	/**
	 * Constructor for Category controller.
	 */
	public CategoryController() {
		super();
	} 
	
	/**
	 * Liste categories.
	 *
	 * @param model the model
	 * @return 
	 */
	@RequestMapping(value="/category/listeCategories.do")
	public String listeCategories(Model model, HttpSession session, HttpServletRequest request) throws IOException{
		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {
			listCategory = service.listeAllCategories();
			model.addAttribute("categoriesList", listCategory);
			return SUCCESS_LIST;
		} else {
			return ERROR_FORWARD;
		}

	}
	
	/**
	 * Category detail.
	 *
	 * @param id the id
	 * @param model the model
	 * @return 
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	@RequestMapping(method=RequestMethod.GET, value="/category/editionCategory.do")
	public String categoryDetail(@RequestParam("id") Integer id, Model model, HttpSession session, HttpServletRequest request) throws NumberFormatException, IOException {
		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {			 
			Category category=service.getCategory(Long.parseLong(""+id));						
			model.addAttribute("category", category);				
			
			List<Item> itemListCategory=itemService.listeItemsFromCategory(category);
			model.addAttribute("itemListCategory", itemListCategory);		
			
			model.addAttribute("type", "update");
			return SUCCESS_EDIT;
		} else {
			return ERROR_FORWARD;
		}

	}
	
	/**
	 * Category' skill list.
	 *
	 * @param id the id
	 * @param model the model
	 * @return 
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	@RequestMapping(method=RequestMethod.GET, value="/category/editionCategorySkills.do")
	public String categorySkillsDetail(@RequestParam("id") Integer id, Model model, HttpSession session, HttpServletRequest request) throws NumberFormatException, IOException {
		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {			 
			Category category=service.getCategory(Long.parseLong(""+id));						
			model.addAttribute("category", category);			
			List<Item> allItemList=itemService.listeAllItems();
			model.addAttribute("allItemsList", allItemList);
			model.addAttribute("type", "update");
			return SUCCESS_EDITSKILLS;
		} else {
			return ERROR_FORWARD;
		}
	}
	
	
	/**
	 * Update category.
	 *
	 * @param category the category
	 * @param model the model
	 * @return the string
	 * @throws IOException 
	 */
	@RequestMapping(method=RequestMethod.POST, value="/category/update.do")
	public String updateCategory(@ModelAttribute("category") @Valid Category category, Model model, HttpSession session, HttpServletRequest request) throws IOException {
		String forward = "";
		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {
			if(!category.getCode().isEmpty()
					&& !category.getTrs_label_key().isEmpty()) {
				
				if(category.getId()!=null) {					
					// gestion des suppressions
					List<Item> itemsEnBase = itemService.listeItemsFromCategory(category);					
					for(Item item : itemsEnBase) {
						if (!category.getItems().contains(item)) {
							item.setCategory(null);
							itemService.updateItem(item);
						}
					}
					
					// gestion des ajouts/conservation
					for(Item item : category.getItems()) {						
						item.setCategory(category);
					} service.updateCategory(category);
					
					model.addAttribute("category", category);
					forward = SUCCESS_EDIT;
				} else {
					service.createCategory(category);
					forward = SUCCESS_LIST;
				}
			}			
			listeCategories(model, session, request);
			model.addAttribute(IConstants.VALIDATION_MSG, Translation.getInstance().getTranslation(ITranslations.CATEGORY_DATA_SAVED));
		}
		else forward = ERROR_FORWARD;
	
		return forward;
	}
	
		
	@RequestMapping(method=RequestMethod.POST, value="/category/delete.do")
	public String deleteCategory(@RequestParam("id") Integer id, Model model, HttpSession session, HttpServletRequest request) throws IOException {
		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {
			service.deleteCategory(Long.parseLong(""+id));
			listeCategories(model, session, request);
			model.addAttribute(IConstants.VALIDATION_MSG, Translation.getInstance().getTranslation(ITranslations.CATEGORY_DATA_DELETED));
			return SUCCESS_LIST;			
		}
		else return ERROR_FORWARD;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/category/create.do")
	public String createCategory(Model model, HttpSession session, HttpServletRequest request) throws IOException {
		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {
			model.addAttribute("category", new Category());
			model.addAttribute("type", "create");
			return SUCCESS_EDIT;
		}
		else return ERROR_FORWARD;
	}
	

	
	
	// mapper les items 
	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {
		binder.registerCustomEditor(List.class, "items", new CustomCollectionEditor(List.class) {
			@Override
			protected Object convertElement(Object element) {
				Long id=null;
				
				if(element instanceof String && !((String)element).equals("")){ // id=String dans la JSP                    
                    try{
                        id = Long.parseLong((String) element);
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Erreur conversion element was " + ((String) element));
                        e.printStackTrace();
                    }
                }
                else if(element instanceof Long) { // id=Long dans la bdd
                    id = (Long) element;
                }

                return (id != null) ? itemService.getItem(id) : null; 
						
						
			}
		});
	}		
	
}

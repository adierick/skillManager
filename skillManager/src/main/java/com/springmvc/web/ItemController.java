/*
 * File: ItemController.java
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
import com.springmvc.utils.Security;
import com.springmvc.utils.Translation;
import com.springmvc.web.editor.CategoryEditor;

/**
 * The Class ItemController.
 *
 * @author fxd
 * @version 5.1, //2014
 */
@Controller
@RequestMapping("/item/*")
public class ItemController {

	/** The liste items. */
	private List<Item> listeItems;
	
	/** The service. */
	private final ItemService service = Context.getInstance().getApplicationContext().getBean(ItemService.class);
	private final CategoryService serviceCategory = Context.getInstance().getApplicationContext().getBean(CategoryService.class);

	private static final String SUCCESS_LIST = "item/listeItems";
	private static final String SUCCESS_EDIT = "item/editionItem";
	private static final String ERROR_FORWARD = "redirect:"+"/main/login/login.do";

	
	/**
	 * Constructor for item controller.
	 */
	public ItemController() {
		super();
	} 
	
	/**
	 * Liste items.
	 *
	 * @param model the model
	 * @return 
	 */
	@RequestMapping(value="/item/listeItems.do")
	public String listeItems(Model model, HttpSession session, HttpServletRequest request) throws IOException{
		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {
			listeItems = service.listeAllItems();
			model.addAttribute("itemsList", listeItems);
			return SUCCESS_LIST;
		} else {
			return ERROR_FORWARD;
		}

	}
	
	/**
	 * Item detail.
	 *
	 * @param id the id
	 * @param model the model
	 * @return 
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	@RequestMapping(method=RequestMethod.GET, value="/item/editionItem.do")
	public String itemDetail(@RequestParam("id") Integer id, Model model, HttpSession session, HttpServletRequest request) throws NumberFormatException, IOException {
		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {
			model.addAttribute("item", service.getItem(Long.parseLong(""+id)));
			model.addAttribute("type", "update");
			return SUCCESS_EDIT;
		} else {
			return ERROR_FORWARD;
		}

	}
	
	/**
	 * Update item.
	 *
	 * @param item the item
	 * @param model the model
	 * @return the string
	 * @throws IOException 
	 */
	@RequestMapping(method=RequestMethod.POST, value="/item/update.do")
	public String updateItem(@ModelAttribute("item") @Valid Item item, Model model, HttpSession session, HttpServletRequest request) throws IOException {
		String forward = "";
		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {
			if(!(item.getCode()==null || item.getCode().equals(""))
					&& !(item.getTrs_label_key()==null || item.getTrs_label_key().equals(""))) {
				
				if(item.getId()!=null) {
//					service.updateItem(item);
					service.mergeItem(item);
					forward = SUCCESS_EDIT;
				} else {
					service.createItem(item);
					forward = SUCCESS_LIST;
				}
			}			
			listeItems(model, session, request);
			model.addAttribute(IConstants.VALIDATION_MSG, Translation.getInstance().getTranslation(ITranslations.ITEM_DATA_SAVED));
		}
		else forward = ERROR_FORWARD;
	
		return forward;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/item/delete.do")
	public String deleteItem(@RequestParam("id") Integer id, Model model, HttpSession session, HttpServletRequest request) throws IOException {
		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {
			service.deleteItem(Long.parseLong(""+id));
			listeItems(model, session, request);
			model.addAttribute(IConstants.VALIDATION_MSG, Translation.getInstance().getTranslation(ITranslations.ITEM_DATA_DELETED));
			return SUCCESS_LIST;			
		}
		else return ERROR_FORWARD;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/item/create.do")
	public String createItem(Model model, HttpSession session, HttpServletRequest request) throws IOException {
		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {
			model.addAttribute("item", new Item());
			model.addAttribute("type", "create");
			return SUCCESS_EDIT;
		}
		else return ERROR_FORWARD;
	}
	
	@ModelAttribute("listCategory")
    public Collection<Category> populateCategory() {
	    return serviceCategory.listeAllCategories();
	}
	
	@InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Category.class, new CategoryEditor());
    }
}

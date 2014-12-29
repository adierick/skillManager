package com.springmvc.web.editor;

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang.StringUtils;

import com.springmvc.Context;
import com.springmvc.bo.Category;
import com.springmvc.services.CategoryService;

public class CategoryEditor extends PropertyEditorSupport {

	private final CategoryService service;

	public CategoryEditor() {
		super();
		service = Context.getInstance().getApplicationContext().getBean(CategoryService.class);
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(StringUtils.isNotBlank(text)){
			setValue(service.getCategory(Long.parseLong(text)));
		}
		else{
			setValue(null);
		}
	}

	@Override
	public String getAsText() {
		Category s = (Category) getValue();
		if (s == null) {
			return null;
		} else {
			return s.getId().toString();
		}
	}

}

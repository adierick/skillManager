package com.springmvc.web.editor;

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang.StringUtils;

import com.springmvc.Context;
import com.springmvc.model.SearchType;
import com.springmvc.services.SearchService;

public class SearchTypeEditor extends PropertyEditorSupport {
	
	private final SearchService service;

	public SearchTypeEditor() {
		super();
		service = (SearchService) Context.getInstance().getApplicationContext().getBean(SearchService.class);
	}

	@Override
	public void setAsText(String id) throws IllegalArgumentException {
		if(StringUtils.isNotBlank(id)){
			setValue(service.getSearchType(Long.parseLong(id)));
		}
		else{
			setValue(null);
		}
	}

	@Override
	public String getAsText() {
		SearchType s = (SearchType) getValue();
		if (s == null) {
			return null;
		} else {
			return s.getLabel();
		}
	}

}

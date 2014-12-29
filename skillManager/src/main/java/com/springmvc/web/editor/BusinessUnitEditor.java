package com.springmvc.web.editor;

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang.StringUtils;

import com.springmvc.Context;
import com.springmvc.bo.BusinessUnit;
import com.springmvc.services.BusinessUnitService;

public class BusinessUnitEditor extends PropertyEditorSupport {

	private final BusinessUnitService service;

	public BusinessUnitEditor() {
		super();
		service = (BusinessUnitService) Context.getInstance().getApplicationContext().getBean(BusinessUnitService.class);
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(StringUtils.isNotBlank(text)){
			setValue(service.getBusinessUnit(Long.parseLong(text)));
		}
		else{
			setValue(null);
		}
	}

	@Override
	public String getAsText() {
		BusinessUnit s = (BusinessUnit) getValue();
		if (s == null) {
			return null;
		} else {
			return s.getId().toString();
		}
	}

}

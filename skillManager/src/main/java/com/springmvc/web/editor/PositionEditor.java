package com.springmvc.web.editor;

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang.StringUtils;

import com.springmvc.Context;
import com.springmvc.bo.Position;
import com.springmvc.services.PositionService;

public class PositionEditor extends PropertyEditorSupport {

	private final PositionService service;

	public PositionEditor() {
		super();
		service = (PositionService) Context.getInstance().getApplicationContext().getBean(PositionService.class);
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(StringUtils.isNotBlank(text)){
			setValue(service.getPosition(Long.parseLong(text)));
		}
		else{
			setValue(null);
		}
	}

	@Override
	public String getAsText() {
		Position s = (Position) getValue();
		if (s == null) {
			return null;
		} else {
			return s.toString();
		}
	}

}

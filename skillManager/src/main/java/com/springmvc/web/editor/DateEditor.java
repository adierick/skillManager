package com.springmvc.web.editor;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;

public class DateEditor extends PropertyEditorSupport {

	private static final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

	public DateEditor() {
		super();
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(StringUtils.isNotBlank(text)){
			try {
				setValue(formatter.parse(text));
			} catch (ParseException e) {
				setValue(null);
			}
		}
		else{
			setValue(null);
		}
	}

	@Override
	public String getAsText() {
		Object date = getValue();
		if(date !=null ){
			return formatter.format(date);
		}
		
		return "";
	}

}

package com.springmvc.model;

public class SearchCriteria {

	private String criteria;
	private SearchType type;
	private int export;
	
	public SearchCriteria() {}
	
	public SearchCriteria(String criteria, SearchType type, int export) {
		this.criteria = criteria;
		this.type = type;
		this.export = export;
	}

	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public SearchType getType() {
		return type;
	}

	public void setType(SearchType type) {
		this.type = type;
	}

	public int getExport() {
		return export;
	}

	public void setExport(int export) {
		this.export = export;
	}
	
	
}


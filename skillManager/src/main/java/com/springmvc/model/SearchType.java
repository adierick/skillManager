/*
 * File: SearchType.java
 *
 * Goal: .
 *
 * History:
 * //  Creation of the file (ADI)
 */
package com.springmvc.model;

/**
 * The Class SearchType.
 *
 * @author adi
 * @version 5.1, //2014
 */
public class SearchType {

	/** The id. */
	private Long id;
	
	/** The label. */
	private String label;
	
	/**
	 * Constructor for search type.
	 */
	public SearchType() {}
			
	/**
	 * Constructor for search type.
	 *
	 * @param id the id
	 * @param label the label
	 */
	public SearchType(Long id, String label) {
		this.id = id;
		this.label = label;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the label.
	 *
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Sets the label.
	 *
	 * @param label the new label
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	
}

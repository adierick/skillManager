/*
 * File: SearchResult.java
 *
 * Goal: .
 *
 * History:
 * //  Creation of the file (ADI)
 */
package com.springmvc.model;


/**
 * The Class SearchResult.
 *
 * @author adierick
 */
public class SearchResult {

	/** The bu label. */
	private String buLabel;
	
	/** The last name. */
	private String lastName;
	
	/** The first name. */
	private String firstName;
	
	/** The item label. */
	private String itemLabel;
	
	/** The item code. */
	private String itemCode;

	/** The level. */
	private int level;
	
	
	/**
	 * Constructor for search result.
	 */
	public SearchResult() {}
	
	/**
	 * Constructor for search result.
	 *
	 * @param buLabel the bu label
	 * @param lastName the last name
	 * @param firstName the first name
	 * @param itemLabel the item label
	 * @param itemCode the item code
	 * @param level the level
	 */
	public SearchResult(String buLabel, String lastName, String firstName, String itemLabel, String itemCode, int level) {
		this.buLabel = buLabel;
		this.lastName = lastName;
		this.firstName = firstName;
		this.itemLabel = itemLabel;
		this.level = level;
		this.itemCode = itemCode;
	}

	/**
	 * Gets the bu label.
	 *
	 * @return the bu label
	 */
	public String getBuLabel() {
		return buLabel;
	}

	/**
	 * Sets the bu label.
	 *
	 * @param buLabel the new bu label
	 */
	public void setBuLabel(String buLabel) {
		this.buLabel = buLabel;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the item label.
	 *
	 * @return the item label
	 */
	public String getItemLabel() {
		return itemLabel;
	}

	/**
	 * Sets the item label.
	 *
	 * @param itemLabel the new item label
	 */
	public void setItemLabel(String itemLabel) {
		this.itemLabel = itemLabel;
	}

	/**
	 * Gets the level.
	 *
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Sets the level.
	 *
	 * @param level the new level
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	
	
	/**
	 * Gets the item code.
	 *
	 * @return the item code
	 */
	public String getItemCode() {
		return itemCode;
	}

	/**
	 * Sets the item code.
	 *
	 * @param itemCode the new item code
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
}

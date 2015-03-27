package com.springmvc.bo;

public class PersonPicture {
	
	private Person person;
	private String encoded;
	
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public String getEncoded() {
		return encoded;
	}
	public void setEncoded(String encoded) {
		this.encoded = encoded;
	}
	
	
	public PersonPicture() {
		
	}
	
	public PersonPicture(Person person, String encoded) {
		super();
		this.person = person;
		this.encoded = encoded;
	}
	
	public PersonPicture(Person person) {
		super();
		this.person = person;
	}

}

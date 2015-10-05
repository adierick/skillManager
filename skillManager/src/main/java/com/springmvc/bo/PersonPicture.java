package com.springmvc.bo;

import java.util.List;

public class PersonPicture {
	
	private Person person;
	private String encoded;
	private List<Skill> skill;
	
	
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
	public PersonPicture(Person person, String encoded, List<Skill> skill) {
		super();
		this.person = person;
		this.encoded = encoded;
		this.skill = skill;
	}
	
	public PersonPicture(Person person) {
		super();
		this.person = person;
	}
	public List<Skill> getSkill() {
		return skill;
	}
	public void setSkill(List<Skill> skill) {
		this.skill = skill;
	}
	
	

}

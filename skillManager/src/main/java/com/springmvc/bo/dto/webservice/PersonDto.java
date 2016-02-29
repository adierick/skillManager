package com.springmvc.bo.dto.webservice;

import com.springmvc.bo.Person;


public class PersonDto {

	private Long id;
	private String firstname;
	private String lastname;
	private String matricule;
	private String email;
	private String buLabel;
	private Boolean admin;
	private Boolean manager;
	private String login;
	private String password;


	public PersonDto(String firstname, String lastname, String matricule, String email, String buLabel, Boolean admin, String login, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.matricule = matricule;
		this.email = email;
		this.setBuLabel(buLabel);
		this.admin = admin;
		this.login = login;
		this.setPassword(password);
	}
	
	public PersonDto(Person person){
		this.admin = person.getAdmin();
		if(person.getBu()!=null){
			this.buLabel = person.getBu().getLabel();
		}
		this.email = person.getEmail();
		this.firstname =  person.getFirstname();
		this.id = person.getId();
		this.lastname = person.getLastname();
		this.login = person.getLogin();
		this.manager = person.getManager();
		this.matricule = person.getMatricule();
		this.password = person.getPassword();
	}
	
	public PersonDto() {}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}


	public String toString() {
		return this.firstname + " " + this.lastname + " (" + this.matricule + ")";
	}

	public Boolean getManager() {
		return manager;
	}

	public void setManager(Boolean manager) {
		this.manager = manager;
	}

	public String getBuLabel() {
		return buLabel;
	}

	public void setBuLabel(String buLabel) {
		this.buLabel = buLabel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}

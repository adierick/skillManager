package com.springmvc.bo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="person")
public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3630612804443185892L;
	private Long id;
	@NotEmpty(message="{person.firstname.notBlank}")
	private String firstname;
	@NotEmpty(message="{person.lastname.notBlank}")
	private String lastname;
	@NotEmpty(message="{person.matricule.notBlank}")
	private String matricule;
	private String email;
	//private byte[] picture;
	private BusinessUnit bu;
	private Boolean admin;
	@NotEmpty(message="{person.login.notBlank}")
	private String login;
	private String password;


	/**
	 * 
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param dateEmbauche
	 * @param fonction
	 */
	public Person(String firstname, String lastname, String matricule, String email, /*byte[] picture*/ BusinessUnit bu, Boolean admin, String login, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.matricule = matricule;
		this.email = email;
		//this.picture = picture;
		this.bu = bu;
		this.admin = admin;
		this.login = login;
		this.password = password;
	}
	
	public Person() {}
	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
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

/*
	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
*/
	@ManyToOne
	@JoinColumn(name="id_bu")
	public BusinessUnit getBu() {
		return bu;
	}

	public void setBu(BusinessUnit bu) {
		this.bu = bu;
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

/*	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}*/
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		/*MyBlowfish bf = new MyBlowfish();
		bf.setSecretKey(IConstants.CRYPT_PWD);
		this.password = new BigInteger(bf.crypt(password)).toString();*/
	}
	
	
//	public void setSkills(List<Skill> skills) {
//		this.skills = skills;
//	}
//	
//	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
//	@JoinColumn(name="person_id")
//	public List<Skill> getSkills() {
//		return skills;
//	}

	public String toString() {
		return this.firstname + " " + this.lastname + " (" + this.matricule + ")";
	}
}

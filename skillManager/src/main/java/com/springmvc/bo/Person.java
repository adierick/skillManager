package com.springmvc.bo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.ws.soap.Addressing;
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
	private Boolean manager;
	@NotEmpty(message="{person.login.notBlank}")
	private String login;
	private String password;
	//TODO
//	private Byte[] picture_data;
	private Date birth_date;
	private String Tel;
	private String hobby;
	private Date date_entry_sii;
	private String position_coeff;
	private Position position;
//	private int position_id;
//	private String function;


	/**
	 * 
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param dateEmbauche
	 * @param fonction
	 */
	public Person(String firstname, String lastname, String matricule, String email, /*byte[] picture*/ BusinessUnit bu, Boolean admin, String login, String password,
			/*Byte[] picture_data, */
			Boolean manager, Date birth_date, String Tel, String hobby, Date date_entry_sii, String position_coeff/*, String function*/) {
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
//		this.setPicture_data(picture_data);
		this.manager = manager;
		this.setBirth_date(birth_date);
		this.setTel(Tel);
		this.setHobby(hobby);
		this.setDate_entry_sii(date_entry_sii);
		this.setPosition_coeff(position_coeff);
		//this.setFunction(function);
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
	
	@ManyToOne
	@JoinColumn(name="position_id")
	public Position getPosition(){
		return position;
	}
	public void setPosition(Position code){
		this.position=code;
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

	public Boolean getManager() {
		return manager;
	}

	public void setManager(Boolean manager) {
		this.manager = manager;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

//	public Byte[] getPicture_data() {
//		return picture_data;
//	}
//
//	public void setPicture_data(Byte[] picture_data) {
//		this.picture_data = picture_data;
//	}

	public String getTel() {
		return Tel;
	}

	public void setTel(String tel) {
		Tel = tel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Date getDate_entry_sii() {
		return date_entry_sii;
	}

	public void setDate_entry_sii(Date date_entry_sii) {
		this.date_entry_sii = date_entry_sii;
	}

	public String getPosition_coeff() {
		return position_coeff;
	}

	public void setPosition_coeff(String position_coeff) {
		this.position_coeff = position_coeff;
	}
/*
	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}
*/
/*
	public int getPosition_id() {
		return position_id;
	}

	public void setPosition_id(int position_id) {
		this.position_id = position_id;
	}
*/

}

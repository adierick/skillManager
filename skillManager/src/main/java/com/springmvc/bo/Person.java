package com.springmvc.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.ws.soap.Addressing;

import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


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
//	private Byte[] picture_data;
	private Date birth_date;
	private String Tel;
	private String hobby;
	private Date date_activity_pro;
	private Date date_entry_sii;
	private String position_coeff;
	private Position position;
	private Person manager_;
	private SortedSet<Remuneration> remuneration;
	private SortedSet<Mission> missions;
	private SortedSet<Career> career;
	private MISC misc;
	private Set<Behaviour> behaviour;
	private Set<HistoryMGT> historyMGT;
	private Set<Formation> formation;
	private Remarks remarks;
		
	public Person(Long id, String firstname, String lastname, String matricule, String email, BusinessUnit bu,
			Boolean admin, Boolean manager, String login, String password, Date birth_date, String tel, String hobby,
			Date date_activity_pro, Date date_entry_sii, String position_coeff, Position position, SortedSet<Remuneration> remuneration, 
			Person manager_, SortedSet<Mission> missions, SortedSet<Career> career, Set<Behaviour> behaviour, Set<HistoryMGT> historyMGT, Set<Formation> formation) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.matricule = matricule;
		this.email = email;
		this.bu = bu;
		this.admin = admin;
		this.manager = manager;
		this.login = login;
		this.password = password;
		this.birth_date = birth_date;
		this.Tel = tel;
		this.hobby = hobby;
		this.date_activity_pro = date_activity_pro;
		this.date_entry_sii = date_entry_sii;
		this.position_coeff = position_coeff;
		this.position = position;
		this.setRemuneration(remuneration);
		this.manager_=manager_;
		this.missions=missions;
		this.career=career;
//		this.misc=misc;
		this.historyMGT=historyMGT;
		this.behaviour=behaviour;
		this.formation=formation;
	}
	
	//TODO : Person managerPerson;
	// rajouter le lien 
//	private int position_id;
//	private String function;

	
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

	@DateTimeFormat(pattern = "dd-MM-yyyy")
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

	public Date getDate_activity_pro() {
		return date_activity_pro;
	}

	public void setDate_activity_pro(Date date_activity_pro) {
		this.date_activity_pro = date_activity_pro;
	}

	@ManyToOne
	@JoinColumn(name="manager_id")
	public Person getManager_() {
		return manager_;
	}

	public void setManager_(Person firstname) {
		this.manager_ = firstname;
	}
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="persons_id")
	@Sort(type = SortType.NATURAL) 
	public SortedSet<Remuneration> getRemuneration() {
		return remuneration;
	}

	public void setRemuneration(SortedSet<Remuneration> remuneration) {
		this.remuneration = remuneration;
	}
	

	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="persons_id")
	@OrderBy("dateDemarrage")
	@Sort(type = SortType.NATURAL) 
	public SortedSet<Mission> getMissions() {
		return missions;
	}

	public void setMissions(SortedSet<Mission> missions) {
		this.missions = missions;
	}
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="persons_id")
	@Sort(type = SortType.NATURAL) 
	public SortedSet<Career> getCareer() {
		return career;
	}
	public void setCareer(SortedSet<Career> poste) {
		this.career = poste;
	}
	
//	@OneToOne(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.ALL)
//	@PrimaryKeyJoinColumn
	@OneToOne(optional=false)
    @JoinColumn(name="MISC_id")
	public MISC getMisc() {
		return misc;
	}
	public void setMisc(MISC misc_description) {
		this.misc = misc_description;
	}

	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="persons_id")
	@Sort(type = SortType.NATURAL) 
	public Set<Behaviour> getBehaviour() {
		return behaviour;
	}
	public void setBehaviour(Set<Behaviour> behaviour) {
		this.behaviour = behaviour;
	}
	
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="persons_id")
	@Sort(type=SortType.NATURAL)
	public Set<HistoryMGT> getHistoryMGT() {
		return historyMGT;
	}

	public void setHistoryMGT(Set<HistoryMGT> historyMGT) {
		this.historyMGT = historyMGT;
	}

	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="persons_id")
	@Sort(type = SortType.NATURAL) 
	public Set<Formation> getFormation() {
		return formation;
	}

	public void setFormation(Set<Formation> formation) {
		this.formation = formation;
	}

	@OneToOne(optional=false)
    @JoinColumn(name="remarks_id")
	public Remarks getRemarks() {
		return remarks;
	}

	public void setRemarks(Remarks remarks) {
		this.remarks = remarks;
	}

}

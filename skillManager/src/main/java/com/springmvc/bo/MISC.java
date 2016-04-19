package com.springmvc.bo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="misc")
public class MISC implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7919526593945129428L;
	private Long idactivity_prestation;
	private String misc_description;
	private List<Person> persons;
	
	public MISC(Long idactivity_prestation, String misc_description, List<Person> persons) {
		super();
		this.idactivity_prestation = idactivity_prestation;
		this.misc_description = misc_description;
		this.persons = persons;
	}
	public MISC() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdactivity_prestation() {
		return idactivity_prestation;
	}
	public void setIdactivity_prestation(Long idactivity_prestation) {
		this.idactivity_prestation = idactivity_prestation;
	}
	public String getMisc_description() {
		return misc_description;
	}
	public void setMisc_description(String misc_description) {
		this.misc_description = misc_description;
	}
	
	@OneToMany
	@JoinColumn(name="MISC_id")
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
	
	@Override
	public String toString() {
		return "MISC [idactivity_prestation=" + idactivity_prestation + ", misc_description=" + misc_description
				+ ", persons=" + persons + "]";
	}
	

}

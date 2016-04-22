package com.springmvc.bo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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
	private Person person;
	
	public MISC(Long idactivity_prestation, String misc_description, Person persons) {
		super();
		this.idactivity_prestation = idactivity_prestation;
		this.misc_description = misc_description;
		this.person = persons;
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
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy="misc")
//	@PrimaryKeyJoinColumn
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	@Override
	public String toString() {
		return "MISC [idactivity_prestation=" + idactivity_prestation + ", misc_description=" + misc_description
				+ ", persons=" + person + "]";
	}
	

}

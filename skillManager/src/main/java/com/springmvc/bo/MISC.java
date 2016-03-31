package com.springmvc.bo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="misc")
public class MISC implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7919526593945129428L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idactivity_prestation;
	private String misc_description;
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
	

}

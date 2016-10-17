package com.springmvc.bo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="remarks")
public class Remarks implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8487965550370012647L;
	private Long idRemarks;
	private String remarks;
	private Person persons;
	
	
	public Remarks() {
		super();
	}
	public Remarks(Long idRemarks, String remarks, Person persons) {
		super();
		this.idRemarks = idRemarks;
		this.remarks = remarks;
		this.persons = persons;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdRemarks() {
		return idRemarks;
	}

	public void setIdRemarks(Long idRemarks) {
		this.idRemarks = idRemarks;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy="remarks")
	public Person getPersons() {
		return persons;
	}
	
	public void setPersons(Person persons) {
		this.persons = persons;
	}

	@Override
	public String toString() {
		return "Remarks [idRemarks=" + idRemarks + ", remarks=" + remarks + ", persons=" + persons + "]";
	}

}

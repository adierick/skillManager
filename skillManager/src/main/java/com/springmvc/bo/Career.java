package com.springmvc.bo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="career")
public class Career {
	
	private Long idcareer;
	private String poste;
	private String coefficient;
	private Date date;
	private Person persons;
	
	
	public Career() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Career(Long idcareer, String poste, String coefficient, Date date, Person persons) {
		super();
		this.idcareer = idcareer;
		this.poste = poste;
		this.coefficient = coefficient;
		this.date = date;
		this.persons=persons;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdcareer() {
		return idcareer;
	}
	public void setIdcareer(Long idcareer) {
		this.idcareer = idcareer;
	}
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	public String getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(String coefficient) {
		this.coefficient = coefficient;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Career [idcareer=" + idcareer + ", poste=" + poste + ", coefficient=" + coefficient + ", date=" + date
				+ ", persons=" + persons + "]";
	}
	
	@ManyToOne
	@JoinColumn(name="persons_id")
	public Person getPersons() {
		return persons;
	}
	public void setPersons(Person persons) {
		this.persons = persons;
	}
	
}

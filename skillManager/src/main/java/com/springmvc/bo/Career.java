package com.springmvc.bo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="career")
public class Career {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idcareer;
	private String poste;
	private String coefficient;
	private Date date;
	
	
	public Career() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Career(Long idcareer, String poste, String coefficient, Date date) {
		super();
		this.idcareer = idcareer;
		this.poste = poste;
		this.coefficient = coefficient;
		this.date = date;
	}
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
	
}

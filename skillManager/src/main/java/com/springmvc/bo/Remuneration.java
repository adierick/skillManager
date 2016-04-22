package com.springmvc.bo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="remuneration")
public class Remuneration implements Serializable, Comparable<Remuneration>{

	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 3186000202689865361L;
	
	private Long idREMUNERATION;
	
	private String brut;
	private double fixe;
	private double variable;
	private String commentaire;
	private Person persons;
	
	
	
	
	public Remuneration() {
		super();
	}
	public Remuneration(Long idREMUNERATION, String brut, double fixe, double variable, String commentaire, Person persons) {
		super();
		this.idREMUNERATION = idREMUNERATION;
		this.brut = brut;
		this.fixe = fixe;
		this.variable = variable;
		this.commentaire = commentaire;
		this.persons=persons;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdREMUNERATION() {
		return idREMUNERATION;
	}
	public void setIdREMUNERATION(Long idREMUNERATION) {
		this.idREMUNERATION = idREMUNERATION;
	}
	
	public String getBrut() {
		return brut;
	}
	public void setBrut(String brut) {
		this.brut = brut;
	}
	public double getFixe() {
		return fixe;
	}
	public void setFixe(double fixe) {
		this.fixe = fixe;
	}
	public double getVariable() {
		return variable;
	}
	public void setVariable(double variable) {
		this.variable = variable;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	
	
	@ManyToOne
	@JoinColumn(name="persons_id")
	public Person getPersons() {
		return persons;
	}
	public void setPersons(Person persons) {
		this.persons = persons;
	}

	@Override
	public String toString() {
		return "Remuneration [idREMUNERATION=" + idREMUNERATION + ", brut=" + brut + ", fixe=" + fixe + ", variable="
				+ variable + ", commentaire=" + commentaire + ", persons=" + persons + "]";
	}
	@Override
	public int compareTo(Remuneration o) {
		return o.getBrut().compareTo(brut);
	}
}

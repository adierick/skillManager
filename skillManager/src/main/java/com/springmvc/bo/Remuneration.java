package com.springmvc.bo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="remuneration")
public class Remuneration implements Serializable{

	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 3186000202689865361L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idREMUNERATION;
	
	private double Brut;
	private double Fixe;
	private double Variable;
	private String Commentaire;
	
	
	
	public Remuneration() {
		super();
	}
	public Remuneration(Long idREMUNERATION, double brut, double fixe, double variable, String commentaire) {
		super();
		this.idREMUNERATION = idREMUNERATION;
		Brut = brut;
		Fixe = fixe;
		Variable = variable;
		Commentaire = commentaire;
	}
	public double getBrut() {
		return Brut;
	}
	public void setBrut(double brut) {
		Brut = brut;
	}
	public double getFixe() {
		return Fixe;
	}
	public void setFixe(double fixe) {
		Fixe = fixe;
	}
	public double getVariable() {
		return Variable;
	}
	public void setVariable(double variable) {
		Variable = variable;
	}
	public String getCommentaire() {
		return Commentaire;
	}
	public void setCommentaire(String commentaire) {
		Commentaire = commentaire;
	}
	public Long getIdREMUNERATION() {
		return idREMUNERATION;
	}
	public void setIdREMUNERATION(Long idREMUNERATION) {
		this.idREMUNERATION = idREMUNERATION;
	}
	
	

}

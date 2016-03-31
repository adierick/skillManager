package com.springmvc.bo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mission")
public class Mission implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7071899330326671534L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idmission;
	private String client;
	private String activite;
	private Date dateDemarrage;
	private String commentaire;
	
	public Mission(int idmission, String client, String activite, Date dateDemarrage, String commentaire){
		super();
		this.setIdmission(idmission);
		this.setClient(client);
		this.setActivite(activite);
		this.setDateDemarrage(dateDemarrage);
		this.setCommentaire(commentaire);
	}
	public Mission(){}

	public int getIdmission() {
		return idmission;
	}

	public void setIdmission(int idmission) {
		this.idmission = idmission;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getActivite() {
		return activite;
	}

	public void setActivite(String activite) {
		this.activite = activite;
	}

	public Date getDateDemarrage() {
		return dateDemarrage;
	}

	public void setDateDemarrage(Date dateDemarrage) {
		this.dateDemarrage = dateDemarrage;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
}

package com.springmvc.bo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="mission")
public class Mission implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7071899330326671534L;

	private int idmission;
	private String client;
	private String activite;
	private Date dateDemarrage;
	private String commentaire;
	private String entitedMission;
	private Person persons;


	public Mission(int idmission, String client, String activite, Date dateDemarrage, String commentaire,
			String entitedMission, Person persons) {
		super();
		this.idmission = idmission;
		this.client = client;
		this.activite = activite;
		this.dateDemarrage = dateDemarrage;
		this.commentaire = commentaire;
		this.entitedMission = entitedMission;
		this.persons = persons;
	}

	public String getEntitedMission() {
		return entitedMission;
	}
	public void setEntitedMission(String entitedMission) {
		this.entitedMission = entitedMission;
	}

	public Mission(){}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
		return "Mission [idmission=" + idmission + ", client=" + client + ", activite=" + activite + ", dateDemarrage="
				+ dateDemarrage + ", commentaire=" + commentaire + ", entitedMission=" + entitedMission + ", person="
				+ persons + "]";
	}


}

package com.springmvc.bo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="formation")
public class Formation implements Serializable, Comparable<Formation>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5711716306498342916L;
	private Long idformation;
	private String entitled;
	private Date date;
	private Person persons;
	
	public Formation() {
		super();
	}

	public Formation(Long idformation, String entitled, Date date, Person persons) {
		super();
		this.idformation = idformation;
		this.entitled = entitled;
		this.date = date;
		this.persons = persons;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdformation() {
		return idformation;
	}

	public void setIdformation(Long idformation) {
		this.idformation = idformation;
	}
	
	public String getEntitled() {
		return entitled;
	}

	public void setEntitled(String entitled) {
		this.entitled = entitled;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
		return "Formation [idformation=" + idformation + ", entitled=" + entitled + ", date=" + date + ", persons="
				+ persons + "]";
	}

	@Override
	public int compareTo(Formation o) {
		return -o.getDate().compareTo(date);
	}
	
}

package com.springmvc.bo;

import java.io.Serializable;

import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="behaviour")
public class Behaviour implements Serializable, Comparable<Behaviour>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8292391982950006007L;
	private Long idbehavioral_competence;
	private String strong_points;
	private String areas_improvement;
	private Person persones;
	
	public Behaviour() {
		super();
	}
	
	
	
	public Behaviour(Long idbehavioral_competence, String strong_points, String areas_improvement, Person persones) {
		super();
		this.idbehavioral_competence = idbehavioral_competence;
		this.strong_points = strong_points;
		this.areas_improvement = areas_improvement;
		this.persones = persones;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdbehavioral_competence() {
		return idbehavioral_competence;
	}



	public void setIdbehavioral_competence(Long idbehavioral_competence) {
		this.idbehavioral_competence = idbehavioral_competence;
	}



	public String getStrong_points() {
		return strong_points;
	}



	public void setStrong_points(String strong_points) {
		this.strong_points = strong_points;
	}



	public String getAreas_improvement() {
		return areas_improvement;
	}



	public void setAreas_improvement(String areas_improvement) {
		this.areas_improvement = areas_improvement;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@ManyToOne
	@JoinColumn(name="persons_id")
	public Person getPersones() {
		return persones;
	}

	public void setPersones(Person persones) {
		this.persones = persones;
	}
	

	@Override
	public String toString() {
		return "Behaviour [idbehavioral_competence=" + idbehavioral_competence + ", strong_points=" + strong_points
				+ ", areas_improvement=" + areas_improvement + ", persones=" + persones + "]";
	}



	@Override
	public int compareTo(Behaviour o) {
		return -o.getStrong_points().compareTo(strong_points);
	}

}

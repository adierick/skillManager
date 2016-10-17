package com.springmvc.bo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="position")
public class Position implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 742565229035677744L;
	
	private Long id;
	private String code;
	private String trs_label_key;
	private List<Person> persons;
	
	
	
	public Position() {
		super();
	}
	public Position(Long idposition, String code, String trs_label_key, List<Person> persons) {
		super();
		this.id = idposition;
		this.code = code;
		this.trs_label_key = trs_label_key;
		this.persons = persons;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTrs_label_key() {
		return trs_label_key;
	}
	public void setTrs_label_key(String trs_label_key) {
		this.trs_label_key = trs_label_key;
	}
	
	@OneToMany
	@JoinColumn(name="position_id")
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	@Override
	public String toString() {
		return code;
	}

}

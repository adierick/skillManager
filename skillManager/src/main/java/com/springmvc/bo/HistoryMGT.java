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
@Table(name="history_mgt")

public class HistoryMGT implements Serializable, Comparable<HistoryMGT>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7060228290423985513L;
	private Long idhistory_MGT;
	private String personality_type;
	private String smil;
	private String maturity_employee;
	private String management_style;
	private String management_apply;
	private Person persons_id;

	public HistoryMGT() {
		super();
	}

	public HistoryMGT(Long idhistory_MGT, String personality_type, String smil, String maturity_employee,
			String management_style, String management_apply, Person persons_id) {
		super();
		this.idhistory_MGT = idhistory_MGT;
		this.personality_type = personality_type;
		this.smil = smil;
		this.maturity_employee = maturity_employee;
		this.management_style = management_style;
		this.management_apply = management_apply;
		this.persons_id = persons_id;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdhistory_MGT() {
		return idhistory_MGT;
	}

	public void setIdhistory_MGT(Long idhistory_MGT) {
		this.idhistory_MGT = idhistory_MGT;
	}

	public String getPersonality_type() {
		return personality_type;
	}

	public void setPersonality_type(String personality_type) {
		this.personality_type = personality_type;
	}

	public String getSmil() {
		return smil;
	}

	public void setSmil(String smil) {
		this.smil = smil;
	}

	public String getMaturity_employee() {
		return maturity_employee;
	}

	public void setMaturity_employee(String maturity_employee) {
		this.maturity_employee = maturity_employee;
	}

	public String getManagement_style() {
		return management_style;
	}

	public void setManagement_style(String management_style) {
		this.management_style = management_style;
	}

	public String getManagement_apply() {
		return management_apply;
	}

	public void setManagement_apply(String management_apply) {
		this.management_apply = management_apply;
	}

	@ManyToOne
	@JoinColumn(name="persons_id")
	public Person getPersons_id() {
		return persons_id;
	}

	public void setPersons_id(Person persons_id) {
		this.persons_id = persons_id;
	}

	@Override
	public String toString() {
		return "HistoryMGT [idhistory_MGT=" + idhistory_MGT + ", personality_type=" + personality_type + ", smil="
				+ smil + ", maturity_employee=" + maturity_employee + ", management_style=" + management_style
				+ ", management_apply=" + management_apply + ", persons_id=" + persons_id + "]";
	}

	@Override
	public int compareTo(HistoryMGT o) {
		return -o.getSmil().compareTo(smil);
	}
	
}

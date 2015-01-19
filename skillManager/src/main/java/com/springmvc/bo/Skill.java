package com.springmvc.bo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="skill")
@NamedQuery(
		name="findSkillByPerson",
		query="from Skill where person = :person")
public class Skill implements Serializable, Comparable {

	/**
	 * id
	 * code
	 * trs_label_key
	 */
	private static final long serialVersionUID = 5055674721689271473L;
	private Long id;
	private Person person;
	private Item item;
	private Integer level;
	
	
	/**
	 * 
	 * @param id
	 * @param code
	 * @param translate
	 */
	public Skill(Person person, Item item, Integer level) {
		super();
		this.person = person;
		this.item=item;
		this.level=level;
	}
	
	public Skill() {}
	
	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name="person_id")
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@ManyToOne
	@JoinColumn(name="item_id")
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String toString() {
		return this.person + ":" + this.item + "=" + this.level;
	}

	public int compareTo(Object s) {
		if(s instanceof Skill) {
			if(this.item!=null && this.item.getCode()!=null
					&& ((Skill) s).item!=null && ((Skill) s).item.getCode()!=null) {
				return this.item.getCode().compareTo(((Skill) s).item.getCode());
			} 
		}
		return 0;
	}
}

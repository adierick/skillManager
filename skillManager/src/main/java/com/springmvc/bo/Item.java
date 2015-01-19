package com.springmvc.bo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="item")
@NamedQuery(
		name="findItemByCategory",
		query="from Item where category = :category")
public class Item implements Serializable {

	/**
	 * id
	 * code
	 * trs_label_key
	 */
	private static final long serialVersionUID = 5055674721689271473L;
	private Long id;
	private String code;
	private String trs_label_key;
	private Category category;
	
	private List<Skill> skills;
	
	/**
	 *  
	 * @param code
	 * @param translate
	 * @param category
	 */
	public Item(String code, String trs_label_key, Category category) {
		super();
		this.code = code;
		this.trs_label_key = trs_label_key;
		this.category=category;
	}
	
	public Item() {}
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
	
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	
	@OneToMany(cascade={CascadeType.REMOVE})
	@JoinColumn(name="item_id")
	public List<Skill> getSkills() {
		return skills;
	}
	
	/**
	 * @return the category
	 */
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return this.code + " (" + this.trs_label_key + ")";
	}


}

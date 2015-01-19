package com.springmvc.bo;

//Création OD 2014/12/19

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "category")
public class Category implements Serializable {
	/**
	 * id code trs_label_key
	 */
	private static final long serialVersionUID = 5055674721689271473L;
	private Long id;
	private String code;
	private String trs_label_key;
	private List<Item> items;

	@OneToMany
	@JoinColumn(name="id")
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Category() {
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
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

	@Override
	public String toString() {
		return this.code + " (" + this.trs_label_key + ")";
	}

}

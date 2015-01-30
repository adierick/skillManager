package com.springmvc.bo;

//CrÃ©ation OD 2014/12/19

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


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

	public Category() {}

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
		
	@OneToMany (mappedBy="category")
	@Cascade({CascadeType.DELETE,CascadeType.SAVE_UPDATE})
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}	

	@Override
	public String toString() {
		return this.code + " (" + this.trs_label_key + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result
				+ ((trs_label_key == null) ? 0 : trs_label_key.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (trs_label_key == null) {
			if (other.trs_label_key != null)
				return false;
		} else if (!trs_label_key.equals(other.trs_label_key))
			return false;
		return true;
	}

}

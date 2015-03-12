package com.springmvc.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="picture")
public class Picture {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String picture_name;
	private byte[] picture_data;
	
	
	
	public Picture() {
		
	}
	
	
	public Picture(String picture_name, byte[] picture_data) {
		this.picture_name = picture_name;
		this.picture_data = picture_data;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the picture_name
	 */
	public String getPicture_name() {
		return picture_name;
	}
	/**
	 * @param picture_name the picture_name to set
	 */
	public void setPicture_name(String picture_name) {
		this.picture_name = picture_name;
	}
	/**
	 * @return the picture_data
	 */
	
	@OneToMany
	@JoinColumn(name="id_picture")
	public byte[] getPicture_data() {
		return picture_data;
	}
	/**
	 * @param picture_data the picture_data to set
	 */
	public void setPicture_data(byte[] picture_data) {
		this.picture_data = picture_data;
	}


}

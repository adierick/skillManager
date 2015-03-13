package com.springmvc.formdata;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class PictureFormData {
	
	
	private String picture_name;
	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getPicture_name() {
		return picture_name;
	}

	public void setPicture_name(String picture_name) {
		this.picture_name = picture_name;
	}

	
	public PictureFormData() {
			
		}

	public PictureFormData(String picture_name, MultipartFile file) {
		super();
		this.picture_name = picture_name;
		this.file = file;
	}
	
	

}

package com.springmvc.formdata;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.springmvc.bo.Picture;

@Component
public class PictureFormData {
	
	@Valid
	private Picture picture;

	public PictureFormData(Picture picture) {
		this.picture = picture;
	}
	
	public PictureFormData() {
		
	}

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

}

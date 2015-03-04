package com.springmvc.services.impl;

import java.util.Collection;
import java.util.List;

import com.springmvc.bo.Picture;
import com.springmvc.services.PictureService;
import com.springmvc.services.Service;

public class PictureServiceImpl extends Service implements PictureService {



	@Override
	public void savePicture(Picture picture) {
		getSession().save(picture);
		
	}

	@Override
	public void deletePicture(Picture picture) {
		getSession().delete(picture);
		
	}
	
	@Override
	public Picture getPicture(String picture_name) {
		return (Picture) getSession().get(Picture.class, picture_name);
	}

	@Override
	public List<Picture> find(String criteria, int rowStart, int numberResults) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Picture> find(String criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

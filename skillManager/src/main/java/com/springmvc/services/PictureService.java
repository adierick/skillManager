package com.springmvc.services;

import java.util.List;

import com.springmvc.bo.Picture;

public interface PictureService extends ISearchService<Picture> {
	
	public void updatePicture (Picture picture);
	public Picture savePicture (Picture picture);
	public Picture getPicture(String picture_name);
	public List<Picture> listeAllPictures();

}

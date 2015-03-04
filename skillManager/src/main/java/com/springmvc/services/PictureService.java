package com.springmvc.services;

import com.springmvc.bo.Picture;

public interface PictureService extends ISearchService<Picture> {
	
	public void savePicture (Picture picture);
	public void deletePicture (Picture picture);
	public Picture getPicture (String picture_name);

}

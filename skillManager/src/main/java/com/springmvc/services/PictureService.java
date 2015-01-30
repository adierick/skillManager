package com.springmvc.services;

import com.springmvc.bo.Picture;

public interface PictureService extends ISearchService<Picture> {
	
	void save(Picture picture);

}

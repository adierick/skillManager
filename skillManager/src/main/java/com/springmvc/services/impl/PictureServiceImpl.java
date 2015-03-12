package com.springmvc.services.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.bo.Picture;
import com.springmvc.services.PictureService;
import com.springmvc.services.Service;


@Component
@Transactional
public class PictureServiceImpl extends Service implements PictureService {



	@Override
	public void updatePicture(Picture picture) {
		getSession().merge(picture);
		
	}
	
	@Override
	public Picture savePicture(Picture picture) {
		getSession().save(picture);
		return picture;
	}
	
	@Override
	public Picture getPicture(String picture_name) {
		Criteria sqlCriteria = getSession().createCriteria(Picture.class);
		sqlCriteria.add(Restrictions.eq("picture_name", picture_name));
		
		List result = sqlCriteria.list();
		
		if(result.size()==0) {
			return null;
		}
		
		return (Picture) sqlCriteria.list().get(0);
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

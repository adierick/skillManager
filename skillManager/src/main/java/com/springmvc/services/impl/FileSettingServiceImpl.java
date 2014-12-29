package com.springmvc.services.impl;

import org.hibernate.Criteria;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.bo.FileSetting;
import com.springmvc.services.FileSettingService;
import com.springmvc.services.Service;

@Component
@Transactional
public class FileSettingServiceImpl extends Service implements FileSettingService{

	
	public void updateFile(FileSetting file) {
		getSession().update(file);
		
	}

	
	public FileSetting createFile(FileSetting file) {
		 return (FileSetting)getSession().save(file);
	}

	
	public FileSetting getFile(int id) {
		return (FileSetting) getSession().get(FileSetting.class, id);
	}

	
	public void deleteFile(int id) {
		getSession().delete(getFile(id));
		
	}

	
	public int fileCount() {
		Criteria sqlCriteria = getSession().createCriteria(FileSetting.class);
		
		return sqlCriteria.list().size();
	}


	

}

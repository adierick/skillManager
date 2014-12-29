package com.springmvc.services;

import com.springmvc.bo.FileSetting;

public interface FileSettingService {

	public void updateFile(FileSetting file);
	
	public FileSetting createFile(FileSetting file);
	
	public FileSetting getFile(int id);
	
	public void deleteFile(int id);
	
	
	public int fileCount();
}

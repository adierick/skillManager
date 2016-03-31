package com.springmvc.services;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.bo.Mission;

@Component
@Transactional
public class ServiceMission implements IServiceMission{
	public List<Mission> listeMission(){
		return null;
	}
}

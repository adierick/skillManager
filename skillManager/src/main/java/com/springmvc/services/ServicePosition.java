package com.springmvc.services;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.bo.Position;
import com.springmvc.services.IServicePosition;

@Component
@Transactional
public class ServicePosition implements IServicePosition{

		public List<Position> listePosition(){
			return null;
		}
}

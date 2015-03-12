package com.springmvc.web;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.springmvc.Context;
import com.springmvc.IConstants;
import com.springmvc.bo.Person;
import com.springmvc.bo.Picture;
import com.springmvc.formdata.PictureFormData;
import com.springmvc.services.PersonService;
import com.springmvc.services.PictureService;
import com.springmvc.services.impl.PictureServiceImpl;


@Controller
@RequestMapping("/person/*")
public class PictureController {

	private final PictureService pictureService = Context.getInstance().getApplicationContext().getBean(PictureService.class);
	private final PersonService personService = Context.getInstance().getApplicationContext().getBean(PersonService.class);
	
	private static final String LOAD_PICTURE_PATH = "C:/Users/jmasset/Pictures";
	private static final String SUCCESS_FORM = "person/uploadPicture"; 
	private static final String SUCCESS_EDIT = "person/editionPerson";
	private static final String ERROR_FORWARD = "redirect:"+"/main/login/login.do";
	
	public PictureController() {
		super();
	}
	
	
	@RequestMapping(value="/person/uploadPicture.do")
	public String formUploadPicture(Model model, HttpSession session, HttpServletRequest request) throws Exception {
		model.addAttribute("picture", new PictureFormData());
		
		URL resource = this.getClass().getClassLoader().getResource("/img/person-avatar.png");
		
//		Person connected = (Person) session.getAttribute(IConstants.USER_SESSION);
//		Picture pictureToDisplay = pictureService.getPicture(connected.getMatricule());
		
		InputStream fis= resource.openStream();
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		int b;
		byte[] buffer = new byte[1024];
		while((b=fis.read(buffer))!=-1){
		   bos.write(buffer,0,b);
		}
		byte[] fileBytes=bos.toByteArray();
		fis.close();
		bos.close();
		
		byte [] encoded = Base64.encode(fileBytes);
		String encodedString = new String (encoded);
		
		model.addAttribute("Img", encodedString);
		
		
		
		return SUCCESS_FORM;
	}
	/*
	@RequestMapping(value="/person/loadPicture.do", method = RequestMethod.POST)
	public String loadPicture(HttpSession session, HttpServletRequest request, @RequestParam MultipartFile file) throws IllegalStateException, IOException {
		
		if (!(file == null && file.getOriginalFilename().equals(""))) {
			
			file.transferTo(new File (LOAD_PICTURE_PATH + file.getOriginalFilename()));
			return SUCCESS_EDIT;
			
		} else {
			return ERROR_FORWARD;
		}
		
	}
	*/
	
//	@RequestMapping(value="/person/loadPicture.do", method = RequestMethod.POST)
//	public String loadPicture(HttpServletRequest request, @RequestParam CommonsMultipartFile [] file, @ModelAttribute("picture") Picture pictureToLoad, BindingResult binding) throws Exception {
//		
//		for (CommonsMultipartFile aFile : file) {
//			
//			if (file != null && file.length > 0) {
//				pictureToLoad.setPicture_name(aFile.getOriginalFilename());
//				pictureToLoad.setPicture_data(aFile.getBytes());
//				pictureService.savePicture(pictureToLoad);
//			}
//		}
//		
//		return SUCCESS_EDIT;
//	}
	
	@RequestMapping(value="/person/loadPicture.do", method = RequestMethod.POST)
	public String loadPicture(@ModelAttribute("picture") PictureFormData pictureToLoad, @RequestParam("file") MultipartFile file, BindingResult binding, Model model, HttpSession session, HttpServletRequest request) throws Exception {
	
	Person connected = (Person) session.getAttribute(IConstants.USER_SESSION);	
	byte [] encoded = Base64.encode(pictureToLoad.getFile().getBytes());
	Picture pictureToSave = new Picture();
	pictureToSave.setPicture_name(connected.getMatricule());
	pictureToSave.setPicture_data(pictureToLoad.getFile().getBytes());
	pictureService.savePicture(pictureToSave);
	
	String encodedString = new String (encoded);
	
	model.addAttribute("Img", encodedString);
//			if (file != null && file.getSize() > 0) {
//				byte [] bytes = file.getBytes();
//				pictureToLoad.setPicture_name(file.getOriginalFilename());
//				pictureToLoad.setPicture_data(file.getBytes());
//				pictureService.savePicture(pictureToLoad);
//			}
		
		
		return SUCCESS_FORM;
	}

}
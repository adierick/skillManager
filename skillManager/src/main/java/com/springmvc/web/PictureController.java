package com.springmvc.web;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springmvc.Context;
import com.springmvc.IConstants;
import com.springmvc.bo.Person;
import com.springmvc.bo.Picture;
import com.springmvc.formdata.PictureFormData;
import com.springmvc.services.PersonService;
import com.springmvc.services.PictureService;


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
		Person connected = (Person) session.getAttribute(IConstants.USER_SESSION);
		Picture picture = pictureService.getPicture(connected.getMatricule());
		byte [] fileBytes = null;

		if (picture == null) {

			InputStream fis= Context.getInstance().getApplicationContext().getResource("classpath:person-avatar.png").getInputStream();
			ByteArrayOutputStream bos=new ByteArrayOutputStream();
			int b;
			byte[] buffer = new byte[1024];
			while((b=fis.read(buffer))!=-1){
				bos.write(buffer,0,b);
			}
			fileBytes=bos.toByteArray();
			fis.close();
			bos.close();


		}
		else {
			fileBytes = picture.getPicture_data();
		}

		byte [] encoded = Base64.encode(fileBytes);
		String encodedString = new String (encoded);

		model.addAttribute("Img", encodedString);





		return SUCCESS_FORM;
	}

//	@RequestMapping(value="/person/loadPicture.do", method = RequestMethod.POST)
//	public String loadPicture(@ModelAttribute("picture") PictureFormData pictureToLoad, @RequestParam("file") MultipartFile file, BindingResult binding, Model model, HttpSession session, HttpServletRequest request) throws Exception {
//
//		Person connected = (Person) session.getAttribute(IConstants.USER_SESSION);	
//		byte [] encoded = Base64.encode(pictureToLoad.getFile().getBytes());
//		Picture pictureToSave = new Picture();
//		pictureToSave.setPicture_name(connected.getMatricule());
//		pictureToSave.setPicture_data(pictureToLoad.getFile().getBytes());
//		pictureService.savePicture(pictureToSave);
//
//		String encodedString = new String (encoded);
//
//		model.addAttribute("Img", encodedString);
//
//		return SUCCESS_FORM;
//	}

}
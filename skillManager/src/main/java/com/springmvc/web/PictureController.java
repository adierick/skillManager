package com.springmvc.web;

import java.io.ByteArrayInputStream;
import java.io.IOException;







import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springmvc.Context;
import com.springmvc.bo.Picture;
import com.springmvc.services.PictureService;


@Controller
@RequestMapping("/picture/*")
public class PictureController {
	
	private final PictureService service = Context.getInstance().getApplicationContext().getBean(PictureService.class);

	private static final String ERROR_FORWARD = "redirect:"+"/main/login/login.do";
	private static final String SUCCESS_EDIT = "person/editionPerson";
	
	public PictureController() {
		super();
	}
	
	@RequestMapping(value="/picture/pictureUpload", method = RequestMethod.POST)
	public String uploadPicture (@RequestParam("picture_name") String picture_name, @RequestParam("file") MultipartFile file) throws IOException {
		if(!file.isEmpty()) {
			Picture picture = service.getPicture(picture_name);
			byte [] pictureToUpload = IOUtils.toByteArray(file.getInputStream());
			picture.setPicture_data(pictureToUpload);
			service.savePicture(picture);
			
			return SUCCESS_EDIT;
		}
		else {
			return ERROR_FORWARD;
		}	
		
	}
	
	@RequestMapping(value = "/picture/imageDisplay", method = RequestMethod.GET)
	  public void displayPicture (@RequestParam("picture_name") String picture_name, HttpServletResponse response,HttpServletRequest request) 
	          throws ServletException, IOException{
		
		Picture picture = service.getPicture(picture_name);
		if (picture.getPicture_name() == null) {
			response.sendRedirect(request.getContextPath() + "img/main/avatar.png");
		}
		else {
			OutputStream out = response.getOutputStream();
			IOUtils.copy(new ByteArrayInputStream(picture.getPicture_data()), out);
			
			out.flush();
			out.close();
		}

	
	}
	

}



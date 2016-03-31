package com.springmvc.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.ui.Model;

import com.springmvc.Context;
import com.springmvc.IConstants;
import com.springmvc.bo.Person;
import com.springmvc.bo.Picture;
import com.springmvc.formdata.PersonFormData;
import com.springmvc.formdata.PictureFormData;
import com.springmvc.services.PersonService;
import com.springmvc.services.PictureService;

public class PersonUtils {
	
	public static final String SUCCESS_EDIT = "person/editionPersonFull";
	public static final String ERROR_FORWARD = "redirect:"+"/main/login/login.do";

	public static String loadPersonDetail(String matricule, Model model, HttpSession session, HttpServletRequest request, 
			PersonService service, PictureService pictureService) throws IOException {
		Security secure = Security.getInstance();
		if (secure.verifyPersoOrAdmin(matricule, session, request)){
			Person personForForm = service.getPerson(matricule);
			model.addAttribute("person", new PersonFormData(personForForm));
			model.addAttribute("type", "update");
			session.setAttribute(IConstants.ID_COLLAB, personForForm.getId());

			try {
				formUploadPicture(matricule, model, session, request, pictureService);
			} catch (Exception e) {

				e.printStackTrace();
			}

			return SUCCESS_EDIT;
		} else {
			return ERROR_FORWARD;
		}
	}
	
	public static String loadPersonDetailAsAdmin(String matricule, Model model, HttpSession session, HttpServletRequest request, 
			PersonService service, PictureService pictureService) throws IOException {
		Security secure = Security.getInstance();
		if (secure.verifyPersoOrAdmin(matricule, session, request)){
			Person personForForm = service.getPerson(matricule);
			model.addAttribute("person", new PersonFormData(personForForm));
			model.addAttribute("type", "update");
			session.setAttribute(IConstants.ID_COLLAB, personForForm.getId());

			try {
				formUploadPicture(matricule, model, session, request, pictureService);

			} catch (Exception e) {

				e.printStackTrace();
			}

			if(secure.verifyAdmin(session, request)){
				return SUCCESS_EDIT;
			}else{
				return ERROR_FORWARD;
			}
		} else {
			return ERROR_FORWARD;
		}
	}


	public static void formUploadPicture(String matricule, Model model, HttpSession session, HttpServletRequest request, PictureService pictureService) throws Exception {
		model.addAttribute("picture", new PictureFormData());

		Picture picture = pictureService.getPicture(matricule);
		byte [] fileBytes = null;

		if (picture == null) {

			InputStream fis= Context.getInstance().getApplicationContext().getResource("classpath:person-avatar1.png").getInputStream();
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
		//Add attribute here in aim to add this field each time we load a picture to keep the current editing matricule
		model.addAttribute("selectedMatricule", matricule);

	}
}

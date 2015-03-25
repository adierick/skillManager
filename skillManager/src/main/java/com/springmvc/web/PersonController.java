/*
 * File: PersonController.java
 *
 * Goal: .
 *
 * History:
 * //  Creation of the file (ADI)
 */
package com.springmvc.web;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.util.encoders.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springmvc.Context;
import com.springmvc.IConstants;
import com.springmvc.bo.BusinessUnit;
import com.springmvc.bo.Person;
import com.springmvc.bo.Picture;
import com.springmvc.formdata.PersonFormData;
import com.springmvc.formdata.PersonFormDataAdmin;
import com.springmvc.formdata.PictureFormData;
import com.springmvc.services.PersonService;
import com.springmvc.services.PictureService;
import com.springmvc.utils.ITranslations;
import com.springmvc.utils.MyBlowfish;
import com.springmvc.utils.Security;
import com.springmvc.utils.Translation;
import com.springmvc.web.editor.BusinessUnitEditor;

/**
 * The Class PersonController.
 *
 * @author adi
 * @version 5.1, //2014
 */
@Controller
@RequestMapping("/person/*")
public class PersonController {

	/** The liste persons. */
	private List<Person> listePersons;
	private List<Picture> listePictures;
	
	/** The service. */
	private final PersonService service = Context.getInstance().getApplicationContext().getBean(PersonService.class);
	private final PictureService pictureService = Context.getInstance().getApplicationContext().getBean(PictureService.class);

	private static final String ERROR_FORWARD = "redirect:"+"/main/login/login.do";
	private static final String SUCCESS_LIST = "person/listePersons";
	/** Modification view for admin*/
	private static final String SUCCESS_EDIT = "person/editionPerson";
	/** Modification view for collaborator (restrict field)*/
	private static final String SUCCESS_COLAB_EDIT= "person/editionPersonCollab";
	private static final String TROMBINOSCOPE = "person/trombinoscope";
	
	/**
	 * Constructor for person controller.
	 */
	public PersonController() {
		super();
	} 
	
	/**
	 * Liste persons.
	 *
	 * @param model the model
	 * @throws IOException 
	 */
	@RequestMapping(value="/person/listePersons.do")
	public String listePersons(Model model, HttpSession session, HttpServletRequest request) throws IOException{

		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {
			listePersons = service.listeAllPersons();
			model.addAttribute("personsList", listePersons);
			
			return SUCCESS_LIST;
		} else {
			return ERROR_FORWARD;
		}
	}
	
	/**
	 * Person detail.
	 *
	 * @param id the id
	 * @param model the model
	 * @throws IOException 
	 */
	@RequestMapping(method=RequestMethod.GET, value="/person/editionPerson.do")
	public String personDetail(@RequestParam("matricule") String matricule, Model model ,HttpSession session, HttpServletRequest request) throws IOException {
		boolean isAdmin = Security.getInstance().verifyAdmin(session, request);
		if (isAdmin) {
			return loadPersonDetailAsAdmin(matricule, model, session, request);
		}
		return loadPersonDetail(matricule, model, session, request);
		
		
	}

	private String loadPersonDetail(String matricule, Model model, HttpSession session, HttpServletRequest request) throws IOException {
		Security secure = Security.getInstance();
		if (secure.verifyPersoOrAdmin(matricule, session, request)){
			Person personForForm = service.getPerson(matricule);
			model.addAttribute("person", new PersonFormData(personForForm));
			model.addAttribute("type", "update");
			session.setAttribute(IConstants.ID_COLLAB, personForForm.getId());
			
			try {
				this.formUploadPicture(matricule, model, session, request);
			} catch (Exception e) {
			
				e.printStackTrace();
			}
			
			return SUCCESS_COLAB_EDIT;
		} else {
			return ERROR_FORWARD;
		}
	}
	
	/**
	 * Person detail.
	 *
	 * @param id the id
	 * @param model the model
	 * @throws IOException 
	 */
	@RequestMapping(method=RequestMethod.GET, value="/person/editionPersonAsAdmin.do")
	public String personDetailAsAdmin(@RequestParam("matricule") String matricule, Model model ,HttpSession session, HttpServletRequest request) throws IOException {
		
		return loadPersonDetailAsAdmin(matricule, model, session, request);
		
		
	}

	private String loadPersonDetailAsAdmin(String matricule, Model model, HttpSession session, HttpServletRequest request) throws IOException {
		Security secure = Security.getInstance();
		if (secure.verifyPersoOrAdmin(matricule, session, request)){
			Person personForForm = service.getPerson(matricule);
			model.addAttribute("person", new PersonFormData(personForForm));
			model.addAttribute("type", "update");
			session.setAttribute(IConstants.ID_COLLAB, personForForm.getId());
			
			try {
				this.formUploadPicture(matricule, model, session, request);
				
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
	
	
	private void formUploadPicture(String matricule, Model model, HttpSession session, HttpServletRequest request) throws Exception {
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
	

	@RequestMapping(value="/person/loadPicture.do", method = RequestMethod.POST)
	public String loadPicture(@ModelAttribute("picture") PictureFormData pictureToLoad,  @RequestParam("file") MultipartFile file, BindingResult binding, Model model, HttpSession session, HttpServletRequest request) throws Exception {
		// get the current matricule parameter from the request
		String selectedMatricule = request.getParameter("selectedMatricule");
		
		// get the corresponding picture if exist
		Picture picture = pictureService.getPicture(selectedMatricule);
		Picture pictureToSave = null;
		
		if (picture == null) {
			pictureToSave = new Picture();
		}
		else {
			pictureToSave = picture;
		}
		
		// update the matricule value with the current
		pictureToSave.setPicture_name(selectedMatricule);
		// update the file data
		pictureToSave.setPicture_data(pictureToLoad.getFile().getBytes());
		
		// rezise the picture as default value
		try {
			BufferedImage imageToResize = ImageIO.read(new ByteArrayInputStream(pictureToSave.getPicture_data()));
			imageToResize = resizePersonPicture(imageToResize, 150, 150);
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(imageToResize, "jpg", baos);
			baos.flush();
			byte[] imageInByte = baos.toByteArray();
			baos.close();
			pictureToSave.setPicture_data(imageInByte);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// save picture in database
		pictureService.updatePicture(pictureToSave);
		
		boolean isAdmin = Security.getInstance().verifyAdmin(session, request);
		if (isAdmin) {
			return loadPersonDetailAsAdmin(selectedMatricule, model, session, request);
		}
		
		return loadPersonDetail(selectedMatricule, model, session, request);

	}
	/**
	 * Resize automatically Person picture to 150*150 px and get better quality after resizing
	 * 
	 * @param image
	 * @param img_width
	 * @param img_height
	 * @return
	 */
	private static BufferedImage resizePersonPicture (BufferedImage image, int img_width, int img_height) {
		
		BufferedImage resizedPersonPicture = new BufferedImage(img_width, img_height, BufferedImage.TYPE_INT_RGB);
		Graphics2D graph = resizedPersonPicture.createGraphics();
		graph.drawImage(image, 0, 0, img_width, img_height, null);
		graph.dispose();
		graph.setComposite(AlphaComposite.Src);
		graph.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		graph.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		return resizedPersonPicture;
	}
	
	@RequestMapping(value="/person/showTrombinoscope.do", method=RequestMethod.GET)
	public String showTrombinoscope(@ModelAttribute("person") Person person, @ModelAttribute("picture") Picture picture, BindingResult binding, Model model, HttpSession session, HttpServletRequest request) throws IOException {
		
//			model.addAttribute("picturesList", listePictures);
//			model.addAttribute("personsList", listePersons);
//			
//			listePictures = pictureService.listeAllPictures();
//			listePersons = service.listeAllPersons();
//			
//			for (Person personList : listePersons) {
//				
//			}
//			
//			List<String> listEncodedString = new ArrayList<String>();
//			for (Picture pictureList : listePictures) {
//				
//			
//				byte [] encoded = Base64.encode(pictureList.getPicture_data());
//				String encodedString = new String (encoded);
//				listEncodedString.add(encodedString);
//				
//				model.addAttribute("Img", listEncodedString);
//			
//			}	
//				
//
//				model.addAttribute("ImgList", listEncodedString);
			
			
			
		
		return TROMBINOSCOPE;
		
	}
	
	/**
	 * Update person.
	 *
	 * @param person the person
	 * @param model the model
	 * @return the string
	 * @throws IOException 
	 */
	@RequestMapping(method=RequestMethod.POST, value="/person/update.do")
	public String updatePerson(@ModelAttribute("person") @Valid PersonFormData person, @ModelAttribute("picture") @Valid PictureFormData picture, BindingResult binding, Model model, HttpSession session, HttpServletRequest request) throws IOException {
		
		Person personForMerge;
		Security secure = Security.getInstance();
		if (secure.verifyLogin(request)) {
			
			if(binding.hasErrors()) {
				model.addAttribute("type", "update");
				return SUCCESS_COLAB_EDIT;	
			}else{
				personForMerge = service.getPerson((Long)session.getAttribute(IConstants.ID_COLLAB));
			}
			
			MyBlowfish bf = new MyBlowfish();
		    bf.setSecretKey(IConstants.CRYPT_PWD);
		    personForMerge.setPassword(new BigInteger(bf.crypt(person.getFirstPassword())).toString());
		    personForMerge.setEmail(person.getPerson().getEmail());
		    //personForMerge.setPicture(person.getPerson().getPicture());
			Person personMerged = service.mergePerson(personForMerge);
			session.setAttribute(IConstants.USER_SESSION, personMerged);
			
			
			model.addAttribute(IConstants.VALIDATION_MSG, Translation.getInstance().getTranslation(ITranslations.PERSONNAL_DATA_SAVED));
			return SUCCESS_COLAB_EDIT;

		}
		else return ERROR_FORWARD;

	}
	
	/**
	 * @param person
	 * @param binding
	 * @param model
	 * @param session
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(method=RequestMethod.POST, value="/person/updateAsAdmin.do")
	public String updatePersonAsAdmin(@ModelAttribute("person") @Valid PersonFormDataAdmin person, @ModelAttribute("picture") @Valid PictureFormData picture, BindingResult binding, Model model, HttpSession session, HttpServletRequest request) throws IOException{
		
		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {
			Person connected;
			Person personForm;
			
			if(binding.hasErrors()) {
				model.addAttribute("type", "update");
				return SUCCESS_EDIT;
			}else{
				connected = (Person) session.getAttribute(IConstants.USER_SESSION);
				personForm = person.getPerson();
				personForm.setId((Long)session.getAttribute(IConstants.ID_COLLAB));
			}
			
			if(!StringUtils.isBlank(person.getFirstPassword())){
				MyBlowfish bf = new MyBlowfish();
			    bf.setSecretKey(IConstants.CRYPT_PWD);
			    personForm.setPassword(new BigInteger(bf.crypt(person.getFirstPassword())).toString());
			}else{
				/** retrieve the current password if any new was send*/
				personForm.setPassword(service.getPerson((Long)session.getAttribute(IConstants.ID_COLLAB)).getPassword());
			}
			
			personForm.setEmail(person.getPerson().getEmail());
			Person personMerged = service.mergePerson(personForm);
			if(connected.getId().equals(session.getAttribute(IConstants.ID_COLLAB))) {
				session.setAttribute(IConstants.USER_SESSION, personMerged);
			}		
			
			model.addAttribute(IConstants.VALIDATION_MSG, Translation.getInstance().getTranslation(ITranslations.PERSONNAL_DATA_SAVED));
			return SUCCESS_EDIT;
			
		}
		else return ERROR_FORWARD;
	}
	
	/**
	 * @param person
	 * @param binding
	 * @param model
	 * @param session
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(method=RequestMethod.POST, value="/person/createAsAdmin.do")
	public String createPersonAsAdmin(@ModelAttribute("person") @Valid PersonFormData person, @ModelAttribute("picture") @Valid PictureFormData picture, BindingResult binding, Model model, HttpSession session, HttpServletRequest request) throws IOException{
		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {
			Person personForm;
			
			if(binding.hasErrors()) {
				model.addAttribute("type", "create");
				return SUCCESS_EDIT;
			}else{
				personForm = person.getPerson();
			}
			
			MyBlowfish bf = new MyBlowfish();
		    bf.setSecretKey(IConstants.CRYPT_PWD);
		    personForm.setPassword(new BigInteger(bf.crypt(person.getFirstPassword())).toString());
		
		    service.createPerson(personForm);		
			
			model.addAttribute(IConstants.VALIDATION_MSG, Translation.getInstance().getTranslation(ITranslations.PERSONNAL_DATA_SAVED));
			return SUCCESS_EDIT;
			
		}
		else return ERROR_FORWARD;
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/person/delete.do")
	public String deletePerson(@RequestParam("matricule") String matricule, Model model, HttpSession session, HttpServletRequest request) throws IOException {
		
		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {
			service.deletePerson(matricule);
			listePersons(model,session,request);
			model.addAttribute(IConstants.VALIDATION_MSG, Translation.getInstance().getTranslation(ITranslations.PERSONNAL_DATA_DELETED));
			return SUCCESS_LIST;
		} else {
			return ERROR_FORWARD;
		}

	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/person/create.do")
	public String createPerson(Model model, HttpSession session, HttpServletRequest request) throws IOException {
		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {
			model.addAttribute("person", new PersonFormData(new Person()));
			model.addAttribute("picture", new PictureFormData());
			model.addAttribute("type", "create");
			return SUCCESS_EDIT;
		} else {
			return ERROR_FORWARD;
		}
	}
	
	
	
	/**
	 * Permet d'afficher la liste de societes dans la jsp avec ${listeSocietes}
	 * @return
	 */
	@ModelAttribute("listBu")
    public Collection<BusinessUnit> populateBusinessUnit() {
	    return service.listeAllBusinessUnits();
	}
	
	@InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(BusinessUnit.class, new BusinessUnitEditor());
    }
}

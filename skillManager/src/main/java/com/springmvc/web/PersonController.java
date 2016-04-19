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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.springmvc.bo.PersonPicture;
import com.springmvc.bo.Picture;
import com.springmvc.bo.Skill;
import com.springmvc.formdata.PersonFormData;
import com.springmvc.formdata.PersonFormDataAdmin;
import com.springmvc.formdata.PictureFormData;
import com.springmvc.services.ItemService;
import com.springmvc.services.PersonService;
import com.springmvc.services.PictureService;
import com.springmvc.services.SkillService;
import com.springmvc.utils.ITranslations;
import com.springmvc.utils.MyBlowfish;
import com.springmvc.utils.PersonUtils;
import com.springmvc.utils.Security;
import com.springmvc.utils.SkillUtils;
import com.springmvc.utils.Translation;
import com.springmvc.web.editor.BusinessUnitEditor;

/**
 * The Class PersonController.
 *
 * @author adi
 * @version 5.1, //2014
 */
@Controller
@RequestMapping(value={"/person/*", "/skill/*"})
public class PersonController {

	
	/** The liste persons. */
	private List<Person> listePersons;
	private List<Picture> listePictures;
	private final String defaultEncodedString = getDefaultEncodedPicture();

	/** The service. */
	private final PersonService servicePerson = Context.getInstance().getApplicationContext().getBean(PersonService.class);
	private final SkillService serviceSkill = Context.getInstance().getApplicationContext().getBean(SkillService.class);
	private final PictureService pictureService = Context.getInstance().getApplicationContext().getBean(PictureService.class);
	private final ItemService serviceItem = Context.getInstance().getApplicationContext().getBean(ItemService.class);

	private static final String SUCCESS_LIST = "person/listePersons";
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
			listePersons = servicePerson.listeAllPersons();
			model.addAttribute("personsList", listePersons);

			return SUCCESS_LIST;
		} else {
			return PersonUtils.ERROR_FORWARD;
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
		
		Person person = servicePerson.getPerson(matricule);
		List<Skill> listeSkills = SkillUtils.refreshListSkill(person, serviceSkill, serviceItem);
		model.addAttribute("skillsList", listeSkills);
		
		if (isAdmin) {
			return PersonUtils.loadPersonDetailAsAdmin(matricule, model, session, request, servicePerson, pictureService);
		}
		return PersonUtils.loadPersonDetail(matricule, model, session, request, servicePerson, pictureService);
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
		Person person = servicePerson.getPerson(matricule);
		List<Skill> listeSkills = SkillUtils.refreshListSkill(person, serviceSkill, serviceItem);
		model.addAttribute("skillsList", listeSkills);
		return PersonUtils.loadPersonDetailAsAdmin(matricule, model, session, request, servicePerson, pictureService);
	}
	
	/**
	 * Liste skills.
	 *
	 * @param matricule the matricule
	 * @param model the model
	 * @return 
	 */
	@RequestMapping(value="/skill/listeSkills.do")
	public String listeSkills(@RequestParam("matricule") String matricule, Model model, HttpSession session, HttpServletRequest request) throws IOException{
		Security secure = Security.getInstance();
		if (secure.verifyPersoOrAdmin(matricule,session, request)) {
			Person person = servicePerson.getPerson(matricule);
			List<Skill> listeSkills = SkillUtils.refreshListSkill(person, serviceSkill, serviceItem);
			model.addAttribute("skillsList", listeSkills);
			boolean isAdmin = Security.getInstance().verifyAdmin(session, request);
			if (isAdmin) {
				return PersonUtils.loadPersonDetailAsAdmin(matricule, model, session, request, servicePerson, pictureService);
			}
			return PersonUtils.loadPersonDetail(matricule, model, session, request, servicePerson, pictureService);
		} else {
			return PersonUtils.ERROR_FORWARD;
		}

	}
	   
	/**
	 * Update person.
	 *
	 * @param matricule the matricule
	 * @param lvl the lvl
	 * @param id the id
	 * @param itemId the item id
	 * @param model the model
	 * @param session the session
	 * @return the string
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	@RequestMapping(value="/skill/updateSkills.do")
	public String updatePerson(@RequestParam("matricule") String matricule, 
			@RequestParam("lvl") String lvl,
			@RequestParam("id") String id, 
			@RequestParam("itemId") String itemId, 
			Model model,
			HttpSession session, HttpServletRequest request) throws NumberFormatException, IOException {
		
		// get person from matricule
		Person person = servicePerson.getPerson(matricule);
		Person connected = (Person) session.getAttribute(IConstants.USER_SESSION);
		
		Skill skill = null;
		
		// authorized update only for connected user do the update
		if(person.getId().equals(connected.getId())) {
			// get level
			int level = Integer.valueOf(lvl);
			
			// get skill to update
//			if(!id.isEmpty()) {
			if(!(id==null || id.equals(""))) {
				skill = serviceSkill.getSkill(Long.parseLong(id));
			}
			// create new skill if doesn't exist yet for this item/person
			if(skill==null) {
				skill = new Skill(person, serviceItem.getItem(Long.parseLong(itemId)), level);
			}
			
			// update level
			skill.setLevel(level);
			// update skill
			if(!(id==null || id.equals(""))) {
				serviceSkill.updateSkill(skill);
			} else {
				serviceSkill.createSkill(skill);
			}
			
			// update user in session
			session.setAttribute(IConstants.USER_SESSION, person);
		}
		
		// refresh list skill
		List<Skill> listeSkills = SkillUtils.refreshListSkill(person, serviceSkill, serviceItem);
		model.addAttribute("skillsList", listeSkills);
		
		if(skill!=null) {
			model.addAttribute(IConstants.VALIDATION_MSG, Translation.getInstance().getTranslation(ITranslations.SKILL_DATA_SAVED, new Object[]{skill.getItem().getCode()}));
		}
		
//		return PersonUtils.SUCCESS_EDIT;
		boolean isAdmin = Security.getInstance().verifyAdmin(session, request);
		if (isAdmin) {
			return PersonUtils.loadPersonDetailAsAdmin(matricule, model, session, request, servicePerson, pictureService);
		}
		return PersonUtils.loadPersonDetail(matricule, model, session, request, servicePerson, pictureService);
	}

	@RequestMapping(value="/person/loadPicture.do", method = RequestMethod.POST)
	public String loadPicture(@ModelAttribute("picture") PictureFormData pictureToLoad, @RequestParam("file") MultipartFile file, BindingResult binding, Model model, HttpSession session, HttpServletRequest request) throws Exception {
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

			int initHeight = imageToResize.getHeight();
			int initWidth = imageToResize.getWidth();

			double ratio = ((double)initWidth / (double)150);
			double newHeight = initHeight / ratio;

			imageToResize = resizePersonPicture(imageToResize, 150, (int)newHeight);

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
			return PersonUtils.loadPersonDetailAsAdmin(selectedMatricule, model, session, request, servicePerson, pictureService);
		}

		return PersonUtils.loadPersonDetail(selectedMatricule, model, session, request, servicePerson, pictureService);

	}

	/**
	 * Encode pictures stored in database to display 
	 * @param picture
	 * @return
	 * @throws Exception
	 */
	private String encodePicture(Picture picture) throws Exception {

		byte [] encoded = Base64.encode(picture.getPicture_data());
		String encodedString = new String (encoded);
		return encodedString;
	}

	/**
	 * Encode default avatar to display if the parson has not a picture stored in database
	 * @return
	 */
	private String getDefaultEncodedPicture () {

		InputStream fis;
		try {
			fis = Context.getInstance().getApplicationContext().getResource("classpath:person-avatar1.png").getInputStream();

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
			String defaultEncodedString = new String (encoded);
			return defaultEncodedString;

		} catch (IOException e) {

			e.printStackTrace();
		}
		return defaultEncodedString;

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
	public String showTrombinoscope(Model model, HttpSession session, HttpServletRequest request) throws Exception {
		List<PersonPicture> listePersonsPictures = new ArrayList<PersonPicture>();
		Map<String, Picture> personsPicturesMap = new HashMap<String, Picture>();
		listePictures = pictureService.listeAllPictures();
		listePersons = servicePerson.listeAllPersons();


		for (Picture pictureInList : listePictures) {
			personsPicturesMap.put(pictureInList.getPicture_name(), pictureInList);
		}

		for (Person personInList : listePersons) {
			String matricule = personInList.getMatricule();
			List<Skill> listeSkills = SkillUtils.refreshOnlyAvailableListSkill(personInList, serviceSkill, serviceItem);
			if(personsPicturesMap.containsKey(matricule)) {
				String encodedString = encodePicture(personsPicturesMap.get(matricule));
				listePersonsPictures.add(new PersonPicture(personInList, encodedString, listeSkills));
			}
			else {
				listePersonsPictures.add(new PersonPicture(personInList, defaultEncodedString, listeSkills));
			}
		}
		model.addAttribute("personsPicturesList", listePersonsPictures);


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
				return PersonUtils.SUCCESS_EDIT;	
			}else{
				personForMerge = servicePerson.getPerson((Long)session.getAttribute(IConstants.ID_COLLAB));
			}

			MyBlowfish bf = new MyBlowfish();
			bf.setSecretKey(IConstants.CRYPT_PWD);
			personForMerge.setPassword(new BigInteger(bf.crypt(person.getFirstPassword())).toString());
			personForMerge.setEmail(person.getPerson().getEmail());
			//personForMerge.setPicture(person.getPerson().getPicture());
			Person personMerged = servicePerson.mergePerson(personForMerge);
			session.setAttribute(IConstants.USER_SESSION, personMerged);


			model.addAttribute(IConstants.VALIDATION_MSG, Translation.getInstance().getTranslation(ITranslations.PERSONNAL_DATA_SAVED));
			return PersonUtils.SUCCESS_EDIT;

		}
		else return PersonUtils.ERROR_FORWARD;

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
				return PersonUtils.SUCCESS_EDIT;
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
				personForm.setPassword(servicePerson.getPerson((Long)session.getAttribute(IConstants.ID_COLLAB)).getPassword());
			}

			personForm.setEmail(person.getPerson().getEmail());
			
			// check if a  manager doesn't exist yet for the bu
			Person personMerged = servicePerson.mergePerson(personForm);
			
			if(connected.getId().equals(session.getAttribute(IConstants.ID_COLLAB))) {
				session.setAttribute(IConstants.USER_SESSION, personMerged);
			}		

			model.addAttribute(IConstants.VALIDATION_MSG, Translation.getInstance().getTranslation(ITranslations.PERSONNAL_DATA_SAVED));
			
		
			return PersonUtils.loadPersonDetailAsAdmin(personMerged.getMatricule(), model, session, request, servicePerson, pictureService);

		}
		else return PersonUtils.ERROR_FORWARD;
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
				return PersonUtils.SUCCESS_EDIT;
			}else{
				personForm = person.getPerson();
			}

			MyBlowfish bf = new MyBlowfish();
			bf.setSecretKey(IConstants.CRYPT_PWD);
			personForm.setPassword(new BigInteger(bf.crypt(person.getFirstPassword())).toString());

			servicePerson.createPerson(personForm);		

			model.addAttribute(IConstants.VALIDATION_MSG, Translation.getInstance().getTranslation(ITranslations.PERSONNAL_DATA_SAVED));
			return PersonUtils.loadPersonDetailAsAdmin(personForm.getMatricule(), model, session, request, servicePerson, pictureService);

		}
		else return PersonUtils.ERROR_FORWARD;
	}


	@RequestMapping(method=RequestMethod.POST, value="/person/delete.do")
	public String deletePerson(@RequestParam("matricule") String matricule, Model model, HttpSession session, HttpServletRequest request) throws IOException {

		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {
			servicePerson.deletePerson(matricule);
			listePersons(model,session,request);
			model.addAttribute(IConstants.VALIDATION_MSG, Translation.getInstance().getTranslation(ITranslations.PERSONNAL_DATA_DELETED));
			return SUCCESS_LIST;
		} else {
			return PersonUtils.ERROR_FORWARD;
		}

	}


	@RequestMapping(method=RequestMethod.POST, value="/person/create.do")
	public String createPerson(Model model, HttpSession session, HttpServletRequest request) throws IOException {
		Security secure = Security.getInstance();
		if (secure.verifyAdmin(session, request)) {
			model.addAttribute("person", new PersonFormData(new Person()));
			model.addAttribute("picture", new PictureFormData());
			model.addAttribute("type", "create");
			return PersonUtils.SUCCESS_EDIT;
		} else {
			return PersonUtils.ERROR_FORWARD;
		}
	}



	/**
	 * Permet d'afficher la liste de societes dans la jsp avec ${listeSocietes}
	 * @return
	 */
	@ModelAttribute("listBu")
	public Collection<BusinessUnit> populateBusinessUnit() {
		return servicePerson.listeAllBusinessUnits();
	}

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.registerCustomEditor(BusinessUnit.class, new BusinessUnitEditor());
	}
}

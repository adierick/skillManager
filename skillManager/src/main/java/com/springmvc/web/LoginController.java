package com.springmvc.web;

import java.math.BigInteger;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springmvc.Context;
import com.springmvc.IConstants;
import com.springmvc.bo.Person;
import com.springmvc.model.Login;
import com.springmvc.services.PersonService;
import com.springmvc.utils.ITranslations;
import com.springmvc.utils.MyBlowfish;
import com.springmvc.utils.Translation;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/login/*")
public class LoginController {

	private String indexPath;
	
	private static final String ERROR_FORWARD = "login/login";
	
	private final PersonService service = Context.getInstance().getApplicationContext().getBean(PersonService.class);
	
	public LoginController() {
	}
	
	public void setIndexPath(String path) {
		indexPath = path;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String login(Model model, HttpSession session) {
		model.addAttribute("login", new Login());
		if(session.getAttribute(IConstants.USER_SESSION)!=null) {
			return indexPath;
		}
		return ERROR_FORWARD;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/login/login.do")
	public String loginForm(@ModelAttribute("login") @Valid Login login, BindingResult binding, Model model, HttpSession session) {
		if(session.getAttribute(IConstants.USER_SESSION)!=null) {
			return indexPath;
		}
		
		if(binding.hasErrors()){
			
			System.out.println(binding.getErrorCount()+" erreurs !");
			
			return ERROR_FORWARD;
		}
		
		if(!(login.getPassword()==null || login.getPassword().equals(""))) {
//		if(!login.getPassword().isEmpty()) {
			for (Person person : service.listeAllPersons()) {
				String trigram = person.getLogin();
				
				/*EncryptDecrypt encryptDecrypt = EncryptDecrypt.getInstance();
				String pass = encryptDecrypt.crypter(IConstants.CRYPT_PWD,person.getPassword());*/

			    MyBlowfish bf = new MyBlowfish();
			    bf.setSecretKey(IConstants.CRYPT_PWD);
			    String passEncrypted = new BigInteger(bf.crypt(login.getPassword())).toString();
			     
				if(trigram.equalsIgnoreCase(login.getLogin())
//						&& passEncrypted.equals(person.getPassword())) {
						&& login.getPassword().equals(person.getPassword())) {
					session.setAttribute(IConstants.USER_SESSION, person);
					return indexPath;
				}
			}
		}
		model.addAttribute(IConstants.ERROR_MSG, Translation.getInstance().getTranslation(ITranslations.LOGIN_UNKNOWN));
		return ERROR_FORWARD;
	}	
}

package com.springmvc.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/logout")
public class LogoutController {

	private static final String ERROR_FORWARD = "login/login";
		
	public LogoutController() {
	}
		
	@RequestMapping(method=RequestMethod.GET, value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:"+ERROR_FORWARD;
	}
	
}
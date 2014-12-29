/*
 * File: Security.java
 *
 * Goal: .
 *
 * History:
 * //  Creation of the file (ADI)
 */
package com.springmvc.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.springmvc.IConstants;
import com.springmvc.bo.Person;
import com.springmvc.model.Login;

/**
 * The Class Security.
 *
 * @author adi
 * @version 5.1, //2014
 */
public class Security {
	
	/** The security. */
	private static Security security = new Security();
	
	/**
	 * Gets the single instance of Security.
	 *
	 * @return single instance of Security
	 */
	public static Security getInstance() {
		return security;
	}
	
	/**
	 * Verify login.
	 *
	 * @param request the request
	 * @return true, if successful
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public boolean verifyLogin(HttpServletRequest request) throws IOException {
	
		if(request.getSession().getAttribute(IConstants.USER_SESSION) == null) {
//			HttpSession session = request.getSession(false);
			// force everything to be template.jsp
			request.setAttribute("login", new Login());
			return false;
		}
		else return true;
	}
	
	/**
	 * Verify admin.
	 *
	 * @param session the session
	 * @param request the request
	 * @return true, if successful
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public boolean verifyAdmin(HttpSession session, HttpServletRequest request) throws IOException {
		
			if (security.verifyLogin(request)) {
	
				Person connected = (Person) session.getAttribute(IConstants.USER_SESSION);
				
				return connected.getAdmin()!=null && connected.getAdmin();
			}
			else return false;
	}

	/**
	 * Verify perso or admin.
	 *
	 * @param matricule the matricule
	 * @param session the session
	 * @param request the request
	 * @return true, if successful
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public boolean verifyPersoOrAdmin(String matricule,HttpSession session, HttpServletRequest request) throws IOException {
		
		if (security.verifyLogin(request)) {
		
			Person connected = (Person) session.getAttribute(IConstants.USER_SESSION);
			
			return connected.getMatricule().equals(matricule) || (connected.getAdmin()!=null && connected.getAdmin());
		}
		else return false;
	}
	
}
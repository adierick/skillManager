/*
 * File: Context.java
 *
 * Goal: .
 *
 * History:
 * //  Creation of the file (ADI)
 */
package com.springmvc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The Class Context.
 *
 * @author adi
 * @version 5.1, //2014
 */
public class Context {

	/** The instance. */
	private static Context instance = new Context();
	
	/** The application context. */
	private ApplicationContext applicationContext;
	
	/**
	 * Constructor for context.
	 */
	private Context() {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	/**
	 * Gets the single instance of Context.
	 *
	 * @return single instance of Context
	 */
	public static Context getInstance() {
		return instance;
	}

	/**
	 * Gets the application context.
	 *
	 * @return the application context
	 */
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
}

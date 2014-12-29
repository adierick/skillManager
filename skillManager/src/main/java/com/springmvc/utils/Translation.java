/*
 * File: Translation.java
 *
 * Goal: .
 *
 * History:
 * //  Creation of the file (ADI)
 */
package com.springmvc.utils;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.NoSuchMessageException;

import com.springmvc.Context;

/**
 * The Class Translation.
 *
 * @author adi
 * @version 5.1, //2014
 */
public class Translation {

	/** The translation. */
	private static Translation translation = new Translation();
	
	/** The context. */
	private ApplicationContext context;
	
	/**
	 * Constructor for translation.
	 */
	private Translation() {
		context = Context.getInstance().getApplicationContext();
	}
	
	/**
	 * Gets the single instance of Translation.
	 *
	 * @return single instance of Translation
	 */
	public static Translation getInstance() {
		return translation;
	}
	
	/**
	 * Gets the translation.
	 *
	 * @param key the key
	 * @return the translation
	 */
	public String getTranslation(String key) {
		String trans = key;
		try {
			trans = context.getMessage(key, null, Locale.getDefault());
		} catch(NoSuchMessageException e) {
			try {
				trans = context.getMessage(key, null, Locale.ENGLISH);
			} catch(NoSuchMessageException e2) {
				return key;
			}
		}
		
		return trans;
	}
	
	/**
	 * Gets the translation.
	 *
	 * @param key the key
	 * @param args the args
	 * @return the translation
	 */
	public String getTranslation(String key, Object[] args) {
		String trans = key;
		try {
			trans = context.getMessage(key, args, Locale.getDefault());
		} catch(NoSuchMessageException e) {
			try {
				trans = context.getMessage(key, args, Locale.ENGLISH);
			} catch(NoSuchMessageException e2) {
				return key;
			}
		}
		
		return trans;
	}
	
	/**
	 * Gets the translation.
	 *
	 * @param key the key
	 * @param args the args
	 * @param locale the locale
	 * @return the translation
	 */
	public String getTranslation(String key, Object[] args, Locale locale) {
		String trans = key;
		try {
			trans = context.getMessage(key, args, locale);
		} catch(NoSuchMessageException e) {
			try {
				trans = context.getMessage(key, null, Locale.ENGLISH);
			} catch(NoSuchMessageException e2) {
				return key;
			}
		}
		
		return trans;
	}
	
}

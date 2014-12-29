package com.springmvc.utils;

public enum KeyWordEnum {
	FIRSTNAME("firstname"),LASTNAME("lastname"),AGECLB("ageclb"),FONCTIONCLB("fctclb"),EXPCLB("expclb"),DISPOCLB("dispoclb"),LASTSCHOOL("lastschool"),INITIALES("initclb"),
	CLIENT("clientclb"),LIEU("lieuclt"),ACTIVITE("activiteclt"),RESUME("resumission"),DEBUT("debutm"),FIN("finm"),TECHNO("cptclb");
	private String value;
	private KeyWordEnum(String value){
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
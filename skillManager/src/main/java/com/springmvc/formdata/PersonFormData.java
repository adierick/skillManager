package com.springmvc.formdata;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import com.springmvc.bo.Person;
import com.springmvc.constraints.FieldMatch;




@FieldMatch(first = "firstPassword", second = "confirmPassword", message = "{person.password.confirm.notMatched}")
@Component
public class PersonFormData {
		@Valid
		private Person person;
		@NotEmpty(message="{person.password.notBlank}")
		private String firstPassword;
		@NotEmpty(message="{person.password.notBlank}")
		private String confirmPassword;
		
		public PersonFormData(){
		}
		
		public PersonFormData(Person person) {
			this.person = person;
		}
		
		public String getFirstPassword() {
			return firstPassword;
		}
		public void setFirstPassword(String firstPassword) {
			this.firstPassword = firstPassword;
		}
		
		public Person getPerson() {
			return person;
		}
		public void setPerson(Person person) {
			this.person = person;
		}
		public String getConfirmPassword() {
			return confirmPassword;
		}
		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
		}

				
}

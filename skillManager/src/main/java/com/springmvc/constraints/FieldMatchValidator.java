package com.springmvc.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object>{

	private String firstFieldName;
    private String secondFieldName;
    private String message;
	
	public void initialize(final FieldMatch constraintAnnotation) {
		firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
        message = constraintAnnotation.message();
	}

	public boolean isValid(final Object value, final ConstraintValidatorContext context) {
		try
        {
            final Object firstObj = BeanUtils.getProperty(value, firstFieldName);
            final Object secondObj = BeanUtils.getProperty(value, secondFieldName);

            boolean valid = firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
            if(!valid){
            	context.buildConstraintViolationWithTemplate(message).addNode(secondFieldName).addConstraintViolation();
            	return valid;
            }else{
            	return valid;
            }
            
        }
        catch (final Exception ignore)
        {
            // ignore
        }
        return true;
	}

}

package com.ar.ecommerce.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.ar.ecommerce.model.Customer;

@Component
public class UserValidator {
	
	public boolean supports(Class<?> clazz) {
		return Customer.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object object , Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user", "Campo no puee estar vacio.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pass", "Campo no puee estar vacio.");
	}
}

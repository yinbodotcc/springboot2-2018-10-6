package com.example.demo.validators;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.demo.domains.User;
import com.example.demo.repositories.UserRepository;

@Component
public class UserEmailNotPermitSameValidator implements Validator
{
	@Autowired
	UserRepository userRepository;
	@Override
	public boolean supports(Class<?> clazz)
	{
		return User.class.isAssignableFrom(clazz);
	}
	@Override
	public void validate(Object target, Errors errors)
	{
		User user = (User) target;
		String email = user.getEmail();
		User userByEmail = userRepository.findUserByEmail(email);
		if (userByEmail != null)
		{
			errors.rejectValue("email", "email.exists", new Object[]
			{ email }, "Email " + email + " already in use");
		}
	}
}

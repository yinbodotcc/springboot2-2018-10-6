package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domains.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.validators.UserEmailNotPermitSameValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RegistrationController
{
	@Autowired
	UserRepository userRepository;
	@Autowired
	private UserEmailNotPermitSameValidator userValidator;
	
	@GetMapping("/registration")
	public String registrationForm(Model model)
	{
		model.addAttribute("user", new User());
		return "registration";
	}

	@PostMapping("/registration")
	public String handleRegistration(@Valid User user, BindingResult result)
	{	
		userValidator.validate(user, result);
		log.info("Registering User : " + user);
		if (result.hasErrors())
		{
			return "registration";
		}
		userRepository.save(user);
		return "redirect:/login";
	}
}
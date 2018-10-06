package com.example.demo.controller;

import java.io.File;
import java.nio.file.Files;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domains.User;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController
{		
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("message", "SpringBoot + Thymeleaf rocks");
		return "home";
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(User user, Model model) {
		log.info("Login User: "+user);
		return "redirect:/";
	}
}

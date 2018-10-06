package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domains.Person;

@Controller
public class PersonController
{
	private static final Logger log = LoggerFactory.getLogger(PersonController.class);

	@PostMapping("person/getPerson/{id}.json")
	@ResponseBody
	public Person getPerson(@PathVariable("id") String id)
	{
		log.info("ID:" + id);
		return new Person("1", "leftso", 1, "某某省某某市");
	}
}
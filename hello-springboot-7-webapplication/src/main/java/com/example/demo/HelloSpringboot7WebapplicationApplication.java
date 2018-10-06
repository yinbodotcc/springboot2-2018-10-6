package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class HelloSpringboot7WebapplicationApplication extends SpringBootServletInitializer
{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
	{
		return application.sources(HelloSpringboot7WebapplicationApplication.class);
	}

	public static void main(String[] args)
	{
		SpringApplication.run(HelloSpringboot7WebapplicationApplication.class, args);
	}
}

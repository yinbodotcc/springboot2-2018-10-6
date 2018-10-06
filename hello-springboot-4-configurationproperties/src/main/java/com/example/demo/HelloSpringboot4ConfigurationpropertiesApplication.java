package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

//@SpringBootApplication

@ComponentScans({
	@ComponentScan("com.example.demo.controller"), 
	@ComponentScan("com.example.demo.config")})
@EnableAutoConfiguration

public class HelloSpringboot4ConfigurationpropertiesApplication {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(args));
		SpringApplication.run(
				HelloSpringboot4ConfigurationpropertiesApplication.class, args);
	}
}

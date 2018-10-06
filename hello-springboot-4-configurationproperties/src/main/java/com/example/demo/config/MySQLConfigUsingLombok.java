package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@ConfigurationProperties(prefix = "db")
@Getter
@Setter
@ToString
public class MySQLConfigUsingLombok
{
	private String username;
	private String password;
	private String url;
	private String driverClassName;	
}
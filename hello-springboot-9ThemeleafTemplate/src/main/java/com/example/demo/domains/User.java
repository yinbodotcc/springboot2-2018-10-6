package com.example.demo.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;
	@NotNull
	@Size(min = 3, max = 50)
	private String name;
	@NotNull
	@Email(message = "{invalid.email}")
	private String email;
	@NotNull
	@Size(min = 6, max = 50)
	private String password;
}


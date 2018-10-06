package com.example.demo.domains;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Setter
@Getter
public class User
{
	@Id
	private String id;
	private String name;
	private String email;
}

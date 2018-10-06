package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//when the request handler method throws ResourceNotFoundException, 
//the proper HTTP error status code (404 NOT_FOUND) will be returned to the client
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException()
	{
		this("Resource not found!");
	}

	public ResourceNotFoundException(String message)
	{
		this(message, null);
	}

	public ResourceNotFoundException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>
{	
	@Override
	@RestResource(exported = false)
	void delete(User entity);
}
package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domains.User;
import com.example.demo.repositories.UserReactiveRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/users")
public class UserController
{
	@Autowired
	private UserReactiveRepository userReactiveRepository;

	@GetMapping
	public Flux<User> allUsers()
	{
		return userReactiveRepository.findAll();
	}

	@GetMapping("/{id}")
	public Mono<User> getUser(@PathVariable String id)
	{
		return userReactiveRepository.findById(id);
	}

	@PostMapping
	public Mono<User> saveUser(@RequestBody Mono<User> userMono)
	{
		return userMono.flatMap(user -> userReactiveRepository.save(user));
	}

	@DeleteMapping("/{id}")
	public Mono<Void> deleteUser(@PathVariable String id)
	{
		return userReactiveRepository.deleteById(id);
	}
}
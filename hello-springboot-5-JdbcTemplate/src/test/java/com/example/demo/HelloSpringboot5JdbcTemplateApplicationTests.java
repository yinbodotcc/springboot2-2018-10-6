package com.example.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloSpringboot5JdbcTemplateApplicationTests
{
	@Autowired
	private UserRepository userRepository;

	@Test
	public void findAllUsers()
	{
		List<User> users = userRepository.findAll();
		org.junit.Assert.assertNotNull(users);
		org.junit.Assert.assertTrue(!users.isEmpty());
	}

	@Test
	public void findUserById()
	{
		User user = userRepository.findUserById(1);
		org.junit.Assert.assertNotNull(user);
	}

	@Test
	public void createUser()
	{
		User user = new User(0, "Johnson", "johnson@gmail.com");
		User savedUser = userRepository.create(user);
		User newUser = userRepository.findUserById(savedUser.getId());
		org.junit.Assert.assertNotNull(newUser);
		org.junit.Assert.assertEquals("Johnson", newUser.getName());
		org.junit.Assert.assertEquals("johnson@gmail.com", newUser.getEmail());
	}

}

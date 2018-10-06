package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domains.User;

public interface UserRepository extends JpaRepository<User, Long>
{
	User findUserByEmail(String email);
}

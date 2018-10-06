package com.example.demo.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.demo.domains.User;

public interface UserReactiveRepository extends ReactiveCrudRepository<User, String>
{

}












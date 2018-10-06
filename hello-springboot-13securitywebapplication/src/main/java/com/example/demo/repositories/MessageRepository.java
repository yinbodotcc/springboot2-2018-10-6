/**
 * 
 */
package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domains.Message;

/**
 * @author Siva
 *
 */
public interface MessageRepository extends JpaRepository<Message, Integer>{

}

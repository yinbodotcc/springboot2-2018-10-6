package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Comment;
import com.example.demo.entities.Post;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.CommentRepository;
import com.example.demo.repositories.PostRepository;

@RestController
@RequestMapping(value = "/posts")
public class PostController
{
	@Autowired
	PostRepository postRepository;
	@Autowired
	CommentRepository commentRepository;

	/*
	 * 默认情况下返回的是HTTP status code 200 OK，我们这里让它返回HTTP status code (201 CREATED) 和响应体
	 */
	//data will be validated against the Java Bean Validation Constraints defined on the POST properties.
	/**
	 除了可以返回 arbitrary object , 我們也可返回 ResponseEntity/HttpEntity,  它可以設置响应头和状态码
	 */
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public ResponseEntity<Post> createPost(@RequestBody @Valid Post post, BindingResult result)
	{
		if (result.hasErrors())
		{
			return new ResponseEntity<>(post, HttpStatus.BAD_REQUEST);
		}
		Post savedPost = postRepository.save(post);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader1", "MyValue1");
		responseHeaders.set("MyResponseHeader2", "MyValue2");
		return new ResponseEntity<>(savedPost, responseHeaders, HttpStatus.CREATED);
	}

	@GetMapping("")
	public List<Post> listPosts()
	{
		return postRepository.findAll();
	}

	// GET http://localhost:8080/posts/{id}
	@GetMapping(value = "/{id}")
	public Post getPost(@PathVariable("id") Integer id)
	{
		return postRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No post found with id=" + id));
	}

	// PUT http://localhost:8080/posts/{id}
	@PutMapping("/{id}")
	public Post updatePost(@PathVariable("id") Integer id, @RequestBody Post post)
	{
		postRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("No post found with id=" + id));
		return postRepository.save(post);
	}

	/**
	 Note that you are not returning any content to the client, so on successful
deletion of the post, the HTTP 200 OK status code will be sent
	 */
	// DELETE method at the URI http://localhost:8080/posts/{id}
	@DeleteMapping("/{id}")
	public void deletePost(@PathVariable("id") Integer id)
	{
		Post post = postRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No post found with id=" + id));
		postRepository.deleteById(post.getId());
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/{id}/comments")
	public void createPostComment(@PathVariable("id") Integer id, @RequestBody Comment comment)
	{
		Post post = postRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No post found with id=" + id));
		post.getComments().add(comment);
	}

	@DeleteMapping("/{postId}/comments/{commentId}")
	public void deletePostComment(@PathVariable("postId") Integer postId, 
			@PathVariable("commentId") Integer commentId)
	{
		commentRepository.deleteById(commentId);
	}
}
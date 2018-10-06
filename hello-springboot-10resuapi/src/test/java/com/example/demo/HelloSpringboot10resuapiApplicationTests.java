package com.example.demo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entities.Post;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class HelloSpringboot10resuapiApplicationTests
{

	private static final String ROOT_URL = "http://localhost:9876";
	RestTemplate restTemplate = new RestTemplate();

	@Test
	public void testGetAllPosts()
	{
		ResponseEntity<Post[]> responseEntity = restTemplate.getForEntity(ROOT_URL + "/posts", Post[].class);
		List<Post> posts = Arrays.asList(responseEntity.getBody());
		Assert.assertNotNull(posts);
	}

	@Test
	public void testGetPostById()
	{
		Post post = restTemplate.getForObject(ROOT_URL + "/posts/1", Post.class);
		Assert.assertNotNull(post);
	}

	@Test
	public void testCreatePost()
	{
		Post post = new Post();
		post.setTitle("Exploring SpringBoot REST");
		post.setContent("SpringBoot is awesome!!");
		post.setCreatedOn(new Date());
		ResponseEntity<Post> postResponse = restTemplate.postForEntity(ROOT_URL + "/posts", post, Post.class);
		Assert.assertNotNull(postResponse);
		Assert.assertNotNull(postResponse.getBody());
	}

	@Test
	public void testUpdatePost()
	{
		int id = 1;
		Post post = restTemplate.getForObject(ROOT_URL + "/posts/" + id, Post.class);
		post.setContent("This my updated post1 content");
		post.setUpdatedOn(new Date());
		restTemplate.put(ROOT_URL + "/posts/" + id, post);
		Post updatedPost = restTemplate.getForObject(ROOT_URL + "/posts/" + id, Post.class);
		Assert.assertNotNull(updatedPost);
	}

	@Test
	public void testDeletePost()
	{
		int id = 2;
		Post post = restTemplate.getForObject(ROOT_URL + "/posts/" + id, Post.class);
		Assert.assertNotNull(post);
		restTemplate.delete(ROOT_URL + "/posts/" + id);
		try
		{
			post = restTemplate.getForObject(ROOT_URL + "/posts/" + id, Post.class);
		} catch (final HttpClientErrorException e)
		{
			Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}

}

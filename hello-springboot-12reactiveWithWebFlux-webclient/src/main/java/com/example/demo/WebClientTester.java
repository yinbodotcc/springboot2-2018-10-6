package com.example.demo;

import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.domains.Person;

import reactor.core.publisher.Mono;

public class WebClientTester
{
	public static void main(String[] args)
	{
		testWithCookie();
	}

	public static void testWithCookie()
	{
		Mono<Person> resp = WebClient.create("http://localhost:9876/")
				.method(HttpMethod.POST).uri("person/getPerson/123.json")
				.retrieve().bodyToMono(Person.class);
		System.out.println(resp.block());
	}
}
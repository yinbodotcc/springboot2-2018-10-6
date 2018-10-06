package com.example.demo;

import org.junit.Test;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

public class BaiduWebClientTest
{
	@Test
	public void testUrlPlaceholder()
	{
		Mono<String> resp = WebClient.create().get()
				.uri("http://www.baidu.com/s?wd={key}&other={another}", "北京天气",
						"test") // 使用占位符
				.retrieve().bodyToMono(String.class);
		System.out.println(resp.block());
	}
}

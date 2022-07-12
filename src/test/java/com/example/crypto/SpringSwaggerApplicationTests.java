package com.example.crypto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import com.example.swagger.SpringSwaggerApplication;
import com.example.swagger.model.Book;
import com.fasterxml.jackson.core.JsonProcessingException;

@SpringBootTest(classes = SpringSwaggerApplication.class)
class SpringSwaggerApplicationTests {
	private static String FOO_RESOURCE_URL="http://localhost:8081/book";

	/*
	 * @Test void contextLoads() throws URISyntaxException, JsonProcessingException
	 * { URI url=new URI(FOO_RESOURCE_URL+"/save");
	 * 
	 * Book b=new Book("b1",121); TestRestTemplate testRestTemplate = new
	 * TestRestTemplate(); HttpEntity<Book> request=new HttpEntity<>(b);
	 * ResponseEntity<String> response = testRestTemplate.postForEntity(url, b,
	 * String.class); //ResponseEntity<String> response =
	 * testRestTemplate.exchange(url, HttpMethod.POST,request, String.class);
	 * assertEquals(HttpStatus.OK, response.getStatusCode()); }
	 */
	@Test
	void testget() throws URISyntaxException {
		URI url=new URI(FOO_RESOURCE_URL+"/searchBook/1");
		
		Book b=new Book("b1",121);
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		ResponseEntity<Book> response=testRestTemplate.getForEntity(url,Book.class);
		System.out.println(response.getBody());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
}

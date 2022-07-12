package com.example.crypto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.swagger.SpringSwaggerApplication;
import com.example.swagger.model.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(classes = SpringSwaggerApplication.class)
@AutoConfigureMockMvc
class SpringSwaggerApplicationTestsMockMvc {
	private static String FOO_RESOURCE_URL="http://localhost:8081/book";
	@Autowired
	private MockMvc mockmvc;
	
	@Autowired
	private ObjectMapper mapper;

	
	  @Test void testget() throws Exception { URI url=new
	  URI(FOO_RESOURCE_URL+"/searchBook/1"); Book b=new Book("b1",121); 
	  MvcResult mvcResult=mockmvc
	  .perform(get(url).contentType(MediaType.APPLICATION_JSON)).andReturn();
	  String result=mvcResult.getResponse().getContentAsString();
	  System.out.println(result);
	  Book resultbook=mapper.readValue(result,Book.class);
	  System.out.println(resultbook);
	  assertEquals(HttpStatus.OK.value(),mvcResult.getResponse().getStatus()); 
	  }
	 
	/*
	 * @Test void testpost() throws Exception { URI url=new
	 * URI(FOO_RESOURCE_URL+"/save"); Book b=new Book("b1",121); String
	 * bookString=mapper.writeValueAsString(b); MvcResult mvcResult=mockmvc
	 * .perform(post(url).content(bookString).contentType(MediaType.APPLICATION_JSON
	 * )) .andReturn(); String result=mvcResult.getResponse().getContentAsString();
	 * 
	 * System.out.println(result); // assertEquals(HttpStatus.OK,
	 * result.getStatusCode()); }
	 */
}

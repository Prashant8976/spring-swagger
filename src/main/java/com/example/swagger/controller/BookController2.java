package com.example.swagger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.swagger.model.Book;
import com.example.swagger.service.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/book1")
@Api(tags = "book service")
public class BookController2 {
	@Autowired
	private BookService service;
	@PostMapping("/book")
	@ApiOperation(value = "saveBOoooooooooooook")
	public String saveBook(@RequestBody Book book) {
		return service.saveBook(book);
	}
	@GetMapping("/searchBook/{bookId}")
	public Book getBook(@PathVariable Integer bookId) {
		return service.getBook(bookId);
	}
	@DeleteMapping("/deleteBook/{bookId}")
	public List<Book> deleteBook(@PathVariable Integer bookId) {
		return service.removeBook(bookId);
	}
}

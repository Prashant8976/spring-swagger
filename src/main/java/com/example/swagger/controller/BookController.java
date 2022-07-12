package com.example.swagger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.swagger.model.Book;
import com.example.swagger.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookService service;
	@PostMapping(value="/save")
	public ResponseEntity<String> saveBook(@RequestBody Book book) {
		String data=service.saveBook(book);
		return ResponseEntity.ok().body(data);
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

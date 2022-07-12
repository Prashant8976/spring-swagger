package com.example.swagger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.swagger.dao.BookRepository;
import com.example.swagger.model.Book;

@Service
public class BookService {
	@Autowired
	private BookRepository repository;
	public String saveBook(Book book) {
		repository.save(book);
		return "book save with id"+book.getBookId();
	}
	public Book getBook(Integer bookId) {
		return repository.findById(bookId).orElse(new Book());
	}
	public List<Book> removeBook(Integer bookId){
		repository.deleteById(bookId);
		return repository.findAll();
	}
}

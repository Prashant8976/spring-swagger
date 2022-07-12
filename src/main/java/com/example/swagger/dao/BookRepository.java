package com.example.swagger.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.swagger.model.Book;

public interface BookRepository extends JpaRepository<Book,Integer> {

}

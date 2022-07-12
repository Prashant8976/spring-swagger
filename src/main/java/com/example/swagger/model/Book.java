package com.example.swagger.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table
@Data@ToString
@NoArgsConstructor@AllArgsConstructor
@XmlRootElement
public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int bookId;
	private String bookName;
	private double price;
	public Book(String bookName, double price) {
		super();
		this.bookName = bookName;
		this.price = price;
	}
	
}

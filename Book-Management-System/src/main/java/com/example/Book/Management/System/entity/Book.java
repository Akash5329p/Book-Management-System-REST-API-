package com.example.Book.Management.System.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

@Valid
@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "abc")
	@SequenceGenerator(name = "abc", initialValue = 1 , allocationSize = 1)  //Generating PK from 1 
	@Column(name = "Book Id")
	private int id;
	@Column(name = "Book Name")
	private String b_Name;
	@Column(name = "Book-Genre")
	private String genre;
	@Column(name = "Author Name")
	private String author_name;
	@Positive(message = "Pages cannot be stored with Negative numbers")
	@Min(value = 30, message = "Book should contain atleast 30 Pages in it.")
	@Column(name = "Number of Pages")
	private int pages;
	@Column(name = "Book Price")
	private int price;
	
	//Getters - Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getB_Name() {
		return b_Name;
	}
	public void setB_Name(String b_Name) {
		this.b_Name = b_Name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}

package com.example.Book.Management.System.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.example.Book.Management.System.Exception.BookNotFoundException;
import com.example.Book.Management.System.entity.Book;
import com.example.Book.Management.System.repository.BookRepo;

import jakarta.transaction.Transactional;
/*
 * CRUD- Add, Read, Update, Delete
 * 
*/
@Service
public class Book_Service {
	
	@Autowired
	private BookRepo bookRepo; //Interface DI
	
	//Add a Book
	public Book addBook(Book book) {
		return bookRepo.save(book); //Saving details
	}
	
	//Read a book
	public Book findBook(int id) {
		Optional<Book> optional = bookRepo.findById(id);         //findBy() is an inbuilt method which returns Optional type of value
		if(optional.isPresent())
			return (Book) optional.get();
		throw new BookNotFoundException("Book with id " +id+ " Not Exist");
	}
	
	//Read all Books
	public List<Book> getAllBook(){
		return bookRepo.findAll();
	}
	
	//Delete a book
	public void deleteBook(int id) {
		bookRepo.deleteById(id);	
	}
	
	//Delete all books
	public String deleteAllBooks() {
		bookRepo.deleteAll();
		return "All Books records are Deleted";
	}
	
	//Update pages of a book
	@Transactional
	public String updatePages(int id,int pages) {
		Book existingbook = findBook(id);
		existingbook.setPages(pages);
		return "Pages Successfully Updated";
	}
	
	//Update Name of a book
	@Transactional
	public String updateName(int id, String b_Name) {
		if(b_Name.isEmpty()) {
			throw new IllegalArgumentException("Book With No Name is Not Allowed");
		}
		Book updatedBook = findBook(id);
		updatedBook.setB_Name(b_Name);
		return "Book Name is Successfully Updated";
	}
	
}




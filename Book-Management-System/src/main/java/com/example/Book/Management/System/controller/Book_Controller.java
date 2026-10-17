package com.example.Book.Management.System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Book.Management.System.entity.Book;
import com.example.Book.Management.System.repository.BookRepo;
import com.example.Book.Management.System.service.Book_Service;

@RestController
@RequestMapping("/book")
public class Book_Controller {
	
	@Autowired
	Book_Service book_Service;
	
	@PostMapping
	public ResponseEntity<Book> createBook(@Validated @RequestBody Book book){
		Book savebook = book_Service.addBook(book);
		return new ResponseEntity<>(savebook, HttpStatus.CREATED);
//		return ResponseEntity.status(HttpStatus.CREATED).body(savebook);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> searchBookById(@PathVariable int id){
		Book book = book_Service.findBook(id);
		return new ResponseEntity<Book>(book,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> allBooks(){
		List<Book> books = book_Service.getAllBook();
		return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
	}
		
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removeId(@PathVariable int id){
		book_Service.deleteBook(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	@DeleteMapping
	public ResponseEntity<String> removeAllBooks(){
		String resp = book_Service.deleteAllBooks();
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}
	
	@PutMapping("/{id}/pages/{pages}")
	public ResponseEntity<String> updatePages(@PathVariable int id, @PathVariable int pages){
		String msg =book_Service.updatePages(id, pages);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
		
	}
	
	@PatchMapping("/{id}/name/{b_Name}")
	public ResponseEntity<String> updateBookName(@PathVariable int id, @PathVariable String b_Name){
		String newName = book_Service.updateName(id, b_Name);
		return new ResponseEntity<String>(newName, HttpStatus.OK);	
	}
}	


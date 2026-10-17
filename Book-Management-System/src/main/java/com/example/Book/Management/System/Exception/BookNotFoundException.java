package com.example.Book.Management.System.Exception;

public class BookNotFoundException extends RuntimeException{
	public BookNotFoundException(String msg) {
		super(msg);
	}
}

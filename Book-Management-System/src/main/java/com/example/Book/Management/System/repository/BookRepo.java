package com.example.Book.Management.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Book.Management.System.entity.Book;
											  //Entity, Id  	 <-- Datatype
public interface BookRepo extends JpaRepository<Book, Integer>{}

package com.example.bookstore.interfaces;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.example.bookstore.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
	List<Book> findByTitle(String title);
}

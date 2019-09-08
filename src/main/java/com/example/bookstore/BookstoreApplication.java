package com.example.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.interfaces.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	@Autowired
	private BookRepository repository; 
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner studentDemo(BookRepository repository) {
		return (args) -> {
			repository.save(new Book("Animals", "John Johnson", "12355-4", (long)1999, (float) 12.99));
			repository.save(new Book("Reptiles", "Janice Jann", "54352-10", (long)2009, (float) 17.99));
			repository.save(new Book("Cars", "Michael Waterson", "12123133-4", (long)1965, (float) 5.99));
			repository.save(new Book("Trains", "Michelle Wall", "5451242-11", (long)2015, (float) 25.99));
		};
	}
}

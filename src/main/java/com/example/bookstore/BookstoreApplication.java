package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.Category;
import com.example.bookstore.interfaces.BookRepository;
import com.example.bookstore.interfaces.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookStoreDemo(BookRepository repository, CategoryRepository categoryRepository) {
		return (args) -> {
			categoryRepository.save(new Category("Fact"));
			categoryRepository.save(new Category("Fiction"));
			categoryRepository.save(new Category("Fantasy"));
			
			Category fact = categoryRepository.findByName("Fact").get(0);
			Category fiction = categoryRepository.findByName("Fiction").get(0);
			
			repository.save(new Book("Animals", "John Johnson", "12355-4", (long)1999, (float) 12.99, fiction));
			repository.save(new Book("Reptiles", "Janice Jann", "54352-10", (long)2009, (float) 17.99, fact));
			repository.save(new Book("Cars", "Michael Waterson", "12123133-4", (long)1965, (float) 5.99, fiction));
			repository.save(new Book("Trains", "Michelle Wall", "5451242-11", (long)2015, (float) 25.99, fact));
		};
	}
}

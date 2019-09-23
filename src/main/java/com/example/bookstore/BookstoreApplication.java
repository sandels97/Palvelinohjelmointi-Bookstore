package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.User;
import com.example.bookstore.interfaces.BookRepository;
import com.example.bookstore.interfaces.CategoryRepository;
import com.example.bookstore.interfaces.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookStoreDemo(BookRepository repository, CategoryRepository categoryRepository, UserRepository userRepository) {
		return (args) -> {
			categoryRepository.save(new Category("Fact"));
			categoryRepository.save(new Category("Fiction"));
			categoryRepository.save(new Category("Fantasy"));
			
			Category fact = categoryRepository.findByName("Fact").get(0);
			Category fiction = categoryRepository.findByName("Fiction").get(0);
			
			repository.save(new Book("Animals", "John Johnson", "12355-4", (long)1999, 12.99, fiction));
			repository.save(new Book("Reptiles", "Janice Jann", "54352-10", (long)2009, 17.99, fact));
			repository.save(new Book("Cars", "Michael Waterson", "12123133-4", (long)1965, 5.99, fiction));
			repository.save(new Book("Trains", "Michelle Wall", "5451242-11", (long)2015, 25.99, fact));
			
			User user = new User("user","salainen","USER");
			User admin = new User("user","supersalainen","ADMIN");
			
			userRepository.save(user);
			userRepository.save(admin);
		};
	}
}

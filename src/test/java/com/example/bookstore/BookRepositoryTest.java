package com.example.bookstore;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.User;
import com.example.bookstore.interfaces.BookRepository;
import com.example.bookstore.interfaces.CategoryRepository;
import com.example.bookstore.interfaces.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void testEntities() throws Exception {
		
		Category category = categoryRepository.save(new Category("Test"));
		Book book = new Book("TestBook", "John Johnson", "12355-4", (long)1999, 12.99, category);
		User user = new User("Barry","$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6","USER");
		
		//Create
		bookRepository.save(book);
		categoryRepository.save(category);
		userRepository.save(user);	

		assertThat(book.getId()).isNotNull();
		assertThat(category.getId()).isNotNull();
		assertThat(user.getId()).isNotNull();
		
		
		//Search
		List<Book> books = bookRepository.findByTitle("Animals");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle()).isEqualTo("Animals");
		
		List<Category> categories = categoryRepository.findByName("Test");
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getName()).isEqualTo("Test");
		
		User users = userRepository.findByUsername("admin");
		assertThat(user).isNotNull();
		assertThat(users.getUsername()).isEqualTo("admin");
		
		//Delete
		bookRepository.delete(book);
		categoryRepository.delete(category);
		userRepository.delete(user);
		
		assertThat(bookRepository.findById(book.getId())).isEmpty();
		assertThat(categoryRepository.findById(category.getId())).isEmpty();
		assertThat(userRepository.findById(user.getId())).isEmpty();
	}
}

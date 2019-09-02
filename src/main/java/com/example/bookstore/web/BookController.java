package com.example.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.bookstore.domain.Book;
import com.example.bookstore.interfaces.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository; 

	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/booklist")
	public String booklist(Model model) {
		model.addAttribute("books",repository.findAll());
		return "booklist";
	}
	@RequestMapping(value="/add")
	public String addStudent(Model model) {
		model.addAttribute("book", new Book());
		return	"addbook";
	}
	
	@PostMapping("/save") 
	public String save(Book book){
		repository.save(book);
		return "redirect:booklist";
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id")Long bookId,Model model) {
		repository.deleteById(bookId);
		return"redirect:booklist";
	}
}


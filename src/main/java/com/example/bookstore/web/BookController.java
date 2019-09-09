package com.example.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bookstore.domain.Book;
import com.example.bookstore.interfaces.BookRepository;
import com.example.bookstore.interfaces.CategoryRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository; 
	
	@Autowired 
	private CategoryRepository categoryRepository;
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/booklist")
	public String booklist(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	@RequestMapping(value="/add")
	public String addBook(Model model) {
		model.addAttribute("title","Add book");
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryRepository.findAll());
		return	"addbook";
	}
	
	@PostMapping("/save") 
	public String save(Book book){
		repository.save(book);
		return "redirect:/booklist";
	}
	
	@RequestMapping(value="/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId,Model model) {
		repository.deleteById(bookId);
		return "redirect:/booklist";
	}
	
	@RequestMapping(value="/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("title","Edit book");
		model.addAttribute("book", repository.findById(bookId));
		model.addAttribute("categories", categoryRepository.findAll());
		return "addbook";
	}
}


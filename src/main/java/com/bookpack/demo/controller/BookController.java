package com.bookpack.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookpack.demo.model.Book;
import com.bookpack.demo.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public ArrayList<Book> getBooks() {
		return bookService.getBooks();
	}

	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable("id") int id) {
		return bookService.getBook(id);
	}

	@PostMapping("/book")
	public Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}

	@PutMapping("/book/{id}")
	public Book updateBook(@PathVariable("id") int id, @RequestBody Book book) {
		return bookService.updateBook(id, book);
	}

	@DeleteMapping("/book/{id}")
	public void deleteBook(@PathVariable("id") int id) {
		bookService.deleteBook(id);
	}
}

package com.bookpack.demo.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.bookpack.demo.model.Book;

@Repository
public interface BookRepository {
	ArrayList<Book> getBooks();

	Book getBook(int id);

	Book addBook(Book book);

	Book updateBook(int id, Book book);

	void deleteBook(int id);
}

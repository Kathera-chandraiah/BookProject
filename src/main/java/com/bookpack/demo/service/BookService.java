package com.bookpack.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bookpack.demo.model.Book;
import com.bookpack.demo.repository.BookJpaRepository;
import com.bookpack.demo.repository.BookRepository;

@Service
public class BookService implements BookRepository {

	@Autowired
	private BookJpaRepository bookJpaRepository;

	@Override
	public ArrayList<Book> getBooks() {
		List<Book> bookList = bookJpaRepository.findAll();
		ArrayList<Book> books = new ArrayList<>(bookList);
		return books;
	}

	@Override
	public Book getBook(int id) {

		try {
			Book book = bookJpaRepository.findById(id).get();
			return book;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public Book addBook(Book book) {
		bookJpaRepository.save(book);
		return book;
	}

	@Override
	public Book updateBook(int id, Book book) {
		try {
			Book existingBook = bookJpaRepository.findById(id).get();
			if (book.getName() != null) {
				existingBook.setName(book.getName());
			}
			if (book.getImageUrl() != null) {
				existingBook.setImageUrl(book.getImageUrl());
			}
			bookJpaRepository.save(existingBook);
			return existingBook;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public void deleteBook(int id) {
		try {
			bookJpaRepository.deleteById(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

}

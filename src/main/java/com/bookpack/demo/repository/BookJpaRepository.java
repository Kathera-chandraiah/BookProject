package com.bookpack.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookpack.demo.model.Book;

@Repository
public interface BookJpaRepository extends JpaRepository<Book, Integer> {

}

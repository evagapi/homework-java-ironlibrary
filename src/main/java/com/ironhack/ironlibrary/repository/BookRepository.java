package com.ironhack.ironlibrary.repository;

import com.ironhack.ironlibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}

package com.ironhack.ironlibrary.repository;

import com.ironhack.ironlibrary.model.Author;
import com.ironhack.ironlibrary.model.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorRepositoryTest {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    Book book;
    Author author;

    @BeforeEach
    void setUp() {
        book = new Book("Harry Potter and Philosopher Stone", "ABC159753", "Young adult", 10);
        author = new Author("Henry", "henry@writer.com", book);
        bookRepository.save(book);
        authorRepository.save(author);
    }

    @AfterEach
    void tearDown() {
        authorRepository.deleteAll();
        authorRepository.flush();
        bookRepository.deleteAll();
        bookRepository.flush();
    }

    @Test
    void getAllAuthorsTest() {
        List<Author> authors = authorRepository.findAll();
        assertEquals(1, authors.size());
        assertEquals(authors.getFirst(), author);
        assertEquals(authors.getFirst().getAuthorBook(), book);
    }
}
package com.ironhack.ironlibrary.repository;

import com.ironhack.ironlibrary.model.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        List<Book> books = List.of(
                new Book("Harry Potter and Philosopher Stone", "ABC159753", "Young adult", 10),
                new Book("Final Empire", "DEF159753", "Fantasy", 8),
                new Book("Oliver Twist", "GHI159753", "Fiction", 6)
        );
        bookRepository.saveAll(books);
    }

    @AfterEach
    void tearDown() {
        bookRepository.deleteAll();
        bookRepository.flush();
    }

    @Test
    public void testKoFindBookByTitle() {
        Optional<Book> bookOptional = bookRepository.findBookByTitle("Matilda");
        assertFalse(bookOptional.isPresent());
    }
    @Test
    public void testOkFindBookByTitle() {
        Optional<Book> bookOptional = bookRepository.findBookByTitle("Final Empire");
        assertTrue(bookOptional.isPresent());
        assertEquals("Final Empire", bookOptional.get().getTitle());
    }

    @Test
    public void testKoFindBookByCategory() {
        Optional<Book> bookOptional = bookRepository.findBookByCategory("Mystery");
        assertFalse(bookOptional.isPresent());
    }
    @Test
    public void testOkFindBookByCategory() {
        Optional<Book> bookOptional = bookRepository.findBookByCategory("Fantasy");
        assertTrue(bookOptional.isPresent());
        assertEquals("Fantasy", bookOptional.get().getCategory());
    }

}
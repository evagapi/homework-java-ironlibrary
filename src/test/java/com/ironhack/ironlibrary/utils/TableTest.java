package com.ironhack.ironlibrary.utils;

import com.ironhack.ironlibrary.model.Author;
import com.ironhack.ironlibrary.model.Book;
import com.ironhack.ironlibrary.model.Issue;
import com.ironhack.ironlibrary.model.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {
    private final PrintStream originalSystemOut = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    Book book = new Book("Harry Potter and Philosopher Stone", "ABC159753", "Young adult", 10);
    Author author = new Author("Henry", "henry@gmail.com", book);
    Student student = new Student("123", "Ana");
    Issue issue = new Issue("20-03-2024", "25-03-2024", book, student);

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalSystemOut);
    }

    @Test
    void printBooksTest() {
        List<Book> books = List.of(book);
        Table.printBooks(books);
        assertEquals("Book ISBN                      Book Title                                    Category        No of Books    \n" +
                        "ABC159753                      Harry Potter and Philosopher Stone            Young adult     10             \n\n",
                outputStream.toString());
    }

    @Test
    void printBooksWithAuthorTest() {
        List<Author> authors = List.of(author);
        Table.printBooksWithAuthor(authors);
        assertEquals("Book ISBN                      Book Title                                    Category        No of Books     Author name    \n" +
                        "ABC159753                      Harry Potter and Philosopher Stone            Young adult     10              Henry          \n\n",
                outputStream.toString());
    }

    @Test
    void printIssuesTest() {
        Table.printIssue(issue);
        assertEquals("Book Title                                    Student Name    Return Date    \n" +
                        "Harry Potter and Philosopher Stone            Ana             25-03-2024     \n\n",
                outputStream.toString());
    }

    @Test
    void printTest() {
        Table.printIssue(issue);
        assertEquals("Book Title                                    Student Name    Return Date    \n" +
                        "Harry Potter and Philosopher Stone            Ana             25-03-2024     \n\n",
                outputStream.toString());
    }
}
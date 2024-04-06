package com.ironhack.ironlibrary.repository;

import com.ironhack.ironlibrary.model.Book;
import com.ironhack.ironlibrary.model.Issue;
import com.ironhack.ironlibrary.model.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class IssueRepositoryTest {

    @Autowired
    private IssueRepository issueRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private StudentRepository studentRepository;


    @BeforeEach
    void setUp() {
        Book book = new Book("Book 1","ABC123","Suspense",2);
        bookRepository.save(book);
        Student student = new Student("456ASD","Pau");
        studentRepository.save(student);
        Issue issue = new Issue(
                "04-04-2024",
                "04-04-2024",
                bookRepository.findById(1).get(),
                studentRepository.findById(1).get()
        );
        issueRepository.save(issue);
    }

    @AfterEach
    void tearDown() {
        issueRepository.deleteAll();
        bookRepository.deleteAll();
        studentRepository.deleteAll();
    }

    @Test
    public void testIssueBookToStudent() {
        Optional<Issue> issue = issueRepository.findById(1);
        assertTrue(issue.isPresent());
        assertEquals("Pau", issue.get().getIssueStudent().getName());
    }
}
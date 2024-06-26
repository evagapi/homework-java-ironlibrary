/* (C)2024 */
package com.ironhack.ironlibrary.view;

import com.ironhack.ironlibrary.model.Author;
import com.ironhack.ironlibrary.model.Book;
import com.ironhack.ironlibrary.model.Issue;
import com.ironhack.ironlibrary.model.Student;
import com.ironhack.ironlibrary.repository.AuthorRepository;
import com.ironhack.ironlibrary.repository.BookRepository;
import com.ironhack.ironlibrary.service.AuthorService;
import com.ironhack.ironlibrary.service.BookService;
import com.ironhack.ironlibrary.utils.InputReader;
import com.ironhack.ironlibrary.service.IssueService;
import com.ironhack.ironlibrary.service.StudentService;
import com.ironhack.ironlibrary.utils.Table;
import com.ironhack.ironlibrary.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class Librarian {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private AuthorService authorService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private IssueService issueService;

    @Autowired
    Validator validator;

    public void searchBookByTitle() {
        System.out.println("Enter a book title");
        String bookTitle = InputReader.getInstance().nextLine();
        Optional<Book> bookOptional = bookService.searchBookByTitle(bookTitle);
        if(bookOptional.isPresent()) {
            List<Book> books = new ArrayList<>();
            books.add(bookOptional.get());
            Table.printBooks(books);
        } else {
            System.out.println("Book not found");
        }
    }

    public void searchBookByCategory() {
        System.out.println("Enter a category");
        String category = InputReader.getInstance().nextLine();
        Optional<Book> bookOptional = bookService.searchBookByCategory(category);
        if(bookOptional.isPresent()) {
            List<Book> books = new ArrayList<>();
            books.add(bookOptional.get());
            Table.printBooks(books);
        } else {
            System.out.println("Book not found");
        }
    }

    public void addABook() {
        System.out.print("Enter isbn : ");
        String isbnTest = InputReader.getInstance().nextLine();
        String isbn = checkIsbn(isbnTest);
        System.out.print("Enter title : ");
        String title = InputReader.getInstance().nextLine();
        System.out.print("Enter category : ");
        String category = InputReader.getInstance().nextLine();
        System.out.print("Enter Author name : ");
        String name = InputReader.getInstance().nextLine();
        System.out.print("Enter Author mail : ");
        String email = InputReader.getInstance().nextLine();
        int quantity = validator.handleInteger("Enter number of books : ", "⚠\uFE0F Number of books must be between 0 and 100 ⚠\uFE0F", 0, 100);

        Book book = new Book(title, isbn, category, quantity);
        bookRepository.save(book);
        Author author = new Author(name, email, book);
        authorRepository.save(author);
    }

    public void getAllBooksAndAuthor() {
        List<Author> authors = authorService.getAllAuthors();
            Table.printBooksWithAuthor(authors);
    }

    public void searchBookByAuthor() {
        System.out.println("Enter an author name");
        String authorName = InputReader.getInstance().nextLine();
        Optional<Author> authorOptional = authorService.searchBookByAuthor(authorName);
        if (authorOptional.isPresent() && authorOptional.get().getAuthorBook() != null) {
            List<Book> books = new ArrayList<>();
            books.add(authorOptional.get().getAuthorBook());
            Table.printBooks(books);
        } else {
            System.out.println("Book not found");
        }
    }

    public void issueBookToStudent() {
        System.out.println("Enter issue date : ");
        String issueDate = InputReader.getInstance().nextLine();
        System.out.println("Enter return date : ");
        String returnDate = InputReader.getInstance().nextLine();
        System.out.println("Enter book title : ");
        String bookTitle = InputReader.getInstance().nextLine();
        Book book = searchBookByTitleHelper(bookTitle);
        System.out.println("Enter student usn : ");
        String usn = InputReader.getInstance().nextLine();
        Student student = searchStudentByUsn(usn);
        Issue issue = new Issue(
                issueDate,
                returnDate,
                book,
                student
        );
        issueService.saveIssue(issue);
        System.out.println("Book issued. Return date : " + returnDate);
    }

    public void listBooksByUsn() {
        System.out.println("Enter usn : ");
        String usn = InputReader.getInstance().nextLine();
        Optional<Student> studentOptional = studentService.findStudentByUsn(usn);
        if(studentOptional.isPresent()) {
            Optional<Issue> issueOptional = issueService.findIssueByStudent(studentOptional.get());
            if(issueOptional.isPresent()) {
                Table.printIssue(issueOptional.get());
            } else {
                System.out.println("This usn doesn't have a book issued.");
            }
        } else {
            System.out.println("This usn doesn't exists.");
        }
    }

    public String checkIsbn(String isbnTest) {
        List<Author> authors = authorService.getAllAuthors();

        for (Author author : authors) {
            if (Objects.equals(author.getAuthorBook().getIsbn(), isbnTest)) {
                System.out.print("This ISBN already exists, type another one : ");
                isbnTest = InputReader.getInstance().nextLine();
                isbnTest = InputReader.getInstance().nextLine();
                checkIsbn(isbnTest);
            }
        }

        return isbnTest;
    }

    public Book searchBookByTitleHelper(String title) {
        Optional<Book> bookOptional = bookService.searchBookByTitle(title);

        if(bookOptional.isEmpty()) {
            System.out.println("Book not found, type another book : ");
            title = InputReader.getInstance().nextLine();
            searchBookByTitleHelper(title);
        }

        return bookOptional.get();
    }

    public Student searchStudentByUsn(String usn) {
        Optional<Student> studentOptional = studentService.findStudentByUsn(usn);

        if(studentOptional.isEmpty()) {
            System.out.println("Student not found, type another student usn : ");
            usn = InputReader.getInstance().nextLine();
            searchStudentByUsn(usn);
        }

        return studentOptional.get();
    }
}

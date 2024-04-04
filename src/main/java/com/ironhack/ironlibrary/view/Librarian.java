/* (C)2024 */
package com.ironhack.ironlibrary.view;

import com.ironhack.ironlibrary.model.Author;
import com.ironhack.ironlibrary.model.Book;
import com.ironhack.ironlibrary.repository.AuthorRepository;
import com.ironhack.ironlibrary.repository.BookRepository;
import com.ironhack.ironlibrary.service.AuthorService;
import com.ironhack.ironlibrary.service.BookService;
import com.ironhack.ironlibrary.utils.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

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

    public void searchBookByTitle() {
        System.out.println("Enter a book title");
        Scanner scanner = new Scanner(System.in);
        String bookTitle = scanner.nextLine();
        Optional<Book> bookOptional = bookService.searchBookByTitle(bookTitle);
        System.out.println(bookOptional.isPresent());
    }

    public void searchBookByCategory() {
        System.out.println("Enter a category");
        Scanner scanner = new Scanner(System.in);
        String category = scanner.nextLine();
        Optional<Book> bookOptional = bookService.searchBookByCategory(category);
        if(bookOptional.isPresent()) {
            System.out.println("Book found: " + bookOptional.get().getTitle());
        } else {
            System.out.println("Book not found");
        }
    }

    public void addABook() {
        System.out.print("Enter isbn : ");
        Scanner scanner = new Scanner(System.in);
        String isbn = scanner.nextLine();
        System.out.print("Enter title : ");
        String title = scanner.nextLine();
        System.out.print("Enter category : ");
        String category = scanner.nextLine();
        System.out.print("Enter Author name : ");
        String name = scanner.nextLine();
        System.out.print("Enter Author mail : ");
        String email = scanner.nextLine();
        System.out.print("Enter number of books : ");
        int quantity = Integer.parseInt(scanner.nextLine());

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
        Scanner scanner = new Scanner(System.in);
        String authorName = scanner.nextLine();
        Optional<Author> authorOptional = authorService.searchBookByAuthor(authorName);
        if (authorOptional.isPresent()) {
            System.out.println("Book found: " + authorOptional.get().getAuthorBook().getTitle());
        } else {
            System.out.println("Book not found");
        }
    }
}

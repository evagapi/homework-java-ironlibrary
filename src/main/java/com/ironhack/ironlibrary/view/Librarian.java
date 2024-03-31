/* (C)2024 */
package com.ironhack.ironlibrary.view;

import com.ironhack.ironlibrary.model.Author;
import com.ironhack.ironlibrary.model.Book;
import com.ironhack.ironlibrary.repository.AuthorRepository;
import com.ironhack.ironlibrary.repository.BookRepository;
import com.ironhack.ironlibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public void searchBookByTitle() {
        System.out.println("Enter a book title");
        Scanner scanner = new Scanner(System.in);
        String bookTitle = scanner.nextLine();
        scanner.close();
        Optional<Book> bookOptional = bookService.searchBookByTitle(bookTitle);
        System.out.println(bookOptional.isPresent());
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

}

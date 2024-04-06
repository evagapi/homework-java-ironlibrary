/* (C)2024 */
package com.ironhack.ironlibrary.view;

import com.ironhack.ironlibrary.model.Author;
import com.ironhack.ironlibrary.model.Book;
import com.ironhack.ironlibrary.repository.AuthorRepository;
import com.ironhack.ironlibrary.repository.BookRepository;
import com.ironhack.ironlibrary.service.AuthorService;
import com.ironhack.ironlibrary.service.BookService;
import com.ironhack.ironlibrary.utils.InputReader;
import com.ironhack.ironlibrary.utils.Table;
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
        System.out.print("Enter number of books : ");
        int quantity = Integer.parseInt(InputReader.getInstance().nextLine());

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

    public String checkIsbn(String isbnTest) {

        List<Author> authors = authorService.getAllAuthors();

        for(Author author: authors){
            if (Objects.equals(author.getAuthorBook().getIsbn(), isbnTest)) {
                System.out.print("This ISBN already exists, type another one : ");
                isbnTest = InputReader.getInstance().nextLine();
                checkIsbn(isbnTest);
            }
        }

        return isbnTest;
    }
}

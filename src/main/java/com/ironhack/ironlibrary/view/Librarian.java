/* (C)2024 */
package com.ironhack.ironlibrary.view;

import com.ironhack.ironlibrary.model.Book;
import com.ironhack.ironlibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;

@Component
public class Librarian {

    @Autowired
    private BookService bookService;

    public void searchBookByTitle() {
        System.out.println("Enter a book title");
        Scanner scanner = new Scanner(System.in);
        String bookTitle = scanner.nextLine();
        scanner.close();
        Optional<Book> bookOptional = bookService.searchBookByTitle(bookTitle);
        System.out.println(bookOptional.isPresent());
    }

}

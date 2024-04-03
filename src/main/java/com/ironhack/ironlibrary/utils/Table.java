/* (C)2024 */
package com.ironhack.ironlibrary.utils;

import com.ironhack.ironlibrary.model.Author;
import com.ironhack.ironlibrary.model.Book;
import com.ironhack.ironlibrary.model.Issue;

import java.util.List;

public class Table {
    public static void printBooks(List<Book> books) {
        System.out.printf("%-15s %-45s %-15s %-15s\n", "Book ISBN", "Book Title", "Category", "No of Books");

        for (Book book : books) {
            System.out.printf("%-15s %-45s %-15s %-15s\n", book.getIsbn(), book.getTitle(), book.getCategory(), book.getQuantity());
        }
    }

    public static void printBooksWithAuthor(List<Author> authors) {
        System.out.printf("%-15s %-45s %-15s %-15s %-15s\n", "Book ISBN", "Book Title", "Category", "No of Books", "Author name");

        for (Author author : authors) {
            Book book = author.getAuthorBook();
            System.out.printf("%-15s %-45s %-15s %-15s %-15s\n", book.getIsbn(), book.getTitle(), book.getCategory(), book.getQuantity(), author.getName());
        }
    }

    public static void printIssues(List<Issue> issues) {
        System.out.printf("%-45s %-15s %-15s\n", "Book Title", "Student Name", "Return Date");

        for (Issue issue : issues) {
            System.out.printf("%-45s %-15s %-15s\n", issue.getIssueBook().getTitle(), issue.getIssueStudent().getName(), issue.getReturnDate());
        }
    }
}

/* (C)2024 */
package com.ironhack.ironlibrary.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Menu {

    @Autowired
    Librarian librarian;
    private static Logger LOG = LoggerFactory
            .getLogger(Menu.class);

    public Menu() {
    }

    public void displayOptions() {
        System.out.println("==============");
        System.out.println("M E N U");
        System.out.println("==============");
        System.out.println("1. Add a book");
        System.out.println("2. Search book by title");
        System.out.println("3. Search book by category");
        System.out.println("4. Search book by Author");
        System.out.println("5. List all books along with author");
        System.out.println("6. Issue book to student");
        System.out.println("7. List books by usn");
        System.out.println("8. Exit");
        System.out.println("==============");
        System.out.print("Enter an option: ");
    }

    public void menuRun() {
        int option;

        displayOptions();

        Scanner scanner = new Scanner(System.in);

        option = scanner.nextInt();

        while (option != 8) {
            if (option == 1) {
                librarian.addABook();
            } else if (option == 2) {
                librarian.searchBookByTitle();
            } else if (option == 3) {
                System.out.println("Under construction \uD83D\uDEA7");
            } else if (option == 4) {
                System.out.println("Under construction \uD83D\uDEA7");
            } else if (option == 5) {
                System.out.println("Under construction \uD83D\uDEA7");
            } else if (option == 6) {
                System.out.println("Under construction \uD83D\uDEA7");
            } else if (option == 7) {
                System.out.println("Under construction \uD83D\uDEA7");
            }

            displayOptions();

            option = scanner.nextInt();
        }
    }
}

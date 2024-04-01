/* (C)2024 */
package com.ironhack.ironlibrary.view;

import com.github.lalyos.jfiglet.FigletFont;
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

    public void displayOptions(int options[], String items[]) {
        System.out.println("==============");
        System.out.println("M E N U");
        System.out.println("==============");
       for (int i = 0; i < options.length; i++) {
           System.out.printf("%d. %s\n", options[i], items[i]);
       }
        System.out.println("==============");
        System.out.print("Enter an option: ");
    }

    public void menuRun() {
        int choice;

        int options[] = {1, 2, 3, 4, 5, 5, 7, 8};
        String menuItems[] = {"Add a book",
                "Search book by title",
                "Search book by category",
                "Search book by Author",
                "List all books along with author",
                "Issue book to student",
                "List books by usn",
                "Exit"
        };
        int EXIT = options[options.length - 1];
        String underConstruction = "Under construction \uD83D\uDEA7";
        System.out.print(FigletFont.convertOneLine("BinaryBlaze Library"));

        displayOptions(options, menuItems);

        Scanner scanner = new Scanner(System.in);

        choice = scanner.nextInt();

        while (choice != EXIT) {
            if (choice == options[0]) {
                librarian.addABook();
            } else if (choice == options[1]) {
                librarian.searchBookByTitle();
            } else if (choice == options[2]) {
                System.out.println(underConstruction);
            } else if (choice == options[3]) {
                System.out.println(underConstruction);
            } else if (choice == options[4]) {
                System.out.println(underConstruction);
            } else if (choice == options[5]) {
                System.out.println(underConstruction);
            } else if (choice == options[6]) {
                System.out.println(underConstruction);
            }

            displayOptions(options, menuItems);

            choice = scanner.nextInt();
        }

        System.out.println("See you soon! \uD83D\uDC4B");
    }
}

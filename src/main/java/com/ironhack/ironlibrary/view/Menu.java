/* (C)2024 */
package com.ironhack.ironlibrary.view;

import com.github.lalyos.jfiglet.FigletFont;
import com.ironhack.ironlibrary.utils.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Menu {

    @Autowired
    Librarian librarian;
    @Autowired
    Validator validator;
    private static Logger LOG = LoggerFactory
            .getLogger(Menu.class);

    public Menu() {
    }

    public void displayOptions(ArrayList<MenuItem> items) {
        System.out.println("==============");
        System.out.println("M E N U");
        System.out.println("==============");
       for (int i = 0; i < items.size(); i++) {
           MenuItem item = items.get(i);
           System.out.printf("%d. %s\n", i + 1, item.getText());
       }
        System.out.println("==============");
    }

    public void menuRun() {
        int choice;

        ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
        menuItems.add(new MenuItem("Add a book"));
        menuItems.add(new MenuItem("Search book by title"));
        menuItems.add(new MenuItem("Search book by category"));
        menuItems.add(new MenuItem("Search book by Author"));
        menuItems.add(new MenuItem("List all books along with author"));
        menuItems.add(new MenuItem("Issue book to student"));
        menuItems.add(new MenuItem("List books by usn"));
        menuItems.add(new MenuItem("Exit"));

        int EXIT = menuItems.size();
        String underConstruction = "\uD83D\uDEA7 Under construction \uD83D\uDEA7";
        System.out.print(FigletFont.convertOneLine("BinaryBlaze Library"));

        displayOptions(menuItems);

        choice = validator.handleInteger("Enter an option: ", "⚠\uFE0F Invalid input ⚠\uFE0F", 1, EXIT);

        while (choice != EXIT) {
            if (choice == 1) {
                librarian.addABook();
            } else if (choice == 2) {
                librarian.searchBookByTitle();
            } else if (choice == 3) {
                librarian.searchBookByCategory();
            } else if (choice == 4) {
                librarian.searchBookByAuthor();
            } else if (choice == 5) {
                librarian.getAllBooksAndAuthor();
            } else if (choice == 6) {
                System.out.println(underConstruction);
            } else if (choice == 7) {
                System.out.println(underConstruction);
            }

            displayOptions(menuItems);

            choice = validator.handleInteger("Enter an option: ", "⚠\uFE0F Invalid input ⚠\uFE0F", 1, EXIT);
        }

        System.out.println("See you soon! \uD83D\uDC4B");
    }
}

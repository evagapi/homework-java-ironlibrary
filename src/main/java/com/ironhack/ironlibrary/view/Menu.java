/* (C)2024 */
package com.ironhack.ironlibrary.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Menu {

    @Autowired
    Librarian librarian;

    private static Logger LOG = LoggerFactory
            .getLogger(Menu.class);
    public Menu() {
    }

    public void menuRun() {
        librarian.searchBookByTitle();
    }
}

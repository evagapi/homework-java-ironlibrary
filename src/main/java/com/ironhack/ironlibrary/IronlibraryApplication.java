/* (C)2024 */
package com.ironhack.ironlibrary;

import com.ironhack.ironlibrary.view.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IronlibraryApplication implements CommandLineRunner {

    @Autowired
    Menu menu;

    private static Logger LOG = LoggerFactory
            .getLogger(IronlibraryApplication.class);
    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(IronlibraryApplication.class, args);
        LOG.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("EXECUTING : command line runner");
        //menu.menuRun();
    }
}

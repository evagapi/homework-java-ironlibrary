/* (C)2024 */
package com.ironhack.ironlibrary;

import com.ironhack.ironlibrary.view.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@SpringBootApplication
public class IronlibraryApplication implements CommandLineRunner {

    @Autowired
    private Environment environment;
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
        if (!Arrays.asList(environment.getActiveProfiles()).contains("test")){
            menu.menuRun();
        }

    }
}

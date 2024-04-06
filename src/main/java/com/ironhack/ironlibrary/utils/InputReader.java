package com.ironhack.ironlibrary.utils;


import java.util.Scanner;

public class InputReader {

    private static InputReader instance;
    private final Scanner scanner;

    private InputReader() {
        this.scanner = new Scanner(System.in);
    }

    public static InputReader getInstance() {
        if (instance == null) {
            instance = new InputReader();
        }
        return instance;
    }

    public String nextLine() {

        return scanner.nextLine();
    }

    public void closeScanner() {
        if (instance != null) {
            scanner.close();
            instance = null;
        }
    }
}
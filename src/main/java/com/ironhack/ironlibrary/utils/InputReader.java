package com.ironhack.ironlibrary.utils;


import java.util.Scanner;

public class InputReader {

    private static final Scanner scanner = new Scanner(System.in);

    public static String nextLine() {

        return scanner.nextLine();
    }

    public static void closeScanner() {
        scanner.close();
    }
}
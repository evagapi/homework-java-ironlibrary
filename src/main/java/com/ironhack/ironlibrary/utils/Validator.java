package com.ironhack.ironlibrary.utils;

import org.springframework.stereotype.Component;

@Component
public class Validator {

    public int handleInteger(String promptMessage, String errorMessage, int lowest, int highest) {
        int number = 0;
        String stringInput;
        boolean valid = false;

        while (!valid) {
            System.out.print(promptMessage);
            stringInput = InputReader.getInstance().nextLine();
            try {
                number = Integer.parseInt(stringInput);
                if (number >= lowest && number <= highest) {
                    valid = true;
                } else {
                    System.out.println(errorMessage);
                }
            } catch (NumberFormatException exception) {
                System.out.println(errorMessage);
            }
        }
        return number;
    }
}

package com.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = null;
        char startChar = '\0';
        char endChar = '\0';

        while (text == null) {
            System.out.println("Please enter the text:");
            String inputText = scanner.nextLine().trim();
            if (inputText.isEmpty()) {
                System.out.println("Error: Text cannot be empty. Please try again.");
            } else {
                text = new StringBuilder(inputText);
            }
        }
        startChar = getValidChar(scanner, "Please enter the start character:");
        endChar = getValidChar(scanner, "Please enter the end character:");

        try {
            StringBuilder result = TextProcessor.processText(text, startChar, endChar);
            System.out.println("Result: " + result.toString());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static char getValidChar(Scanner scanner, String prompt) {
        char validChar = '\0';
        while (validChar == '\0') {
            System.out.println(prompt);
            String inputChar = scanner.nextLine().trim();
            if (inputChar.isEmpty()) {
                System.out.println("Error: Character cannot be empty. Please try again.");
            } else if (inputChar.length() != 1 || !Character.isLetter(inputChar.charAt(0))) {
                System.out.println("Error: Character must be a single letter. Please try again.");
            } else {
                validChar = inputChar.charAt(0);
            }
        }
        return validChar;
    }
}
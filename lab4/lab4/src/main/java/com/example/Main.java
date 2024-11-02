package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder inputText = null;
        char startChar = '\0';
        char endChar = '\0';

        while (inputText == null) {
            System.out.println("Please enter the text:");
            String text = scanner.nextLine().trim();
            if (text.isEmpty()) {
                System.out.println("Error: Text cannot be empty. Please try again.");
            } else {
                inputText = new StringBuilder(text);
            }
        }

        startChar = getValidChar(scanner, "Please enter the start character:");
        endChar = getValidChar(scanner, "Please enter the end character:");

        try {
            if (startChar == endChar) {
                throw new Exception("Start char can`t be the same as end char");
            }
            Text text = new Text(inputText.toString());
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
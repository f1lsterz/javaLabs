package com.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GiftBox giftBox = new GiftBox();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1. Add a sweet");
            System.out.println("2. View gift box contents");
            System.out.println("3. Sort sweets by chocolate content");
            System.out.println("4. Find sweets by chocolate content range");
            System.out.println("5. Get total weight of the gift box");
            System.out.println("6. Exit");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    addSweetToGiftBox(scanner, giftBox);
                    break;
                case 2:
                    System.out.println(giftBox);
                    break;
                case 3:
                    giftBox.sortByChocolateContent();
                    System.out.println("Sweets sorted by chocolate content.");
                    break;
                case 4:
                    findSweetsByChocolateContentRange(scanner, giftBox);
                    break;
                case 5:
                    try {
                        double totalWeight = giftBox.getTotalWeight();
                        System.out.println("Total weight of the gift box: " + totalWeight + " grams");
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void addSweetToGiftBox(Scanner scanner, GiftBox giftBox) {
        System.out.println(
                "Enter the type of sweet (MilkChocolate, DarkChocolate, Jelly, Caramel, WhiteChocolate, Marshmallow):");
        String type = scanner.nextLine().trim();

        System.out.print("Enter the name of the sweet: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter the weight of the sweet (grams): ");
        double weight = scanner.nextDouble();

        System.out.print("Enter the sugar content of the sweet (%): ");
        double sugarContent = scanner.nextDouble();

        double chocolateContent = 0;
        if (type.equalsIgnoreCase("MilkChocolate") || type.equalsIgnoreCase("DarkChocolate")
                || type.equalsIgnoreCase("WhiteChocolate")) {
            System.out.print("Enter the chocolate content of the sweet (%): ");
            chocolateContent = scanner.nextDouble();
        }

        Sweet sweet = null;
        switch (type.toLowerCase()) {
            case "milkchocolate":
                sweet = new MilkChocolate(name, weight, sugarContent, chocolateContent);
                break;
            case "darkchocolate":
                sweet = new DarkChocolate(name, weight, sugarContent, chocolateContent);
                break;
            case "jelly":
                sweet = new Jelly(name, weight, sugarContent);
                break;
            case "caramel":
                sweet = new Caramel(name, weight, sugarContent);
                break;
            case "whitechocolate":
                sweet = new WhiteChocolate(name, weight, sugarContent, chocolateContent);
                break;
            case "marshmallow":
                sweet = new Marshmallow(name, weight, sugarContent);
                break;
            default:
                System.out.println("Invalid sweet type.");
                return;
        }

        giftBox.addSweet(sweet);
        System.out.println(sweet.getName() + " has been added to the gift box.");
    }

    private static void findSweetsByChocolateContentRange(Scanner scanner, GiftBox giftBox) {
        System.out.print("Enter minimum chocolate content: ");
        double min = scanner.nextDouble();

        System.out.print("Enter maximum chocolate content: ");
        double max = scanner.nextDouble();

        List<Sweet> foundSweets = giftBox.findSweetsByChocolateContentRange(min, max);
        System.out.println("Sweets with chocolate content between " + min + " and " + max + ":");
        for (Sweet sweet : foundSweets) {
            System.out.println(sweet);
        }
    }
}
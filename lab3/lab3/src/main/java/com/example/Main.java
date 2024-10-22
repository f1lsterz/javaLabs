package com.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення кількості косметичних засобів
        int n = 0;
        while (true) {
            try {
                System.out.print("Enter the number of cosmetic items: ");
                n = scanner.nextInt();
                if (n <= 0) {
                    throw new IllegalArgumentException("Number of items must be positive.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.nextLine();

        // Масив косметичних засобів
        Cosmetic[] cosmetics = new Cosmetic[n];

        // Введення даних для кожного косметичного засобу
        for (int i = 0; i < n; i++) {
            String name, brand, category;
            double price = 0;
            int weight = 0;

            while (true) {
                try {
                    System.out.print("Enter name for cosmetic item " + (i + 1) + ": ");
                    name = scanner.nextLine();
                    if (name.isEmpty()) {
                        throw new IllegalArgumentException("Name cannot be empty.");
                    }

                    System.out.print("Enter brand for cosmetic item " + (i + 1) + ": ");
                    brand = scanner.nextLine();
                    if (brand.isEmpty()) {
                        throw new IllegalArgumentException("Brand cannot be empty.");
                    }

                    System.out.print("Enter price for cosmetic item " + (i + 1) + ": ");
                    price = scanner.nextDouble();
                    if (price < 0) {
                        throw new IllegalArgumentException("Price cannot be negative.");
                    }

                    System.out.print("Enter weight for cosmetic item " + (i + 1) + ": ");
                    weight = scanner.nextInt();
                    if (weight <= 0) {
                        throw new IllegalArgumentException("Weight must be greater than zero.");
                    }
                    scanner.nextLine(); // Очистка буфера

                    System.out.print("Enter category for cosmetic item " + (i + 1) + ": ");
                    category = scanner.nextLine();
                    if (category.isEmpty()) {
                        throw new IllegalArgumentException("Category cannot be empty.");
                    }

                    cosmetics[i] = new Cosmetic(name, brand, price, weight, category);
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next();
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        // Вивід масиву косметики
        System.out.println("\nCosmetics array:");
        for (Cosmetic cosmetic : cosmetics) {
            System.out.println(cosmetic);
        }

        // Сортування за ціною за зростанням та за вагою за спаданням
        Arrays.sort(cosmetics, Comparator.comparing(Cosmetic::getPrice)
                .thenComparing(Comparator.comparing(Cosmetic::getWeight).reversed()));

        // Вивід відсортованого масиву
        System.out.println("\nSorted array:");
        for (Cosmetic cosmetic : cosmetics) {
            System.out.println(cosmetic);
        }

        // Введення косметичного засобу для пошуку
        System.out.println("\nEnter the details of the cosmetic item to search:");
        String searchName, searchBrand, searchCategory;
        double searchPrice = 0;
        int searchWeight = 0;

        while (true) {
            try {
                System.out.print("Name: ");
                searchName = scanner.nextLine();
                if (searchName.isEmpty()) {
                    throw new IllegalArgumentException("Name cannot be empty.");
                }

                System.out.print("Brand: ");
                searchBrand = scanner.nextLine();
                if (searchBrand.isEmpty()) {
                    throw new IllegalArgumentException("Brand cannot be empty.");
                }

                System.out.print("Price: ");
                searchPrice = scanner.nextDouble();
                if (searchPrice < 0) {
                    throw new IllegalArgumentException("Price cannot be negative.");
                }

                System.out.print("Weight: ");
                searchWeight = scanner.nextInt();
                if (searchWeight <= 0) {
                    throw new IllegalArgumentException("Weight must be greater than zero.");
                }
                scanner.nextLine();

                System.out.print("Category: ");
                searchCategory = scanner.nextLine();
                if (searchCategory.isEmpty()) {
                    throw new IllegalArgumentException("Category cannot be empty.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // Пошук в масиві по заданому елементу
        Cosmetic searchItem = new Cosmetic(searchName, searchBrand, searchPrice, searchWeight, searchCategory);
        int index = Arrays.asList(cosmetics).indexOf(searchItem);

        if (index != -1) {
            System.out.println("\nFounded cosmetic: " + cosmetics[index]);
        } else {
            System.out.println("\nObject not found.");
        }

        scanner.close();
    }
}
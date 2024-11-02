package com.example;

import java.util.Objects;

public class Cosmetic {
    private String name;
    private String brand;
    private double price;
    private int weight;
    private String category;

    public Cosmetic(String name, String brand, double price, int weight, String category) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (brand == null || brand.isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be null or empty");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be greater than zero");
        }
        if (category == null || category.isEmpty()) {
            throw new IllegalArgumentException("Category cannot be null or empty");
        }

        this.name = name;
        this.brand = brand;
        this.price = price;
        this.weight = weight;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return String.format("Cosmetic{name='%s', brand ='%s', price =%.2f, weight=%d, category='%s'}", name, brand,
                price, weight, category);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Cosmetic cosmetic = (Cosmetic) o;
        return Double.compare(cosmetic.price, price) == 0 && weight == cosmetic.weight
                && Objects.equals(name, cosmetic.name) &&
                Objects.equals(brand, cosmetic.brand) &&
                Objects.equals(category, cosmetic.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, brand, price, weight, category);
    }
}

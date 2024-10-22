package com.example;

public abstract class Sweet {
    protected String name;
    protected double weight;
    protected double sugarContent;

    public Sweet(String name, double weight, double sugarContent) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name can`t be empty.");
        }

        if (weight <= 0) {
            throw new IllegalArgumentException("Sweet`s weight can`t be zero or less.");
        }

        if (sugarContent < 0) {
            throw new IllegalArgumentException("Sweet`s sugar content can`t be less than zero.");
        }

        this.name = name;
        this.weight = weight;
        this.sugarContent = sugarContent;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getSugarContent() {
        return sugarContent;
    }

    @Override
    public String toString() {
        return String.format("%s [weight=%.2f, sugar=%.2f%%]",
                name, weight, sugarContent);
    }
}

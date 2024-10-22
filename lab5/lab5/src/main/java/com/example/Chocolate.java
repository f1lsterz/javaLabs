package com.example;

public abstract class Chocolate extends Sweet {
    private double chocolateContent;

    public Chocolate(String name, double weight, double sugarContent, double chocolateContent) {
        super(name, weight, sugarContent);
        if (chocolateContent <= 0) {
            throw new IllegalArgumentException("Chocolate`s content can`t be zero or less.");
        }
        this.chocolateContent = chocolateContent;
    }

    public double getChocolateContent() {
        return chocolateContent;
    }

    @Override
    public String toString() {
        return super.toString() + ", Chocolate Content: " + chocolateContent + "%";
    }
}

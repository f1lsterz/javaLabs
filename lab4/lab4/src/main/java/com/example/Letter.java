package com.example;

// клас представлення літери
public class Letter {
    // літера
    private char value;

    // конструктор
    public Letter(char value) {
        this.value = value;
    }

    // геттер
    public char getValue() {
        return value;
    }

    // вивід
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
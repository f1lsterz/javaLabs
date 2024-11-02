package com.example;

// клас для представлення розділових знаків
public class Punctuation {
    // знак
    private char value;

    // конструктор
    public Punctuation(char value) {
        this.value = value;
    }

    // геттер
    public char getValue() {
        return value;
    }

    // вивід знаку
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
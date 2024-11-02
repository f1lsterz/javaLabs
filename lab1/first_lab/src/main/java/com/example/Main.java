package com.example;

public class Main {
    public static void main(String[] args) {
        try {
            MatrixOperations.performMatrixOperations();
        } catch (Exception e) {
            System.err.println("Unpredictable error: " + e.getMessage());
        }
    }
}
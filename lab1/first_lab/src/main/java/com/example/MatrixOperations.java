package com.example;

import java.util.Random;

public class MatrixOperations {
    public static float[][] addMatrix(float[][] A, float[][] B) throws IllegalArgumentException {
        if (A.length != B.length
                || A[0].length != B[0].length) {
            throw new IllegalArgumentException("Matrixes should have equal size");
        }

        float[][] C = new float[A.length][A[0].length];
        try {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    C[i][j] = A[i][j] + B[i][j];
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Index out of bounds while adding matrices: " + e.getMessage());
        }

        return C;
    }

    public static float calculateSumOfExtremes(float[][] matrix) {
        float sum = 0;

        try {
            for (int i = 0; i < matrix.length; i++) {
                float extreme = (i % 2 == 0) ? Float.MAX_VALUE : Float.MIN_VALUE;

                for (int j = 0; j < matrix[i].length; j++) {
                    if (i % 2 == 0) {
                        if (matrix[i][j] < extreme) {
                            extreme = matrix[i][j];
                        }
                    } else {
                        if (matrix[i][j] > extreme) {
                            extreme = matrix[i][j];
                        }
                    }
                }
                sum += extreme;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Index out of bounds while calculating extremes: " + e.getMessage());
        }
        return sum;
    }

    public static void printMatrix(float[][] matrix) {
        try {
            for (float[] row : matrix) {
                for (float elem : row) {
                    System.out.print(elem + " ");
                }
                System.out.println();
            }
        } catch (NullPointerException e) {
            System.err.println("Null matrix cannot be printed: " + e.getMessage());
        }
    }

    public static void performMatrixOperations() {
        Random random = new Random();
        int rows = random.nextInt(6) + 1;
        int cols = random.nextInt(6) + 1;
        float[][] A = generateRandomMatrix(rows, cols);
        float[][] B = generateRandomMatrix(rows, cols);

        System.out.println("Matrix A (" + rows + "x" + cols + "):");
        printMatrix(A);
        System.out.println("Matrix B (" + rows + "x" + cols + "):");
        printMatrix(B);

        try {
            float[][] C = addMatrix(A, B);
            System.out.println("Matrix C (A + B):");
            printMatrix(C);

            float sumOfExtremes = calculateSumOfExtremes(C);
            System.out.println("Sum of extremes: " + sumOfExtremes);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public static float[][] generateRandomMatrix(int rows, int cols) {
        Random random = new Random();
        float[][] matrix = new float[rows][cols];

        try {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = (random.nextFloat() * 200) - 100;
                }
            }
        } catch (NegativeArraySizeException e) {
            System.err.println("Negative size for matrix: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error while generating matrix: " + e.getMessage());
        }

        return matrix;
    }
}

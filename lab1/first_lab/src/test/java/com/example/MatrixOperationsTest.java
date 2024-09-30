package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MatrixOperationsTest {

    @Test
    public void testAddMatrix_ValidMatrices() {
        float[][] A = {
                { 1.0f, 2.0f, 3.0f },
                { 4.0f, 5.0f, 6.0f },
                { 7.0f, 8.0f, 9.0f }
        };

        float[][] B = {
                { 9.0f, 8.0f, 7.0f },
                { 6.0f, 5.0f, 4.0f },
                { 3.0f, 2.0f, 1.0f }
        };

        float[][] result = MatrixOperations.addMatrix(A, B);

        float[][] expected = {
                { 10.0f, 10.0f, 10.0f },
                { 10.0f, 10.0f, 10.0f },
                { 10.0f, 10.0f, 10.0f }
        };

        assertArrayEquals(expected, result);
    }

    @Test
    public void testAddMatrix_DifferentSizes() {
        float[][] A = {
                { 1.0f, 2.0f },
                { 3.0f, 4.0f }
        };

        float[][] B = {
                { 1.0f, 2.0f, 3.0f }
        };

        assertThrows(IllegalArgumentException.class, () -> {
            MatrixOperations.addMatrix(A, B);
        });
    }

    @Test
    public void testCalculateSumOfExtremes_ValidMatrix() {
        float[][] matrix = {
                { 1.0f, -2.0f, 3.0f },
                { 4.0f, 5.0f, 6.0f },
                { -7.0f, 8.0f, 9.0f }
        };

        float sum = MatrixOperations.calculateSumOfExtremes(matrix);

        assertEquals(-3.0f, sum);
    }
}
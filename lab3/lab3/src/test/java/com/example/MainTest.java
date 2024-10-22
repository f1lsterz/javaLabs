package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CosmeticTest {

    @Test
    void testConstructorValidInput() {
        Cosmetic cosmetic = new Cosmetic("Lipstick", "BrandA", 10.50, 15, "Makeup");
        assertNotNull(cosmetic);
        assertEquals("Lipstick", cosmetic.getName());
        assertEquals("BrandA", cosmetic.getBrand());
        assertEquals(10.50, cosmetic.getPrice());
        assertEquals(15, cosmetic.getWeight());
        assertEquals("Makeup", cosmetic.getCategory());
    }

    @Test
    void testConstructorInvalidName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cosmetic("", "BrandA", 10.50, 15, "Makeup");
        });
        assertEquals("Name cannot be null or empty", exception.getMessage());
    }

    @Test
    void testConstructorInvalidBrand() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cosmetic("Lipstick", "", 10.50, 15, "Makeup");
        });
        assertEquals("Brand cannot be null or empty", exception.getMessage());
    }

    @Test
    void testConstructorInvalidPrice() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cosmetic("Lipstick", "BrandA", -10.50, 15, "Makeup");
        });
        assertEquals("Price cannot be negative", exception.getMessage());
    }

    @Test
    void testConstructorInvalidWeight() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cosmetic("Lipstick", "BrandA", 10.50, 0, "Makeup");
        });
        assertEquals("Weight must be greater than zero", exception.getMessage());
    }

    @Test
    void testConstructorInvalidCategory() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Cosmetic("Lipstick", "BrandA", 10.50, 15, "");
        });
        assertEquals("Category cannot be null or empty", exception.getMessage());
    }

    @Test
    void testEquals() {
        Cosmetic cosmetic1 = new Cosmetic("Lipstick", "BrandA", 10.50, 15, "Makeup");
        Cosmetic cosmetic2 = new Cosmetic("Lipstick", "BrandA", 10.50, 15, "Makeup");
        assertEquals(cosmetic1, cosmetic2);
    }

    @Test
    void testNotEquals() {
        Cosmetic cosmetic1 = new Cosmetic("Lipstick", "BrandA", 10.50, 15, "Makeup");
        Cosmetic cosmetic2 = new Cosmetic("Foundation", "BrandB", 25.00, 100, "Makeup");
        assertNotEquals(cosmetic1, cosmetic2);
    }
}
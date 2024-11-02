package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GiftBoxTest {

    @Test
    public void testSweetCreation() {
        Sweet sweet = new MilkChocolate("Milk Chocolate", 100, 50, 70);
        assertNotNull(sweet);
        assertEquals("Milk Chocolate", sweet.getName());
        assertEquals(100, sweet.getWeight());
        assertEquals(50, sweet.getSugarContent());
    }

    @Test
    public void testInvalidSweetCreation() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Sweet("", 100, 50) {
            };
        });
        assertEquals("Name can`t be empty.", exception.getMessage());
    }

    @Test
    public void testAddSweet() {
        GiftBox giftBox = new GiftBox();
        Sweet sweet = new MilkChocolate("Milk Chocolate", 100, 50, 70);
        giftBox.addSweet(sweet);
        assertEquals("Gift Box contains:\nMilk Chocolate [weight=100,00, sugar=50,00%], Chocolate Content: 70.0%\n",
                giftBox.toString());
    }

    @Test
    public void testGetTotalWeight() {
        GiftBox giftBox = new GiftBox();
        giftBox.addSweet(new MilkChocolate("Milk Chocolate", 100, 50, 70));
        giftBox.addSweet(new DarkChocolate("Dark Chocolate", 90, 40, 85));
        assertEquals(190, giftBox.getTotalWeight());
    }

    @Test
    public void testSortByChocolateContent() {
        GiftBox giftBox = new GiftBox();
        giftBox.addSweet(new DarkChocolate("Dark Chocolate", 90, 40, 85));
        giftBox.addSweet(new MilkChocolate("Milk Chocolate", 100, 50, 70));

        giftBox.sortByChocolateContent();

        assertEquals(
                "Gift Box contains:\nMilk Chocolate [weight=100,00, sugar=50,00%], Chocolate Content: 70.0%\nDark Chocolate [weight=90,00, sugar=40,00%], Chocolate Content: 85.0%\n",
                giftBox.toString());
    }

    @Test
    public void testFindSweetsByChocolateContentRange() {
        GiftBox giftBox = new GiftBox();
        giftBox.addSweet(new MilkChocolate("Milk Chocolate", 100, 50, 70));
        giftBox.addSweet(new DarkChocolate("Dark Chocolate", 90, 40, 85));
        giftBox.addSweet(new Jelly("Fruit Jelly", 80, 60));

        List<Sweet> foundSweets = giftBox.findSweetsByChocolateContentRange(60, 80);
        assertEquals(1, foundSweets.size());
        assertEquals("Milk Chocolate [weight=100,00, sugar=50,00%], Chocolate Content: 70.0%",
                foundSweets.get(0).toString());
    }
}
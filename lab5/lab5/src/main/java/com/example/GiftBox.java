package com.example;

import java.util.ArrayList;
import java.util.List;

public class GiftBox {
    private List<Sweet> sweets;

    public GiftBox() {
        sweets = new ArrayList<>();
    }

    public void addSweet(Sweet sweet) {
        if (sweet == null) {
            throw new IllegalArgumentException("Sweet can`t be null.");
        }
        sweets.add(sweet);
    }

    public double getTotalWeight() {
        if (sweets.isEmpty()) {
            throw new IllegalStateException("Box is empty.");
        }
        return sweets.stream().mapToDouble(Sweet::getWeight).sum();
    }

    public void sortByChocolateContent() {
        if (sweets.isEmpty()) {
            throw new IllegalStateException("Box is empty.");
        }
        sweets.sort((s1, s2) -> {
            if (s1 instanceof Chocolate && s2 instanceof Chocolate) {
                return Double.compare(((Chocolate) s1).getChocolateContent(), ((Chocolate) s2).getChocolateContent());
            }
            return 0;
        });
    }

    public List<Sweet> findSweetsByChocolateContentRange(double min, double max) {
        if (sweets.isEmpty()) {
            throw new IllegalStateException("Box is empty.");
        }

        if (min < 0 || max < 0 || min > max) {
            throw new IllegalArgumentException("Incorrect range");
        }

        List<Sweet> result = new ArrayList<>();
        for (Sweet sweet : sweets) {
            if (sweet instanceof Chocolate) {
                double chocolateContent = ((Chocolate) sweet).getChocolateContent();
                if (chocolateContent >= min && chocolateContent <= max) {
                    result.add(sweet);
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Gift Box contains:\n");
        for (Sweet sweet : sweets) {
            builder.append(sweet).append("\n");
        }
        return builder.toString();
    }
}

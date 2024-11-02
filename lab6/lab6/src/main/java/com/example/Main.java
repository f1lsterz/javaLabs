package com.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Порожня колекція
        SweetCollection<Sweet> sweetsCollection1 = new SweetCollection<>();
        System.out.println("Empty collection created:");
        System.out.println(sweetsCollection1);
        System.out.println("Collection`s size: " + sweetsCollection1.size());

        // 2. Колекція з одним елементом
        Sweet marshmallow = new Marshmallow("Vanilla Marshmallow", 30, 15);
        SweetCollection<Sweet> sweetsCollection2 = new SweetCollection<>(marshmallow);
        System.out.println("\nCreated collection with one element:");
        System.out.println(sweetsCollection2);
        System.out.println("Collection`s size: " + sweetsCollection2.size());

        // 3. Колекція з кількома елементами, переданими через стандартну колекцію
        List<Sweet> initialSweets = new ArrayList<>();
        initialSweets.add(new MilkChocolate("Dairy Milk Chocolate", 100, 50, 70));
        initialSweets.add(new WhiteChocolate("White Dream", 80, 40, 60));
        initialSweets.add(new Jelly("Fruit Jelly", 50, 30));

        SweetCollection<Sweet> sweetsCollection3 = new SweetCollection<>(initialSweets);
        System.out.println("\nCreated collection with few elements:");
        System.out.println(sweetsCollection3);
        System.out.println("Collection`s size: " + sweetsCollection3.size());

        // Додавання нового елементу
        Sweet darkChocolate = new DarkChocolate("Dark Chocolate", 90, 40, 80);
        sweetsCollection3.add(darkChocolate);
        System.out.println("\nAdded new element:");
        System.out.println(sweetsCollection3);
        System.out.println("Collection`s size: " + sweetsCollection3.size());

        // Видалення елементу
        sweetsCollection3.remove(darkChocolate);
        System.out.println("\nAfter deleting element:");
        System.out.println(sweetsCollection3);
        System.out.println("Collection`s size: " + sweetsCollection3.size());

        // Перевірка, чи містить колекція певний елемент
        boolean containsMarshmallow = sweetsCollection3.contains(marshmallow);
        System.out.println("\nDoes collection contain 'Vanilla Marshmallow': " + containsMarshmallow);

        // Очищення колекції
        sweetsCollection3.clear();
        System.out.println("\nAfter clearing collection:");
        System.out.println(sweetsCollection3);
        System.out.println("Collection`s size: " + sweetsCollection3.size());
    }
}
package com.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SweetCollection<E extends Sweet> implements Set<E> {
    private Object[] elements;
    private int size;
    private static final int INITIAL_CAPACITY = 15;
    private static final double GROWTH_FACTOR = 1.3;

    // порожній конструктор
    public SweetCollection() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    // об'єкт узагальненого класу
    public SweetCollection(E element) {
        this();
        add(element);
    }

    // стандартна колекція об'єктів
    public SweetCollection(Collection<? extends E> collection) {
        this();
        addAll(collection);
    }

    // додавання елементу
    @Override
    public boolean add(E element) {
        if (element == null || contains(element)) {
            return false;
        }
        ensureCapacity();
        elements[size++] = element;
        return true;
    }

    // видалення елементу
    @Override
    public boolean remove(E element) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elements[i], element)) {
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                elements[--size] = null;
                return true;
            }
        }
        return false;
    }

    // розмір
    @Override
    public int size() {
        return size;
    }

    // чи містить колекція елемент
    @Override
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elements[i], element)) {
                return true;
            }
        }
        return false;
    }

    // очищення колекції
    @Override
    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    // збільшення розміру
    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = (int) (elements.length * GROWTH_FACTOR);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    // додавання елементів з іншої колекції
    public boolean addAll(Collection<? extends E> collection) {
        boolean modified = false;
        for (E element : collection) {
            if (add(element)) {
                modified = true;
            }
        }
        return modified;
    }

    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @SuppressWarnings("unchecked")
            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) elements[index++];
            }
        };
    }

    // вивід колекції
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1)
                sb.append(", ");
        }
        return sb.append("]").toString();
    }
}

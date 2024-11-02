package com.example;

public interface Set<E> {
    boolean add(E element);

    boolean remove(E element);

    int size();

    boolean contains(E element);

    void clear();
}

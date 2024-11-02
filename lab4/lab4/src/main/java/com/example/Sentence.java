package com.example;

//клас для представлення речення
public class Sentence {
    // масив елементів речення
    private Object[] elements;

    // конструктор
    public Sentence(String sentence) {
        String[] parts = sentence.split("(?<=\\W)|(?=\\W)");

        elements = new Object[parts.length];

        for (int i = 0; i < parts.length; i++) {
            String part = parts[i].trim();

            if (!part.isEmpty()) {
                if (Character.isLetter(part.charAt(0))) {
                    elements[i] = new Word(part);
                } else {
                    elements[i] = new Punctuation(part.charAt(0));
                }
            }
        }
    }

    // вивід
    @Override
    public String toString() {
        StringBuilder sentence = new StringBuilder();
        for (Object element : elements) {
            if (element instanceof Word) {
                sentence.append(((Word) element).toString()).append(" ");
            } else if (element instanceof Punctuation) {
                sentence.append(((Punctuation) element).toString());
            }
        }
        return sentence.toString().trim();
    }
}
package com.example;

//клас для представлення тексту
public class Text {
    // масив речень
    private Sentence[] sentences;

    // конструктор
    public Text(String text) {
        String[] parts = text.split("(?<=[.!?])\\s*");

        sentences = new Sentence[parts.length];
        for (int i = 0; i < parts.length; i++) {
            sentences[i] = new Sentence(parts[i].trim());
        }
    }

    // геттер
    public Sentence[] getSentences() {
        return sentences;
    }

    // вивід
    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (Sentence sentence : sentences) {
            text.append(sentence.toString()).append(". ");
        }
        return text.toString().trim();
    }
}
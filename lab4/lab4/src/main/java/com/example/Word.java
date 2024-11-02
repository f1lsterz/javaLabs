package com.example;

// клас представлення слова
public class Word {
    // масив літер
    private Letter[] letters;

    // конструктор
    public Word(String word) {
        letters = new Letter[word.length()];
        for (int i = 0; i < word.length(); i++) {
            letters[i] = new Letter(word.charAt(i));
        }
    }

    // вивід слова
    @Override
    public String toString() {
        StringBuilder word = new StringBuilder();
        for (Letter letter : letters) {
            word.append(letter.getValue());
        }
        return word.toString();
    }
}
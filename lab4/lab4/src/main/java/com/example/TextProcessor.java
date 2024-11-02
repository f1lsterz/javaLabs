package com.example;

// класс для обробки тексту
public class TextProcessor {
    // загальна обробка
    public static StringBuilder processText(Text text, char startChar, char endChar) throws Exception {
        if (text == null) {
            throw new Exception("Text cannot be empty.");
        }

        StringBuilder result = new StringBuilder();
        Sentence[] sentencesArray = text.getSentences();

        for (int i = 0; i < sentencesArray.length; i++) {
            Sentence sentence = sentencesArray[i];
            StringBuilder sentenceBuilder = new StringBuilder(sentence.toString());

            sentenceBuilder = removeSubstring(sentenceBuilder, startChar, endChar);

            removeExtraSpacesBeforePunctuation(sentenceBuilder);

            if (sentenceBuilder.length() > 0) {
                result.append(sentenceBuilder);
                char lastChar = sentenceBuilder.charAt(sentenceBuilder.length() - 1);

                if (i < sentencesArray.length - 1) {
                    if (!isPunctuation(lastChar)) {
                        result.append(". ");
                    } else {
                        result.append(" ");
                    }
                }
            }
        }

        return new StringBuilder(result.toString().trim());
    }

    // видалення пробілів
    public static void removeExtraSpacesBeforePunctuation(StringBuilder sentence) {
        for (int i = 0; i < sentence.length(); i++) {
            if (isPunctuation(sentence.charAt(i)) && i > 0 && sentence.charAt(i - 1) == ' ') {
                sentence.deleteCharAt(i - 1);
                i--;
            }
        }
    }

    // визначення знаку пунктуації
    public static boolean isPunctuation(char ch) {
        return ch == '.' || ch == '!' || ch == '?';
    }

    // видалення підрядка
    public static StringBuilder removeSubstring(StringBuilder sentence, char startChar, char endChar) {
        int longestStart = -1;
        int longestEnd = -1;
        int longestLength = 0;

        int start = -1;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == startChar) {
                start = i;
            }
            if (sentence.charAt(i) == endChar && start != -1) {
                int length = i - start + 1;

                if (length > longestLength) {
                    longestLength = length;
                    longestStart = start;
                    longestEnd = i;
                }
                start = -1;
            }
        }

        if (longestStart != -1 && longestEnd != -1) {
            sentence.delete(longestStart, longestEnd + 1);
        }

        return sentence;
    }
}
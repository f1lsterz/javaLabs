package com.example;

public class TextProcessor {
    public static void trimStringBuilder(StringBuilder sb) {
        if (sb == null) {
            throw new NullPointerException("StringBuilder cannot be null.");
        }

        while (sb.length() > 0 && Character.isWhitespace(sb.charAt(0))) {
            sb.deleteCharAt(0);
        }
        while (sb.length() > 0 && Character.isWhitespace(sb.charAt(sb.length() - 1))) {
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static StringBuilder processText(StringBuilder text, char startChar, char endChar) throws Exception {
        if (text == null || text.length() == 0) {
            throw new Exception("Text can`t be empty.");
        }

        if (text.indexOf(".") == -1) {
            throw new Exception("Text must contain at least one sentence ending with a period.");
        }

        if (startChar == '\0' || endChar == '\0') {
            throw new Exception("Start and end characters must be valid non-empty characters.");
        }

        StringBuilder result = new StringBuilder();
        StringBuilder sentence = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (currentChar == '.') {
                if (sentence.length() > 0) {
                    trimStringBuilder(sentence);
                    sentence = removeSubstring(sentence, startChar, endChar);
                    result.append(sentence).append(". ");
                }
                sentence.setLength(0);
            } else {
                sentence.append(currentChar);
            }
        }

        trimStringBuilder(result);
        return result;
    }

    public static StringBuilder removeSubstring(StringBuilder sentence, char startChar, char endChar) throws Exception {
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

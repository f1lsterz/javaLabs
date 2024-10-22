package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TextProcessorTest {

    @Test
    void testTrimStringBuilder_WithLeadingAndTrailingSpaces() {
        StringBuilder sb = new StringBuilder("  Hello World  ");
        TextProcessor.trimStringBuilder(sb);
        assertEquals("Hello World", sb.toString());
    }

    @Test
    void testTrimStringBuilder_NoSpaces() {
        StringBuilder sb = new StringBuilder("Hello");
        TextProcessor.trimStringBuilder(sb);
        assertEquals("Hello", sb.toString());
    }

    @Test
    void testTrimStringBuilder_OnlySpaces() {
        StringBuilder sb = new StringBuilder("   ");
        TextProcessor.trimStringBuilder(sb);
        assertEquals("", sb.toString());
    }

    @Test
    void testTrimStringBuilder_NullInput() {
        assertThrows(NullPointerException.class, () -> {
            TextProcessor.trimStringBuilder(null);
        });
    }

    @Test
    void testProcessText_ValidInput() throws Exception {
        StringBuilder text = new StringBuilder("This is a test sentence. Another test sentence.");
        char startChar = 't';
        char endChar = 'e';
        StringBuilder result = TextProcessor.processText(text, startChar, endChar);
        assertEquals("This is a st . Another st .", result.toString());
    }

    @Test
    void testProcessText_NoPeriodInText() {
        StringBuilder text = new StringBuilder("This is a test sentence");
        char startChar = 't';
        char endChar = 'e';
        Exception exception = assertThrows(Exception.class, () -> {
            TextProcessor.processText(text, startChar, endChar);
        });
        assertEquals("Text must contain at least one sentence ending with a period.", exception.getMessage());
    }

    @Test
    void testProcessText_EmptyText() {
        StringBuilder text = new StringBuilder("");
        char startChar = 't';
        char endChar = 'e';
        Exception exception = assertThrows(Exception.class, () -> {
            TextProcessor.processText(text, startChar, endChar);
        });
        assertEquals("Text can`t be empty.", exception.getMessage());
    }

    @Test
    void testProcessText_NoSubstringToRemove() throws Exception {
        StringBuilder text = new StringBuilder("This is a test.");
        char startChar = 'x';
        char endChar = 'z';
        StringBuilder result = TextProcessor.processText(text, startChar, endChar);
        assertEquals("This is a test.", result.toString());
    }

    @Test
    void testRemoveSubstring_ValidInput() throws Exception {
        StringBuilder sentence = new StringBuilder("abcdefg");
        char startChar = 'b';
        char endChar = 'f';
        StringBuilder result = TextProcessor.removeSubstring(sentence, startChar, endChar);
        assertEquals("ag", result.toString());
    }

    @Test
    void testRemoveSubstring_NoStartChar() throws Exception {
        StringBuilder sentence = new StringBuilder("abcdefg");
        char startChar = 'x';
        char endChar = 'f';
        StringBuilder result = TextProcessor.removeSubstring(sentence, startChar, endChar);
        assertEquals("abcdefg", result.toString());
    }

    @Test
    void testRemoveSubstring_EmptySentence() throws Exception {
        StringBuilder sentence = new StringBuilder("");
        char startChar = 'b';
        char endChar = 'f';
        StringBuilder result = TextProcessor.removeSubstring(sentence, startChar, endChar);
        assertEquals("", result.toString());
    }
}
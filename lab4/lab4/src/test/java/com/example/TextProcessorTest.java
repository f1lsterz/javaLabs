package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TextProcessorTest {

    @Test
    public void testProcessText_RemoveLongestSubstring() throws Exception {
        Text text = new Text("mmmme fdsfdsmfdsfe. fds! fdsfgmfdfe.");
        StringBuilder result = TextProcessor.processText(text, 'm', 'e');
        assertEquals("mmmme fdsfds. fds! fdsfg.", result.toString());
    }

    @Test
    public void testProcessText_EmptyText() {
        Exception exception = assertThrows(Exception.class, () -> {
            TextProcessor.processText(null, 'a', 'b');
        });
        assertEquals("Text cannot be empty.", exception.getMessage());
    }

    @Test
    public void testRemoveSubstring_LongestSubstring() {
        StringBuilder sentence = new StringBuilder("abczxyz");
        StringBuilder result = TextProcessor.removeSubstring(sentence, 'a', 'z');
        assertEquals("xyz", result.toString());
    }

}
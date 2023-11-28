package com.codechallenge.stringalignment.helper;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class StringNormalizerTest {

    @Test
    void noRepeatedCharacters() {
        Function<String, String> normalizer = StringNormalizer.getInstance();
        assertEquals("abc", normalizer.apply("abc"));
    }

    @Test
    void repeatedCharacters() {
        Function<String, String> normalizer = StringNormalizer.getInstance();
        assertEquals("abc", normalizer.apply("aaabbbccc"));
    }

    @Test
    void emptyString() {
        Function<String, String> normalizer = StringNormalizer.getInstance();
        assertEquals("", normalizer.apply(""));
    }

    @Test
    void stringWithWhitespace() {
        Function<String, String> normalizer = StringNormalizer.getInstance();
        assertEquals("a b c", normalizer.apply("a   b   c"));
    }

}
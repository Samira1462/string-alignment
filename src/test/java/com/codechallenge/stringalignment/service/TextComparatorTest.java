package com.codechallenge.stringalignment.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TextComparatorTest {

    private final TextComparator comparator = TextComparator.createTextComparator();

    @ParameterizedTest
    @CsvSource({
            "'word1 word2', 'word1 word2', 'word1 word2'",
            "'word1', 'word2', 'word2'",
            "'word1', 'word1 word2', 'word1 word2'",
            "'word1', 'word1', 'word1'",
            "'', '', ''",
            "'word word', 'word word word2', 'word word word2'",
            "'The quick <b> red </b> fox', 'A quick red fox', 'A quick <b> red </b> fox'"
    })
    void compareAndFilter(String originalCsv, String modifiedCsv, String expectedCsv) {
        List<String> originalList = Arrays.asList(originalCsv.split(" "));
        List<String> modifiedList = Arrays.asList(modifiedCsv.split(" "));
        List<String> expected = Arrays.asList(expectedCsv.split(" "));

        List<String> result = comparator.compareAndFilter(originalList, modifiedList);

        assertEquals(expected, result);
    }

}
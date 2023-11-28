package com.codechallenge.stringalignment.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codechallenge.stringalignment.helper.HtmlHelper.createTextParser;
import static com.codechallenge.stringalignment.service.TextComparator.createTextComparator;
import static org.junit.jupiter.api.Assertions.*;

class ReplacementServiceTest {
    private final ReplacementService systemUnderTest = new ReplacementService(createTextParser(), createTextComparator());


    @ParameterizedTest
    @CsvSource({
            "<p>Original</p>, Replaced, <p>Replaced</p>",
            "I don’t understand<b>this</b>, I do not understand this., I do not understand<b>this.</b>",
            "This is a tyypo., This is a typo., This is a typo.",
            "<p>Hello<b>world</b>!</p>, Hello world!, <p>Hello<b>world!</b></p>",
    })
    void getHtmlReplacement(String givenHtmlInput, String givenReplacement, String expectedHtml) {

        var actual = systemUnderTest.getHtmlReplacement(givenHtmlInput, givenReplacement);

        assertNotNull(actual);
        assertEquals(expectedHtml, actual);

    }
}
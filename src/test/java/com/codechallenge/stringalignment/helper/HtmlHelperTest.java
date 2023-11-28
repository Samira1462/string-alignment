package com.codechallenge.stringalignment.helper;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class HtmlHelperTest {
    private final HtmlHelper parser = HtmlHelper.createTextParser();

    @ParameterizedTest
    @CsvSource({
            "'<p>This is a <b>test</b>.</p>', '<p> This is a <b> test </b> . </p>'",
            "'This is soooo great!', 'This is so great!'",
            "'This is soooo great !', 'This is so great !'",
            "'<div>Example: <i>Welll</i> done!</div>', '<div> Example: <i> Wel </i> done! </div>'",
            "'Just a simple sentence.', 'Just a simple sentence.'",
            "'Amazing!!! Really?', 'Amazing! Really?'",
            "'<p>Hello<b>world</b></p>', '<p> Hello <b> world </b> </p>'",
            "'<div><br><hr></div>', '<div> <br> <hr> </div>'",
            "'Cafe & Restaurant @ Night', 'Cafe & Restaurant @ Night'",
            "'Mixed CASE Example', 'Mixed CASE Example'"

    })
    void parseContent(String input, String expectedCsv) {
        List<String> expected = Arrays.stream(expectedCsv.split(" "))
                .map(s -> s.replace("_", " "))
                .collect(Collectors.toList());
        List<String> Actual = parser.apply(input, StringNormalizer.getInstance());
        assertEquals(expected, Actual);
    }
}
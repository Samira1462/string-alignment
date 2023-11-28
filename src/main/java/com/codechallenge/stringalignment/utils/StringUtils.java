package com.codechallenge.stringalignment.utils;

import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public final class StringUtils {
    private static final Pattern TEXT_HTML_PATTERN = Pattern.compile("(<[^>]*>)|([^<\\s]+)|([.?!,])");

    private StringUtils() {
    }

    public static List<String> applyRule(String text, Function<String, String> rule) {
        return Stream.of(text.trim().split("\\s+"))
                .filter(s -> !s.isEmpty())
                .map(rule)
                .toList();
    }

    public static Matcher groupWordAndHtml(String text) {
        return TEXT_HTML_PATTERN.matcher(text);
    }

    public static boolean firstContainsWord(List<String> first, String word) {
        return first.stream().anyMatch(item -> equalsIgnoreCaseStripPunctuation(item, word));
    }

    public static boolean equalsIgnoreCaseStripPunctuation(String str1, String str2) {
        return stripPunctuation(str1).equalsIgnoreCase(stripPunctuation(str2));
    }

    public static boolean isHtmlTag(String word) {
        return word.startsWith("<") && word.endsWith(">");
    }
    private static String stripPunctuation(String str) {
        return str.replaceAll("[,\\.!?]", "");
    }

    public static boolean endsWithPunctuation(String str) {
        return str.matches(".*[,.!?:]");
    }
}

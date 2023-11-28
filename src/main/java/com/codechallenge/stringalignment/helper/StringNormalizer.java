package com.codechallenge.stringalignment.helper;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringNormalizer {
    private StringNormalizer() {
    }

    private static final Pattern REPEATED_CHARACTERS_PATTERN = Pattern.compile("(.)\\1{2,}");

    public static Function<String, String> getInstance() {
      return s -> {
          Matcher repeatMatcher = REPEATED_CHARACTERS_PATTERN.matcher(s);
          return repeatMatcher.replaceAll("$1");
      };
    }
}

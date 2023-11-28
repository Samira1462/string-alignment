package com.codechallenge.stringalignment.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.StreamSupport;

import static com.codechallenge.stringalignment.utils.StringUtils.applyRule;
import static com.codechallenge.stringalignment.utils.StringUtils.groupWordAndHtml;

public final class HtmlHelper {
    private HtmlHelper() {
    }

    public static HtmlHelper createTextParser() {
        return new HtmlHelper();
    }

    public List<String> apply(String text, Function<String, String> rule) {
        if (text == null || text.isEmpty()) {
            return new ArrayList<>();
        }

        Iterable<String> iterable = () -> new MatcherIterator(groupWordAndHtml(text));

        return StreamSupport.stream(iterable.spliterator(), false)
                .map(s -> applyRule(s, rule))
                .flatMap(Collection::stream)
                .toList();
    }
}


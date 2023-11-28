package com.codechallenge.stringalignment.helper;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;

public record MatcherIterator(Matcher matcher) implements Iterator<String> {

    @Override
    public boolean hasNext() {
        return matcher.find();
    }

    @Override
    public String next() throws NoSuchElementException {
        if (matcher == null) {
            throw new NoSuchElementException("matcher is null");
        }

        return matcher.group();
    }
}

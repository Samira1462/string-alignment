package com.codechallenge.stringalignment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.codechallenge.stringalignment.utils.StringUtils.*;

public final class TextComparator {

    private TextComparator() {
    }

    public static TextComparator createTextComparator() {
        return new TextComparator();
    }

    public List<String> compare(List<String> parsedHtmlInputList, List<String> parsedReplacementList) {
        List<String> result = new ArrayList<>();
        int modifiedIndex = 0;

        for (String originalWord : parsedHtmlInputList) {
            if (isHtmlTag(originalWord)) {
                result.add(originalWord);
            } else {
                modifiedIndex = addMissingWordsFromReplacementList(
                        result,
                        parsedHtmlInputList,
                        parsedReplacementList,
                        modifiedIndex
                );
                modifiedIndex = replaceWordIfNecessary(
                        result,
                        originalWord,
                        parsedReplacementList,
                        modifiedIndex
                );
            }
        }

        addRemainingWordsInReplacementList(result, parsedReplacementList, modifiedIndex);
        return result;
    }

    private int addMissingWordsFromReplacementList(
            List<String> result,
            List<String> parsedHtmlInputList,
            List<String> parsedReplacementList,
            int startIndex
    ) {
        while (startIndex < parsedReplacementList.size() && !firstContainsWord(parsedHtmlInputList, parsedReplacementList.get(startIndex))) {
            result.add(parsedReplacementList.get(startIndex));
            startIndex++;
        }
        return startIndex;
    }

    private int replaceWordIfNecessary(List<String> result, String originalWord, List<String> parsedReplacementList, int startIndex) {
        if (startIndex < parsedReplacementList.size() && equalsIgnoreCaseStripPunctuation(originalWord, parsedReplacementList.get(startIndex))) {
            result.add(endsWithPunctuation(parsedReplacementList.get(startIndex)) ? parsedReplacementList.get(startIndex) : originalWord);
            startIndex++;
        }
        return startIndex;
    }

    private void addRemainingWordsInReplacementList(List<String> result, List<String> parsedReplacementList, int startIndex) {
        result.addAll(IntStream.range(startIndex, parsedReplacementList.size())
                .mapToObj(parsedReplacementList::get)
                .toList());
    }
}

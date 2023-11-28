package com.codechallenge.stringalignment.service;

import java.util.ArrayList;
import java.util.List;

import static com.codechallenge.stringalignment.utils.StringUtils.*;

public final class TextComparator {

    private TextComparator() {
    }

    public static TextComparator createTextComparator() {
        return new TextComparator();
    }
    public List<String> compareAndFilter(List<String> originalList, List<String> modifiedList) {
        List<String> result = new ArrayList<>();
        int modifiedIndex = 0;

        for (String originalWord : originalList) {
            if (isHtmlTag(originalWord)) {
                result.add(originalWord);
            } else {
                modifiedIndex = addMissingWordsFromModifiedList(
                        result,
                        originalList,
                        modifiedList,
                        modifiedIndex
                );
                modifiedIndex = replaceWordIfNecessary(
                        result,
                        originalWord,
                        modifiedList,
                        modifiedIndex
                );
            }
        }

        addRemainingWords(result, modifiedList, modifiedIndex);
        return result;
    }

    private int addMissingWordsFromModifiedList(
            List<String> result,
            List<String> originalList,
            List<String> modifiedList,
            int startIndex
    ) {
        while (startIndex < modifiedList.size() && !firstContainsWord(originalList, modifiedList.get(startIndex))) {
            result.add(modifiedList.get(startIndex));
            startIndex++;
        }
        return startIndex;
    }

    private int replaceWordIfNecessary(List<String> result, String originalWord, List<String> modifiedList, int startIndex) {
        if (startIndex < modifiedList.size() && equalsIgnoreCaseStripPunctuation(originalWord, modifiedList.get(startIndex))) {
            result.add(endsWithPunctuation(modifiedList.get(startIndex)) ? modifiedList.get(startIndex) : originalWord);
            startIndex++;
        }
        return startIndex;
    }

    private void addRemainingWords(List<String> result, List<String> modifiedList, int startIndex) {
        for (int i = startIndex; i < modifiedList.size(); i++) {
            result.add(modifiedList.get(i));
        }
    }
}

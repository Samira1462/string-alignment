package com.codechallenge.stringalignment.service;

import com.codechallenge.stringalignment.helper.HtmlHelper;
import com.codechallenge.stringalignment.helper.StringNormalizer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.codechallenge.stringalignment.utils.StringUtils.isHtmlTag;

public class ReplacementService {
    private final HtmlHelper parser;
    private final TextComparator textComparator;

    public ReplacementService(HtmlHelper parser, TextComparator textComparator) {
        this.parser = parser;
        this.textComparator = textComparator;
    }

    public String getHtmlReplacement(String htmlInput, String replacement) {
        List<String> parsedHtmlInput = parser.apply(htmlInput, StringNormalizer.getInstance());
        List<String> parsedReplacement = parser.apply(replacement, StringNormalizer.getInstance());

        List<String> list = textComparator.compare(
                parsedHtmlInput,
                parsedReplacement
        );

        return processResult(list);
    }


    public static String processResult(List<String> words) {
        return IntStream.range(0, words.size())
                .mapToObj(i -> {
                    String currentWord = words.get(i);
                    boolean isCurrentHtmlTag = isHtmlTag(currentWord);
                    boolean isPrevHtmlTag = i > 0 && isHtmlTag(words.get(i - 1));

                    return (i > 0 && !isCurrentHtmlTag && !isPrevHtmlTag ? " " : "") + currentWord;
                })
                .collect(Collectors.joining());
    }
}

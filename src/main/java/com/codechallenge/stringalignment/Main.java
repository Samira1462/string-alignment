package com.codechallenge.stringalignment;

import com.codechallenge.stringalignment.helper.HtmlHelper;
import com.codechallenge.stringalignment.service.ReplacementService;
import com.codechallenge.stringalignment.service.TextComparator;

import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        if (args.length == 2) {
            logger.info("number of input value is not correct");
            System.exit(1);
        }

        var htmlInput = args[0];
        var replacement = args[1];

        Main main = new Main();
        main.executor(htmlInput, replacement);
    }

    private void executor(String htmlInput, String replacement) {
        var parser = HtmlHelper.createTextParser();
        var comparator = TextComparator.createTextComparator();

        var replacementService = new ReplacementService(parser, comparator);

        String output = replacementService.getHtmlReplacement(htmlInput, replacement);
        logger.info(output);
    }
}
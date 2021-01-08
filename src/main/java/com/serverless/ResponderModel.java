package com.serverless;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResponderModel {
    private final String teamName = "Jovenes En Accion";

    public String answer(String question) {
        if ("".equals(question)){
            return teamName;
        }

        Matcher sumMatcher = Pattern.compile(".*what is the sum of (\\d+) and (\\d+)").matcher(question);
        if (sumMatcher.matches()) {
            return String.valueOf(Integer.parseInt(sumMatcher.group(1)) + Integer.parseInt(sumMatcher.group(2)));
        }

        Matcher nameMatcher = Pattern.compile(".*what is your name").matcher(question);
        if (nameMatcher.matches()) {
            return teamName;
        }

        Matcher plusMatcher = Pattern.compile(".*what is (\\d+) plus (\\d+)").matcher(question);
        if (plusMatcher.matches()) {
            return String.valueOf(Integer.parseInt(plusMatcher.group(1)) + Integer.parseInt(plusMatcher.group(2)));
        }

        Matcher largestMatcher = Pattern.compile(".*which of the following numbers is the largest: (\\d+), (\\d+)").matcher(question);
        if (largestMatcher.matches()) {
            return Integer.parseInt(largestMatcher.group(1)) > Integer.parseInt(largestMatcher.group(2))? largestMatcher.group(1) : largestMatcher.group(2);
        }

        Matcher largestFourMatcher = Pattern.compile(".*which of the following numbers is the largest: (\\d+), (\\d+), (\\d+), (\\d+)").matcher(question);
        if (largestFourMatcher.matches()) {
            String respuesta1 = Integer.parseInt(largestFourMatcher.group(1)) > Integer.parseInt(largestFourMatcher.group(2))? largestFourMatcher.group(1) : largestFourMatcher.group(2);
            String respuesta2 = Integer.parseInt(largestFourMatcher.group(3)) > Integer.parseInt(largestFourMatcher.group(4))? largestFourMatcher.group(3) : largestFourMatcher.group(4);
            return Integer.parseInt(respuesta1) > Integer.parseInt(respuesta2)? respuesta1 : respuesta2;
        }

        return teamName;
    }

}
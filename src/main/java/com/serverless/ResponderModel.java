package com.serverless;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResponderModel {
    private final String teamName = "Jovenes En Accion";

    public String answer(String question) {
        if ("".equals(question)) {
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
            return Integer.parseInt(largestMatcher.group(1)) > Integer.parseInt(largestMatcher.group(2)) ? largestMatcher.group(1) : largestMatcher.group(2);
        }

        Matcher largestFourMatcher = Pattern.compile(".*which of the following numbers is the largest: (\\d+), (\\d+), (\\d+), (\\d+)").matcher(question);
        if (largestFourMatcher.matches()) {
            String respuesta1 = Integer.parseInt(largestFourMatcher.group(1)) > Integer.parseInt(largestFourMatcher.group(2)) ? largestFourMatcher.group(1) : largestFourMatcher.group(2);
            String respuesta2 = Integer.parseInt(largestFourMatcher.group(3)) > Integer.parseInt(largestFourMatcher.group(4)) ? largestFourMatcher.group(3) : largestFourMatcher.group(4);
            return Integer.parseInt(respuesta1) > Integer.parseInt(respuesta2) ? respuesta1 : respuesta2;
        }

        Matcher multiplyMatcher = Pattern.compile(".*what is (\\d+) multiplied by (\\d+)").matcher(question);
        if (multiplyMatcher.matches()) {
            return String.valueOf(Integer.parseInt(multiplyMatcher.group(1)) * Integer.parseInt(multiplyMatcher.group(2)));
        }

        Matcher squartCubeMatcher = Pattern.compile(".*which of the following numbers is both a square and a cube: (\\d+), (\\d+)").matcher(question);
        if (squartCubeMatcher.matches()) {
            if (Math.sqrt(Double.parseDouble(squartCubeMatcher.group(1))) % 2 == 0
                    && Math.cbrt(Double.parseDouble(squartCubeMatcher.group(1))) % 2 == 0) {
                return squartCubeMatcher.group(1);
            } else if (Math.sqrt(Double.parseDouble(squartCubeMatcher.group(2))) % 2 == 0
                    && Math.cbrt(Double.parseDouble(squartCubeMatcher.group(2))) % 2 == 0) {
                return squartCubeMatcher.group(2);
            } else return "";
        }

        Matcher squartCubeFourMatcher = Pattern.compile(".*which of the following numbers is both a square and a cube: (\\d+), (\\d+), (\\d+), (\\d+)").matcher(question);
        if (squartCubeFourMatcher.matches()) {
            if (Math.sqrt(Double.parseDouble(squartCubeFourMatcher.group(1))) % 2 == 0
                    && Math.cbrt(Double.parseDouble(squartCubeFourMatcher.group(1))) % 2 == 0) {
                return squartCubeFourMatcher.group(1);
            } else if (Math.sqrt(Double.parseDouble(squartCubeFourMatcher.group(2))) % 2 == 0
                    && Math.cbrt(Double.parseDouble(squartCubeFourMatcher.group(2))) % 2 == 0) {
                return squartCubeFourMatcher.group(2);
            } else if (Math.sqrt(Double.parseDouble(squartCubeFourMatcher.group(3))) % 2 == 0
                    && Math.cbrt(Double.parseDouble(squartCubeFourMatcher.group(3))) % 2 == 0) {
                return squartCubeFourMatcher.group(3);
            } else if (Math.sqrt(Double.parseDouble(squartCubeFourMatcher.group(4))) % 2 == 0
                    && Math.cbrt(Double.parseDouble(squartCubeFourMatcher.group(4))) % 2 == 0) {
                return squartCubeFourMatcher.group(4);
            } else return "";
        }


        return teamName;
    }

}
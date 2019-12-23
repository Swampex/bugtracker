package ru.tropin.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpHandler {

    public static String getSubstring(String regExp, String text) {
        String result;

        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(text);
        matcher.find();
        result = matcher.group();

        return result;
    }
}

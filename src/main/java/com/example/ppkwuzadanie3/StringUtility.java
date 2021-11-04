package com.example.ppkwuzadanie3;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.Arrays;
import java.util.Locale;

public class StringUtility {

    public static String jsonToFormat(String json, String format) {
        format = format.toLowerCase(Locale.ROOT);

        if (Arrays.stream(new String[]{"json", "xml", "csv"}).noneMatch(format::contains)) {
            return "Incorrect result format";
        }

        String formattedJson = "Test";

        return formattedJson;
    }
}

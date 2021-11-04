package com.example.ppkwuzadanie3;

import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Locale;

public class StringUtility {

    public static String jsonToFormat(String json, String format) {
        format = format.toLowerCase(Locale.ROOT);

        if (Arrays.stream(new String[]{"json", "xml", "csv"}).noneMatch(format::contains)) {
            return "Incorrect result format";
        }

        final String uri = "http://localhost:8080/api/" + json;

        RestTemplate restTemplate = new RestTemplate();
        String formattedJson = restTemplate.getForObject(uri, String.class);

        return formattedJson;
    }
}

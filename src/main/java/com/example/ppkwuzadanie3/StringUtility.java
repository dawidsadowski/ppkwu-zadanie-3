package com.example.ppkwuzadanie3;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Locale;

public class StringUtility {

    public static String jsonToFormat(String text, String format) throws JSONException {
        format = format.toLowerCase(Locale.ROOT);

        if (Arrays.stream(new String[]{"json", "xml", "csv"}).noneMatch(format::contains)) {
            return "Incorrect result format";
        }

        final String uri = "http://localhost:8080/api/" + text;

        RestTemplate restTemplate = new RestTemplate();
        String formattedJson = restTemplate.getForObject(uri, String.class);

        switch(format) {
            case "xml":
                JSONObject json = new JSONObject(formattedJson);
                formattedJson = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><stringData>";
                formattedJson = formattedJson + XML.toString(json) + "</stringData>";
                break;
            case "csv":
                formattedJson = "Not yet implemented";
        }

        return formattedJson;
    }
}

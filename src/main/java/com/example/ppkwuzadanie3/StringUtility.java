package com.example.ppkwuzadanie3;

import org.json.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Locale;

public class StringUtility {

    public static String jsonToFormat(String text, String format) throws JSONException {
        format = format.toLowerCase(Locale.ROOT);

        if (Arrays.stream(new String[]{"txt", "json", "xml", "csv"}).noneMatch(format::contains)) {
            return "Incorrect result format";
        }

        final String uri = "http://localhost:8080/api/" + text;

        RestTemplate restTemplate = new RestTemplate();
        String formattedJson = restTemplate.getForObject(uri, String.class);

        switch (format) {
            case "txt": {
                JSONObject json = new JSONObject(formattedJson);
                String _text = (String) json.get("text");
                Integer _digits = (Integer) json.get("digits");
                Integer _upperCase = (Integer) json.get("upperCase");
                Integer _lowerCase = (Integer) json.get("lowerCase");
                Integer _whitespace = (Integer) json.get("whitespace");
                Integer _specialCharacters = (Integer) json.get("specialCharacters");

                formattedJson = String.format("Text: %s\nDigits: %d\nUpper case: %d\nLower case: %d\nWhitespace: %d\nSpecial characters: %d",
                        _text, _digits, _upperCase, _lowerCase, _whitespace, _specialCharacters);
                break;
            }

            case "xml": {
                JSONObject json = new JSONObject(formattedJson);
                formattedJson = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><stringData>";
                formattedJson = formattedJson + XML.toString(json) + "</stringData>";
                break;
            }
            case "csv": {
                formattedJson = "{\"stringData\":[" + formattedJson + "]}";
                JSONObject json = new JSONObject(formattedJson);
                JSONArray jsonArray = json.getJSONArray("stringData");
                formattedJson = CDL.toString(jsonArray);
                break;
            }
        }

        return formattedJson;
    }
}

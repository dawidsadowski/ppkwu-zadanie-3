package com.example.ppkwuzadanie3.controller;

import com.example.ppkwuzadanie3.StringUtility;
import org.json.JSONException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StringUtilityController {

    @GetMapping(value = "/", produces = {MediaType.APPLICATION_XML_VALUE})
    String getStringUtility(@RequestParam String text, @RequestParam String format) throws JSONException {
        return StringUtility.jsonToFormat(text, format);
    }

}

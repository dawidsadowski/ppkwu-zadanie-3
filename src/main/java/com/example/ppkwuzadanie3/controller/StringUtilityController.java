package com.example.ppkwuzadanie3.controller;

import com.example.ppkwuzadanie3.StringUtility;
import org.json.JSONException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StringUtilityController {

    @GetMapping(value = "/json/{text}", produces = {MediaType.APPLICATION_JSON_VALUE})
    String getJsonString(@PathVariable String text) throws JSONException {
        return StringUtility.jsonToFormat(text, "json");
    }

    @GetMapping(value = "/xml/{text}", produces = {MediaType.APPLICATION_XML_VALUE})
    String getXmlString(@PathVariable String text) throws JSONException {
        return StringUtility.jsonToFormat(text, "xml");
    }

    @GetMapping(value = "/csv/{text}")
    String getCsvString(@PathVariable String text) throws JSONException {
        return StringUtility.jsonToFormat(text, "csv");
    }

}

package com.example.ppkwuzadanie3.controller;

import com.example.ppkwuzadanie3.StringUtility;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StringUtilityController {

    @GetMapping("/")
    String getStringUtility(@RequestParam String text, @RequestParam String format) {
        return StringUtility.jsonToFormat(text, format);
    }

}

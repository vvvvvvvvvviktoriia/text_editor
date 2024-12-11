package com.example.text_editor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @GetMapping("/")
    public String index() {
        return "Welcome to the Text Editor API! Available endpoints: " +
                "/file, /editor, /syntax, /navigation";
    }
}

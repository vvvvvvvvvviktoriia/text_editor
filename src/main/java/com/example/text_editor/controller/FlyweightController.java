package com.example.text_editor.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.text_editor.service.FlyweightService;

@RestController
@RequestMapping("/flyweight")
public class FlyweightController {

    private final FlyweightService flyweightService;

    @Autowired
    public FlyweightController(FlyweightService flyweightService) {
        this.flyweightService = flyweightService;
    }

    @PostMapping("/display")
    public ResponseEntity<String> displayText(
            @RequestParam(required = false) String text,
            @RequestParam(required = false) String fontName,
            @RequestParam(required = false) Integer fontSize) {
        if (text == null || text.isEmpty()) {
            return ResponseEntity.badRequest().body("Error: 'text' parameter is missing or empty.");
        }
        if (fontName == null || fontName.isEmpty()) {
            return ResponseEntity.badRequest().body("Error: 'fontName' parameter is missing or empty.");
        }
        if (fontSize == null || fontSize <= 0) {
            return ResponseEntity.badRequest().body("Error: 'fontSize' parameter is missing or invalid.");
        }

        flyweightService.displayText(text, fontName, fontSize);
        return ResponseEntity.ok("Text displayed successfully!");
    }


    @GetMapping("/count")
    public String getFlyweightCount() {
        return "Number of flyweights created: " + flyweightService.getFlyweightCount();
    }
}


package com.example.text_editor.controller;

import com.example.text_editor.service.EditService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/edit")
public class EditController {

    private final EditService editService;

    public EditController(EditService editService) {
        this.editService = editService;
    }

    @PostMapping("/append")
    public String appendText(@RequestParam String currentContent, @RequestParam String newText) {
        return editService.appendText(currentContent, newText);
    }
}


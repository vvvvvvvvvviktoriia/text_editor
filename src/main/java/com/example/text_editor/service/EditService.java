package com.example.text_editor.service;

import org.springframework.stereotype.Service;

@Service
public class EditService {

    public String appendText(String currentContent, String newText) {
        return currentContent + "\n" + newText;
    }
}


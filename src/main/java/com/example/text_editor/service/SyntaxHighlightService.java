package com.example.text_editor.service;

import org.springframework.stereotype.Service;

@Service
public class SyntaxHighlightService {

    public String highlightSyntax(String content) {
        return content.replaceAll("public", "[PUBLIC]")
                .replaceAll("class", "[CLASS]");
    }
}


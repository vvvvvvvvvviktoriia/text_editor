package com.example.text_editor.strategy;

import org.springframework.stereotype.Component;

@Component
public class PlainTextHighlightStrategy implements SyntaxHighlightStrategy {

    @Override
    public String highlight(String text) {
        return text;
    }
}


package com.example.text_editor.strategy;

import org.springframework.stereotype.Service;

@Service
public class SyntaxHighlightContext {

    private SyntaxHighlightStrategy strategy;

    public void setStrategy(SyntaxHighlightStrategy strategy) {
        this.strategy = strategy;
    }

    public String highlight(String text) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy is not set");
        }
        return strategy.highlight(text);
    }
}


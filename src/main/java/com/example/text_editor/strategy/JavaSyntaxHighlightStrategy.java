package com.example.text_editor.strategy;

import org.springframework.stereotype.Component;

@Component
public class JavaSyntaxHighlightStrategy implements SyntaxHighlightStrategy {

    @Override
    public String highlight(String text) {
        return text.replaceAll("\\b(public|class|void|static)\\b", "[HIGHLIGHT]$1[/HIGHLIGHT]");
    }
}


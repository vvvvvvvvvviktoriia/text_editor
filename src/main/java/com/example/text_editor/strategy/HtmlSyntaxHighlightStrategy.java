package com.example.text_editor.strategy;

import org.springframework.stereotype.Component;

@Component
public class HtmlSyntaxHighlightStrategy implements SyntaxHighlightStrategy {

    @Override
    public String highlight(String text) {
        return text.replaceAll("<(\\w+)>", "[TAG]<$1>[/TAG]");
    }
}


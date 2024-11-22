package com.example.text_editor.controller;

import com.example.text_editor.strategy.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/syntax")
public class SyntaxHighlightController {

    private final SyntaxHighlightContext context;
    private final JavaSyntaxHighlightStrategy javaStrategy;
    private final HtmlSyntaxHighlightStrategy htmlStrategy;
    private final PlainTextHighlightStrategy plainStrategy;

    public SyntaxHighlightController(SyntaxHighlightContext context,
                                     JavaSyntaxHighlightStrategy javaStrategy,
                                     HtmlSyntaxHighlightStrategy htmlStrategy,
                                     PlainTextHighlightStrategy plainStrategy) {
        this.context = context;
        this.javaStrategy = javaStrategy;
        this.htmlStrategy = htmlStrategy;
        this.plainStrategy = plainStrategy;
    }

    @PostMapping("/highlight")
    public String highlight(@RequestParam String text, @RequestParam String type) {
        switch (type.toLowerCase()) {
            case "java":
                context.setStrategy(javaStrategy);
                break;
            case "html":
                context.setStrategy(htmlStrategy);
                break;
            default:
                context.setStrategy(plainStrategy);
        }
        return context.highlight(text);
    }
}


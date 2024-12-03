package com.example.text_editor.observer;

import org.springframework.stereotype.Service;

@Service
public class SyntaxHighlighter implements Observer {
    @Override
    public void update(String state) {
        System.out.println("Підсвічування синтаксису оновлено для тексту: " + state);
    }
}


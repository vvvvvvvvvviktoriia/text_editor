package com.example.text_editor.service;

import com.example.text_editor.flyweight.FontFlyweight;
import com.example.text_editor.flyweight.FontFlyweightFactory;
import org.springframework.stereotype.Service;

@Service
public class FlyweightService {
    public void displayText(String text, String fontName, int fontSize) {
        FontFlyweight font = FontFlyweightFactory.getFont(fontName, fontSize);
        for (char character : text.toCharArray()) {
            System.out.println("Character: " + character + ", Font: " + font.getFontName() + ", Size: " + font.getFontSize());
        }
    }

    public int getFlyweightCount() {
        return FontFlyweightFactory.getFlyweightCount();
    }
}


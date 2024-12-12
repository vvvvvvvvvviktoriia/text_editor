package com.example.text_editor.flyweight;

public class FontFlyweight {
    private final String fontName;
    private final int fontSize;

    public FontFlyweight(String fontName, int fontSize) {
        this.fontName = fontName;
        this.fontSize = fontSize;
    }

    public String getFontName() {
        return fontName;
    }

    public int getFontSize() {
        return fontSize;
    }
}


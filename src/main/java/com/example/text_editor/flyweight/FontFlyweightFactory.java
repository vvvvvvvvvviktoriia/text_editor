package com.example.text_editor.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FontFlyweightFactory {
    private static final Map<String, FontFlyweight> flyweights = new HashMap<>();

    public static FontFlyweight getFont(String fontName, int fontSize) {
        String key = fontName + fontSize;
        if (!flyweights.containsKey(key)) {
            flyweights.put(key, new FontFlyweight(fontName, fontSize));
        }
        return flyweights.get(key);
    }

    public static int getFlyweightCount() {
        return flyweights.size();
    }
}



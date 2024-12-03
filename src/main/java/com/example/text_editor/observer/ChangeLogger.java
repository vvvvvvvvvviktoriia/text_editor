package com.example.text_editor.observer;

import org.springframework.stereotype.Service;

@Service
public class ChangeLogger implements Observer {
    @Override
    public void update(String state) {
        System.out.println("Журнал змін оновлено. Поточний текст: " + state);
    }
}


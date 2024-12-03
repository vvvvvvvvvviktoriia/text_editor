package com.example.text_editor.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FileSubject {
    private static final Logger logger = LoggerFactory.getLogger(FileSubject.class);

    private final List<Observer> observers = new ArrayList<>();
    private String content;

    public void attach(Observer observer) {
        observers.add(observer);
        logger.info("Attached observer: {}", observer.getClass().getSimpleName());
    }

    public void detach(Observer observer) {
        observers.remove(observer);
        logger.info("Detached observer: {}", observer.getClass().getSimpleName());
    }

    public void setContent(String content) {
        this.content = content;
        logger.info("Content updated: {}", content);
        notifyObservers();
    }

    private void notifyObservers() {
        logger.info("Notifying {} observers...", observers.size());
        for (Observer observer : observers) {
            observer.update(content);
        }
    }
}

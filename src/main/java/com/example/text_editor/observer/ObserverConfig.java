package com.example.text_editor.observer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObserverConfig {

    @Bean
    public CommandLineRunner registerObservers(FileSubject fileSubject,
                                               SyntaxHighlighter syntaxHighlighter,
                                               ChangeLogger changeLogger) {
        return args -> {
            fileSubject.attach(syntaxHighlighter);
            fileSubject.attach(changeLogger);
        };
    }
}


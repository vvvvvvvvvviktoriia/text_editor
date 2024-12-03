package com.example.text_editor.service;

import com.example.text_editor.observer.FileSubject;
import org.springframework.stereotype.Service;

@Service
public class EditService {
    private final FileSubject fileSubject;

    public EditService(FileSubject fileSubject) {
        this.fileSubject = fileSubject;
    }

    public String insertText(String currentContent, String newText) {
        String updatedContent = currentContent + "\n" + newText;
        fileSubject.setContent(updatedContent);
        return updatedContent;
    }
}


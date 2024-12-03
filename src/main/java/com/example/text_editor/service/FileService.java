package com.example.text_editor.service;

import com.example.text_editor.observer.FileSubject;
import com.example.text_editor.model.TextFile;
import com.example.text_editor.repository.TextFileRepository;
import org.springframework.stereotype.Service;

@Service
public class FileService {
    private final TextFileRepository textFileRepository;
    private final FileSubject fileSubject;

    public FileService(TextFileRepository textFileRepository, FileSubject fileSubject) {
        this.textFileRepository = textFileRepository;
        this.fileSubject = fileSubject;
    }

    public TextFile openFile(String fileName) {
        TextFile file = textFileRepository.findByName(fileName);
        if (file == null) {
            file = new TextFile(fileName, "Empty content");
            textFileRepository.save(file);
        }
        fileSubject.setContent(file.getContent());
        return file;
    }

    public TextFile saveFile(String fileName, String content) {
        TextFile file = textFileRepository.findByName(fileName);
        if (file == null) {
            file = new TextFile(fileName, content);
        } else {
            file.setContent(content);
        }
        TextFile savedFile = textFileRepository.save(file);
        fileSubject.setContent(content);
        return savedFile;
    }

    public TextFile editFile(String fileName, String newContent) {
        TextFile file = textFileRepository.findByName(fileName);
        if (file != null) {
            file.setContent(newContent);
            textFileRepository.save(file);
            fileSubject.setContent(newContent);
            return file;
        }
        throw new RuntimeException("File not found");
    }
}

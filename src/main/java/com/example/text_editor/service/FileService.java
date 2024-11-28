package com.example.text_editor.service;

import com.example.text_editor.model.TextFile;
import com.example.text_editor.repository.TextFileRepository;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    private final TextFileRepository textFileRepository;

    public FileService(TextFileRepository textFileRepository) {
        this.textFileRepository = textFileRepository;
    }

    public TextFile openFile(String fileName) {
        TextFile file = textFileRepository.findByName(fileName);
        if (file != null) {
            return file;
        }
        TextFile newFile = new TextFile(fileName, "Empty content");
        return textFileRepository.save(newFile);
    }

    public TextFile editFile(String fileName, String newContent) {
        TextFile file = textFileRepository.findByName(fileName);
        if (file != null) {
            file.setContent(newContent);
            return textFileRepository.save(file);
        }
        throw new RuntimeException("File not found");
    }

    public TextFile saveFile(String fileName, String content) {
        TextFile file = textFileRepository.findByName(fileName);
        if (file == null) {
            file = new TextFile(fileName, content);
        } else {
            file.setContent(content);
        }
        return textFileRepository.save(file);
    }
}




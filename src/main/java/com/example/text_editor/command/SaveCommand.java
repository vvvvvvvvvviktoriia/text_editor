package com.example.text_editor.command;

import com.example.text_editor.service.FileService;

public class SaveCommand implements Command {
    private final FileService fileService;
    private final String fileName;
    private final String content;

    public SaveCommand(FileService fileService, String fileName, String content) {
        this.fileService = fileService;
        this.fileName = fileName;
        this.content = content;
    }

    @Override
    public void execute() {
        fileService.saveFile(fileName, content);
    }
}

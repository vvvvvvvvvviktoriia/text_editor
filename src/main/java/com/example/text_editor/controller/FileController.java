package com.example.text_editor.controller;

import com.example.text_editor.command.CommandInvoker;
import com.example.text_editor.command.SaveCommand;
import com.example.text_editor.model.TextFile;
import com.example.text_editor.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/file")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    private final FileService fileService;
    private final CommandInvoker commandInvoker;

    public FileController(FileService fileService, CommandInvoker commandInvoker) {
        this.fileService = fileService;
        this.commandInvoker = commandInvoker;
    }

    @GetMapping("/open")
    public TextFile openFile(@RequestParam String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            logger.error("File name is missing.");
            throw new IllegalArgumentException("File name cannot be empty.");
        }

        TextFile file = fileService.openFile(fileName);
        logger.info("File '{}' opened successfully.", fileName);
        return file;
    }

    @PostMapping("/save")
    public String saveFile(@RequestParam String fileName, @RequestParam String content) {
        if (fileName == null || fileName.isEmpty()) {
            logger.error("File name is missing.");
            throw new IllegalArgumentException("File name cannot be empty.");
        }
        if (content == null) {
            logger.error("File content is missing.");
            throw new IllegalArgumentException("File content cannot be null.");
        }

        SaveCommand saveCommand = new SaveCommand(fileService, fileName, content);
        commandInvoker.executeCommand(saveCommand);
        logger.info("File '{}' saved successfully.", fileName);
        return "File saved successfully.";
    }

    @PutMapping("/edit")
    public String editFile(@RequestParam String fileName, @RequestParam String newContent) {
        if (fileName == null || fileName.isEmpty()) {
            logger.error("File name is missing.");
            throw new IllegalArgumentException("File name cannot be empty.");
        }
        if (newContent == null) {
            logger.error("New content is missing.");
            throw new IllegalArgumentException("New content cannot be null.");
        }

        TextFile file = fileService.editFile(fileName, newContent);
        logger.info("File '{}' edited successfully. New content: {}", fileName, newContent);
        return "File edited successfully: " + file.getName();
    }
}

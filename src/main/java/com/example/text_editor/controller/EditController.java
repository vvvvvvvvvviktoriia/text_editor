package com.example.text_editor.controller;

import com.example.text_editor.command.*;
import com.example.text_editor.service.EditService;
import com.example.text_editor.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/editor")
public class EditController {

    private static final Logger logger = LoggerFactory.getLogger(EditController.class);

    private final CommandInvoker commandInvoker;
    private final FileService fileService;
    private final EditService editService;

    public EditController(CommandInvoker commandInvoker, FileService fileService, EditService editService) {
        this.commandInvoker = commandInvoker;
        this.fileService = fileService;
        this.editService = editService;
    }

    @PostMapping("/save")
    public String saveFile(@RequestParam String fileName, @RequestParam String content) {
        if (fileName == null || fileName.isEmpty()) {
            logger.error("File name is missing.");
            return "Error: File name is required.";
        }
        if (content == null) {
            logger.error("Content is missing.");
            return "Error: Content is required.";
        }

        try {
            Command saveCommand = new SaveCommand(fileService, fileName, content);
            commandInvoker.executeCommand(saveCommand);
            logger.info("File '{}' saved successfully.", fileName);
            return "File saved successfully.";
        } catch (Exception e) {
            logger.error("Error while saving file '{}': {}", fileName, e.getMessage());
            return "Error: Could not save file.";
        }
    }

    @PostMapping("/insert")
    public String insertText(@RequestParam String currentContent, @RequestParam String newText) {
        if (currentContent == null) {
            logger.error("Current content is missing.");
            return "Error: Current content is required.";
        }
        if (newText == null || newText.isEmpty()) {
            logger.error("New text is missing.");
            return "Error: New text is required.";
        }

        try {
            Command insertCommand = new InsertTextCommand(editService, currentContent, newText);
            commandInvoker.executeCommand(insertCommand);
            logger.info("Text inserted successfully.");
            return "Text inserted successfully.";
        } catch (Exception e) {
            logger.error("Error while inserting text: {}", e.getMessage());
            return "Error: Could not insert text.";
        }
    }
}

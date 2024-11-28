package com.example.text_editor.controller;

import com.example.text_editor.command.*;
import com.example.text_editor.service.EditService;
import com.example.text_editor.service.FileService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/editor")
public class EditController {

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
        Command saveCommand = new SaveCommand(fileService, fileName, content);
        commandInvoker.executeCommand(saveCommand);
        return "File saved.";
    }

    @PostMapping("/insert")
    public String insertText(@RequestParam String currentContent, @RequestParam String newText) {
        Command insertCommand = new InsertTextCommand(editService, currentContent, newText);
        commandInvoker.executeCommand(insertCommand);
        return "Text inserted.";
    }
}



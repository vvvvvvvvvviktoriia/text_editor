package com.example.text_editor.controller;

import com.example.text_editor.command.CommandInvoker;
import com.example.text_editor.command.SaveCommand;
import com.example.text_editor.model.TextFile;
import com.example.text_editor.service.FileService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/file")
public class FileController {

    private final FileService fileService;
    private final CommandInvoker commandInvoker;

    public FileController(FileService fileService, CommandInvoker commandInvoker) {
        this.fileService = fileService;
        this.commandInvoker = commandInvoker;
    }

    @GetMapping("/open")
    public TextFile openFile(@RequestParam String fileName) {
        return fileService.openFile(fileName);
    }

    @PostMapping("/save")
    public String saveFile(@RequestParam String fileName, @RequestParam String content) {
        SaveCommand saveCommand = new SaveCommand(fileService, fileName, content);
        commandInvoker.executeCommand(saveCommand);
        return "File saved successfully.";
    }

    @PutMapping("/edit")
    public String editFile(@RequestParam String fileName, @RequestParam String newContent) {
        TextFile file = fileService.editFile(fileName, newContent);
        return "File edited successfully: " + file.getName();
    }
}


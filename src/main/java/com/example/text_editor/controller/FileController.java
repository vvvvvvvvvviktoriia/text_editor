package com.example.text_editor.controller;

import com.example.text_editor.model.TextFile;
import com.example.text_editor.service.FileService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/file")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/open")
    public TextFile openFile(@RequestParam String fileName) {
        return fileService.openFile(fileName);
    }

    @PostMapping("/edit")
    public TextFile editFile(@RequestParam String fileName, @RequestParam String newContent) {
        return fileService.editFile(fileName, newContent);
    }
}

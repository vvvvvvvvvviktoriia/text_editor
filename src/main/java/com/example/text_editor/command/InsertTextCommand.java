package com.example.text_editor.command;

import com.example.text_editor.service.EditService;

public class InsertTextCommand implements Command {
    private final EditService editService;
    private final String currentContent;
    private final String newText;

    public InsertTextCommand(EditService editService, String currentContent, String newText) {
        this.editService = editService;
        this.currentContent = currentContent;
        this.newText = newText;
    }

    @Override
    public void execute() {
        editService.insertText(currentContent, newText);
    }
}

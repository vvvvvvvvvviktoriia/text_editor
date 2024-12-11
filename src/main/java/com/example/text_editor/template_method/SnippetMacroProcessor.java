package com.example.text_editor.template_method;
public class SnippetMacroProcessor extends MacroProcessor {

    @Override
    protected boolean isValidMacro(String macroText) {
        return macroText.startsWith("snippet:");
    }

    @Override
    protected String extractCommand(String macroText) {
        return macroText.replace("snippet:", "");
    }

    @Override
    protected void executeCommand(String command) {
        System.out.println("Inserting snippet: " + getSnippet(command));
    }

    private String getSnippet(String key) {
        return switch (key) {
            case "hello" -> "Hello, world!";
            case "date" -> "Today's date: 2024-12-11";
            default -> "[Snippet not found]";
        };
    }
}


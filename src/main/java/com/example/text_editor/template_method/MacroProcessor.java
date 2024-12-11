package com.example.text_editor.template_method;

public abstract class MacroProcessor {

    public final void processMacro(String macroText) {
        if (isValidMacro(macroText)) {
            String command = extractCommand(macroText);
            executeCommand(command);
            saveResults();
        } else {
            System.out.println("Invalid macro: " + macroText);
        }
    }

    protected abstract boolean isValidMacro(String macroText);

    protected abstract String extractCommand(String macroText);

    protected abstract void executeCommand(String command);

    protected void saveResults() {
        System.out.println("Saving results after executing macro...");
    }
}


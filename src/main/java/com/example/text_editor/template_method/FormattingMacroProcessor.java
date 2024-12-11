package com.example.text_editor.template_method;
public class FormattingMacroProcessor extends MacroProcessor {

    @Override
    protected boolean isValidMacro(String macroText) {
        return macroText.startsWith("format:");
    }

    @Override
    protected String extractCommand(String macroText) {
        return macroText.replace("format:", "");
    }

    @Override
    protected void executeCommand(String command) {
        System.out.println("Executing formatting command: " + command);
    }
}


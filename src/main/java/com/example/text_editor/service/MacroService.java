package com.example.text_editor.service;

import com.example.text_editor.template_method.FormattingMacroProcessor;
import com.example.text_editor.template_method.MacroProcessor;
import com.example.text_editor.template_method.SnippetMacroProcessor;
import org.springframework.stereotype.Service;

@Service
public class MacroService {

    public void processFormattingMacro(String macroText) {
        MacroProcessor processor = new FormattingMacroProcessor();
        processor.processMacro(macroText);
    }

    public void processSnippetMacro(String macroText) {
        MacroProcessor processor = new SnippetMacroProcessor();
        processor.processMacro(macroText);
    }
}


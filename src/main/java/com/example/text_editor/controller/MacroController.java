package com.example.text_editor.controller;

import com.example.text_editor.service.MacroService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/macros")
public class MacroController {

    private final MacroService macroService;

    public MacroController(MacroService macroService) {
        this.macroService = macroService;
    }

    @PostMapping("/process/formatting")
    public void processFormattingMacro(@RequestBody Map<String, String> request) {
        String macroText = request.get("macroType");
        if (macroText != null) {
            macroService.processFormattingMacro(macroText);
        } else {
            System.out.println("Invalid request: macroType is missing");
        }
    }

    @PostMapping("/process/snippet")
    public void processSnippetMacro(@RequestBody Map<String, String> request) {
        String macroText = request.get("macroType");
        if (macroText != null) {
            macroService.processSnippetMacro(macroText);
        } else {
            System.out.println("Invalid request: macroType is missing");
        }
    }
}



package com.example.text_editor.controller;

import com.example.text_editor.model.Bookmark;
import com.example.text_editor.service.NavigationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/navigation")
public class NavigationController {

    private final NavigationService navigationService;

    public NavigationController(NavigationService navigationService) {
        this.navigationService = navigationService;
    }

    @PostMapping("/bookmark")
    public Bookmark addBookmark(@RequestParam String fileName, @RequestParam int line, @RequestParam String note) {
        return navigationService.addBookmark(fileName, line, note);
    }

    @GetMapping("/bookmarks")
    public List<Bookmark> getBookmarks(@RequestParam String fileName) {
        return navigationService.getBookmarks(fileName);
    }
}

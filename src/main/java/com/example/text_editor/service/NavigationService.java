package com.example.text_editor.service;

import com.example.text_editor.model.Bookmark;
import com.example.text_editor.repository.BookmarkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NavigationService {

    private final BookmarkRepository bookmarkRepository;

    public NavigationService(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    public Bookmark addBookmark(String fileName, int line, String note) {
        return bookmarkRepository.save(new Bookmark(fileName, line, note));
    }

    public List<Bookmark> getBookmarks(String fileName) {
        return bookmarkRepository.findByFileName(fileName);
    }
}

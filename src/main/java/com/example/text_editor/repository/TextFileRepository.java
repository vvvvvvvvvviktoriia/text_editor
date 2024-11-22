package com.example.text_editor.repository;

import com.example.text_editor.model.TextFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextFileRepository extends JpaRepository<TextFile, Long> {
    TextFile findByName(String name);
}



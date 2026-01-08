package com.dhruv.digitalbookshelf.controller;


import com.dhruv.digitalbookshelf.model.Book;
import com.dhruv.digitalbookshelf.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    // Post Method ( Add a new Book )
    @PostMapping
    public ResponseEntity<Book> add(@Valid @RequestBody Book book) {
        Book saved = service.add(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // Get All Books ( Get Method )
    @GetMapping
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }


    // Put  ( Update a Book )
    @PutMapping("/{id}")
    public ResponseEntity<Book> update (
            @PathVariable Long id,
            @Valid @RequestBody Book book) {
        Book updated = service.update(id, book);
        return ResponseEntity.ok(updated);
    }

    // Delete ( Remove a book )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
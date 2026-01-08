package com.dhruv.digitalbookshelf.service;

import com.dhruv.digitalbookshelf.exception.ResourceNotFoundException;
import com.dhruv.digitalbookshelf.model.Book;
import com.dhruv.digitalbookshelf.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public Book add(Book book) {
        return repo.save(book);
    }

    public List<Book> getAll() {
        return repo.findAll();
    }

    public Book update (Long id, Book updated) {
        return repo.findById(id)
                .map(b -> {
                    b.setTitle(updated.getTitle());
                    b.setAuthor(updated.getAuthor());
                    return b;
                })
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Book not found with id " + id));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }



}
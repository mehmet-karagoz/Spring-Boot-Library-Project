package com.mehmetkaragoz.libraryProject.controller;

import java.util.List;

import com.mehmetkaragoz.libraryProject.model.Book;
import com.mehmetkaragoz.libraryProject.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/books")
public class BookController {
    

    private final BookRepository bookRepo;

    @Autowired
    public BookController(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @GetMapping(path = "{isbn}")
    public Book getBookByIsbn(@PathVariable("isbn") long isbn) {
        return bookRepo.findById(isbn).get();
    }

    @PostMapping
    public void addNewBook(@RequestBody Book book) {
        bookRepo.save(book);
    }

    @DeleteMapping(path = "{isbn}")
    public void deleteBookByIsbn(@PathVariable("isbn") long isbn) {
        bookRepo.deleteById(isbn);
    }

    @PutMapping(path = "{isbn}")
    public void updateBookTitleByIsbn(
        @PathVariable("isbn") long isbn,@RequestBody String title) {
        bookRepo.updateBookTitleById(isbn, title);
    }
}

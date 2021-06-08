package com.mehmetkaragoz.libraryProject.controller;

import java.util.List;

import com.mehmetkaragoz.libraryProject.model.Book;
import com.mehmetkaragoz.libraryProject.service.BookService;

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
    

   private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping(path = "{isbn}")
    public Book getBookByIsbn(@PathVariable("isbn") long isbn) {
        return bookService.getById(isbn);
    }

    @PostMapping
    public void addNewBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @DeleteMapping(path = "{isbn}")
    public void deleteBookByIsbn(@PathVariable("isbn") long isbn) {
        bookService.deleteBookById(isbn);
    }

    @PutMapping(path = "{isbn}")
    public void updateBookTitleByIsbn(
        @PathVariable("isbn") long isbn,@RequestBody String title) {
            bookService.updateBookTitleById(isbn, title);
    }
}

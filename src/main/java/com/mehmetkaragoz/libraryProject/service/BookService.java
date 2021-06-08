package com.mehmetkaragoz.libraryProject.service;

import java.util.List;

import com.mehmetkaragoz.libraryProject.model.Book;

public interface BookService {
    
    void addBook(Book book);
    Book getById(Long isbn);
    List<Book> getAllBooks();
    void updateBookTitleById(Long isbn, String title);
    void deleteBookById(Long isbn);
}

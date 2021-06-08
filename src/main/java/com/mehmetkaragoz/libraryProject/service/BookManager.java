package com.mehmetkaragoz.libraryProject.service;

import java.util.List;

import com.mehmetkaragoz.libraryProject.model.Book;
import com.mehmetkaragoz.libraryProject.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookManager implements BookService{
    
    @Autowired
    private BookRepository bookRepository;

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
        
    }

    @Override
    public List<Book> getAllBooks() {
       return (List<Book>) bookRepository.findAll();
    }

    @Override
    public void updateBookTitleById(Long isbn, String title) {
        bookRepository.updateBookTitleById(isbn, title);
    }

    @Override
    public void deleteBookById(Long isbn) {
        bookRepository.deleteById(isbn);
        
    }

    @Override
    public Book getById(Long isbn) {
        return bookRepository.findById(isbn).orElse(null);
    }

    
}

package com.mehmetkaragoz.libraryProject.repository;

import java.util.List;
import java.util.Optional;

import com.mehmetkaragoz.libraryProject.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JPABookRepository implements BookRepository{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public <S extends Book> S save(S entity) {
        return bookRepository.save(entity);
    }

    @Override
    public <S extends Book> Iterable<S> saveAll(Iterable<S> entities) {
       return bookRepository.saveAll(entities);
    }

    @Override
    public Optional<Book> findById(Long id) {
       return bookRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
       return bookRepository.existsById(id);
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Iterable<Book> findAllById(Iterable<Long> ids) {
       return bookRepository.findAllById(ids);
    }

    @Override
    public long count() {
       return bookRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);;
        
    }

    @Override
    public void delete(Book entity) {
        bookRepository.delete(entity);
        
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        bookRepository.deleteAllById(ids);
        
    }

    @Override
    public void deleteAll(Iterable<? extends Book> entities) {
        bookRepository.deleteAll(entities);
        
    }

    @Override
    public void deleteAll() {
        bookRepository.deleteAll();
    }

    @Override
    public List<Book> findBookByTitle(String title) {
        return bookRepository.findBookByTitle(title);
    }

    @Override
    public void updateBookTitleById(long isbn, String title) {
        bookRepository.updateBookTitleById(isbn, title);       
    }
    
}
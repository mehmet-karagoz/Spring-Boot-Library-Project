package com.mehmetkaragoz.libraryProject.repository;

import com.mehmetkaragoz.libraryProject.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>{
    
}

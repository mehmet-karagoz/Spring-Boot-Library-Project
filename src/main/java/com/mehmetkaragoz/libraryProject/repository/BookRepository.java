package com.mehmetkaragoz.libraryProject.repository;

import java.util.List;

//import java.util.Optional;
import com.mehmetkaragoz.libraryProject.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long>{

    //this is not working bc title is not unique
    // @Query("SELECT b FROM Book b WHERE b.title = ?1")
    // Optional<Book> findBookByTitle(String title);

    @Query("SELECT b FROM Book b WHERE b.title = ?1")
    List<Book> findBookByTitle(String title);
}

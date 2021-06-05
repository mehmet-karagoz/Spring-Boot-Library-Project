package com.mehmetkaragoz.libraryProject.repository;

import java.util.List;

import javax.transaction.Transactional;

//import java.util.Optional;
import com.mehmetkaragoz.libraryProject.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Long>{

    //this is not working bc title is not unique
    // @Query("SELECT b FROM Book b WHERE b.title = ?1")
    // Optional<Book> findBookByTitle(String title);

    @Query("SELECT b FROM Book b WHERE b.title = ?1")
    List<Book> findBookByTitle(String title);

    @Query(
        value = "UPDATE books SET title = :title WHERE isbn = :isbn", 
        nativeQuery = true)
    @Modifying
    @Transactional
    void updateBookTitleById(
        @Param("isbn") long isbn, @Param("title") String title);
}

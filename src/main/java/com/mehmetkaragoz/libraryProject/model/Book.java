package com.mehmetkaragoz.libraryProject.model;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @SequenceGenerator(
        name = "book_sequence",
        sequenceName = "book_sequence", 
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE, 
        generator = "book_sequence"
    )
    @Column(name = "isbn", updatable = false)
    private long isbn;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "price", nullable = false)
    private double price;
    
    public Book() {
    }

    public Book(long isbn, String title, String author, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public long getIsbn() {
        return isbn;
    }
    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book [author=" + author + ", isbn=" + isbn + ", price=" + price + ", title=" + title + "]";
    }
}

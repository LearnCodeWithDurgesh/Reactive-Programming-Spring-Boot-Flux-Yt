package com.reactive.app.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("book_details")
public class Book {

    @Id
    @Column("book_id")
    private  int bookId;

    private  String name;

    @Column("book_desc")
    private  String description;

    private  String publisher;

    private  String author;

//    ....


    public Book(int bookId, String name, String description, String publisher, String author) {
        this.bookId = bookId;
        this.name = name;
        this.description = description;
        this.publisher = publisher;
        this.author = author;
    }

    public Book() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

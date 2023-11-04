package com.reactive.app.controllers;

import com.reactive.app.entities.Book;
import com.reactive.app.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    //    create
    @PostMapping
    public Mono<Book> create(@RequestBody Book book) {
        return bookService.create(book);
    }

    //    get all books
    @GetMapping
    public Flux<Book> getAll() {
        return bookService.getAll();
    }

    //    get single book
    @GetMapping("/{bid}")
    public Mono<Book> get(@PathVariable("bid") int bookId) {
        return bookService.get(bookId);
    }

    //    update
    @PutMapping("/{bookId}")
    public Mono<Book> update(@RequestBody Book book, @PathVariable int bookId) {
        return bookService.update(book, bookId);
    }

    //    delete
    @DeleteMapping("/{bookId}")
    public Mono<Void> delete(@PathVariable int bookId) {
        return bookService.delete(bookId);
    }

//    search

    @GetMapping("/search")
    public Flux<Book> searchBooks(
            @RequestParam("query") String query
    ) {
        System.out.println(query);
        return this.bookService.searchBooks(query);
    }

}

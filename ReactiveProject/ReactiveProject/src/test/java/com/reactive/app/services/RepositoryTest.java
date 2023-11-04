package com.reactive.app.services;

import com.reactive.app.entities.Book;
import com.reactive.app.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void findMethodTest() {

//
//        Mono<Book> nameMono = bookRepository.findByName("Angular front end");
//        StepVerifier.create(nameMono)
//                .expectNextCount(1)
//                .verifyComplete();

//        Flux<Book> authorFlux = bookRepository.findByAuthor("ravi rampal");
//        StepVerifier.create(authorFlux)
//                .expectNextCount(2)
//                .verifyComplete();

        bookRepository.findByNameAndAuthor("Angular front end", "Surender")
                .as(StepVerifier::create)
                .expectNextCount(1)
                .verifyComplete();


    }


    @Test
    public void queryMethodsTest() {
//
//        bookRepository.getAllBooksByAuthor("Basic Python Book","Python rocker")
//                .as(StepVerifier::create)
//                .expectNextCount(1)
//                .verifyComplete();

        bookRepository.searchBookByTitle("%front%")
                .as(StepVerifier::create)
                .expectNextCount(1)
                .verifyComplete();

    }



}

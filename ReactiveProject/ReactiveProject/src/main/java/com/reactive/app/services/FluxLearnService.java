package com.reactive.app.services;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

@Service
public class FluxLearnService {

//  all operators example goes here
    /*Creating flux*/

    public Flux<String> getFlux() {
        return Flux.just("Ankit", "Durgesh", "Ravi", "Gautam");
    }

    public Flux<String> fruitsFlux() {
        List<String> fruitsNames = List.of("Mongo", "Apple");
        return Flux.fromIterable(fruitsNames);
    }

    public Flux<Void> getBlankFlux() {
        return Flux.empty();
    }

// map

    public Flux<String> mapExampleFlux() {
        Flux<String> capFlux = getFlux().map(String::toUpperCase).log();
        return capFlux;
    }

    //    filter
    public Flux<String> filterExampleFlux() {
        return getFlux().filter(name -> name.length() > 4).log();
    }

//    flatmap

    public Flux<String> flatMapExample() {
//        return getFlux().flatMap(name -> Flux.just(name.split(""))).log();

        return getFlux().flatMap(name -> Flux.just(name.split(""))).delayElements(Duration.ofSeconds(2)).log();
    }

    ;

    //    transform example

    public Flux transformExample() {
        Function<Flux<String>, Flux<String>> funInterFace = (name) -> name.map(String::toUpperCase);
        return getFlux().transform(funInterFace).log();
    }

    //    defaultIfEmpty
//    switchIfEmpty
    public Flux<String> ifExample(int length) {
        return getFlux()
                .filter(name -> name.length() > length)
//                .defaultIfEmpty("Learn Code With Durgesh")
                .switchIfEmpty(fruitsFlux())
                .log();
    }

    //    concat(static) / concatWith(instance)
    public Flux<String> concatExample() {
        return Flux.concat(getFlux().delayElements(Duration.ofSeconds(1)), fruitsFlux().delayElements(Duration.ofSeconds(2)));

//        return getFlux().concatWith(fruitsFlux());
    }

    //    merge and mergeWith
    public Flux<String> mergeWithExample() {
        return Flux.merge(getFlux().delayElements(Duration.ofSeconds(1)), fruitsFlux().delayElements(Duration.ofSeconds(2)));
    }

    //    zip and zipWithExample
    public Flux<String> zipExample() {
//        return Flux.zip(getFlux(), Flux.just(123, 2, 24));

        return Flux.zip(getFlux(), Flux.just(123, 2, 24, 200), (first, second) -> {
            return first + ": " + second;
        });

    }

    public Flux<String> sideEffectFlux() {
        return getFlux().doOnNext(data -> {
                    System.out.println(data + " on Next");
                }).doOnSubscribe(data -> {
                    System.out.println(data + " on subscribe");
                })
                .doOnEach(data -> {
                    System.out.println(data + " each");
                })
                .doOnComplete(() -> {
                    System.out.println("completed");
                });
    }

}

package com.reactive.app;

import com.reactive.app.services.FluxLearnService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class FluxLearnTest {
    @Autowired
    private FluxLearnService fluxLearnService;

    @Test
    public void simpleFluxTest() {

//        fluxLearnService.getFlux().subscribe(data -> {
//            System.out.println(data);
//            System.out.println("done with flux data");
//        });
        fluxLearnService.fruitsFlux().subscribe(System.out::println);
    }

    @Test
    public void mapTest() {


        Flux<String> capFlux = fluxLearnService.mapExampleFlux();
        StepVerifier.create(capFlux)
                .expectNext("Ankit".toUpperCase(), "Durgesh".toUpperCase(), "Ravi".toUpperCase(), "Gautam".toUpperCase())
                .verifyComplete();

    }



}

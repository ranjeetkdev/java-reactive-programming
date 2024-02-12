package com.rp.test;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Lec01SVDemoTest {



    @Test
    public void test() {
        Flux<Integer> just = Flux.just(1,2,3);

        StepVerifier.create(just)
                .expectNext(1)
                .expectNext(1)
                .expectNext(1)
                .verifyComplete();

    }
}

package com.rp.sec02;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec09FluxFromMono {
    public static void main(String[] args) {


        Mono<String> mono = Mono.just("a");
//        doSometing(mono); // you will get the error
        Flux<String> flux = Flux.from(mono);
        flux.subscribe(
                Util.onNext()
        );
    }

    private static void doSometing(Flux<String> flux) {

    }
}

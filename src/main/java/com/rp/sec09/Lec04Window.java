package com.rp.sec09;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;

public class Lec04Window {
    private  static  AtomicInteger atomicInteger = new AtomicInteger();
    public static void main(String[] args) {

        eventStream()
                .window(5)
                .flatMap(flux -> saveEvent(flux))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }
    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(500))
                .map(i -> "Event "+i);
    }

    private static Mono<Integer> saveEvent(Flux<String> flux){
        return flux.doOnNext(e -> System.out.println("saving "+e))
                .doOnComplete(() -> {
                    System.out.println("Saved batch");
                    System.out.println("-------");
                })
                .then(Mono.just(atomicInteger.incrementAndGet()));
    }
}

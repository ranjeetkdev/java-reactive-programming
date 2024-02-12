package com.rp.sec01;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscriber {
    public static void main(String[] args) {

        // publisher
        Mono<String> mono = Mono.just("ball");

        // without parameter subscriber
//        mono.subscribe();

        mono.subscribe(
                System.out::println,
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Completed")
        );
        // code for print error
        System.out.println("------Error testing -------");
        Mono<Integer> mono2 = Mono.just("ball")
                .map(String::length)
                .map(l -> l / 0);

        mono2.subscribe(
                System.out:: println,
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Completed")
        );

        // By using util class
        System.out.println("------ By using util class ------");
        Mono<Integer> mono3 = Mono.just("ball")
                .map(String::length)
                .map(l -> l / 1);

        mono3.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}

package com.rp.sec01;

import reactor.core.publisher.Mono;

public class Lec02Mono {
    public static void main(String[] args) {
        Mono<Integer> data = Mono.just(1);

//        System.out.println(data);
        data.subscribe(i -> System.out.println(" Recieved : " + i));
    }
}

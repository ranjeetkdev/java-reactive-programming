package com.rp.sec04;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec06OnError {
    public static void main(String[] args) {

        Flux.range(1, 10)
                .log()
                .map(i -> 10 / (5-i))
//                .onErrorReturn(-1)
//                .onErrorResume(throwable -> fallBack())
                .onErrorContinue((throwable, o) -> {
                    System.out.println("Error at value : "+ o);
                })
                .subscribe(Util.subscriber());



    }
    public static Mono<Integer> fallBack(){
        return Mono.fromSupplier(() -> Util.faker().random().nextInt(100, 200));
    }
}

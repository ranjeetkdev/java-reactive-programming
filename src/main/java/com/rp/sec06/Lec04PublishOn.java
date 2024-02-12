package com.rp.sec06;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec04PublishOn {

    public static void main(String[] args) {

        Flux<Object> flux = Flux.create(fluxSink -> {
            printThreadName("Create");
            for (int i = 0; i < 4; i++) {
                fluxSink.next(i);
            }
            fluxSink.complete();
        }).doOnNext(i -> printThreadName("Next " + i));

        flux.publishOn(Schedulers.boundedElastic())
                .doFirst(() -> printThreadName("First 1"))
                .subscribe(v -> printThreadName("Sub 1 "+v));

        Util.sleepSeconds(5);

    }

    private static void printThreadName(String msg){
        System.out.println(msg +" : "+Thread.currentThread().getName());
    }
}

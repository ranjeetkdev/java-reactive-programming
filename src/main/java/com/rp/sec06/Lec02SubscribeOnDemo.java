package com.rp.sec06;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec02SubscribeOnDemo {
    public static void main(String[] args) {

        Flux<Object> flux = Flux.create(fluxSink -> {
            printThreadName("Create");
            fluxSink.next(1);
        }).doOnNext(i -> printThreadName("next " + i));

        Runnable runnable = () -> flux
                                    .doFirst(() -> printThreadName("doFirst 2"))
                                    .subscribeOn(Schedulers.boundedElastic())
                                    .doFirst(() -> printThreadName("doFirst 1 "))
                                    .subscribe(v -> printThreadName("sub "+v));
        for (int i = 0; i < 2; i++) {
            new Thread(runnable).start();

        }
        Util.sleepSeconds(5);
    }

    private static void printThreadName(String msg){
        System.out.println(msg +" : "+Thread.currentThread().getName());

    }
}

package com.rp.sec06;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec03MultiSubscribeOn {

    public static void main(String[] args) {

//        Flux<Object> flux = Flux.create(fluxSink -> {
//            printThreadName("Create");
//            fluxSink.next(1);
//        }).subscribeOn(Schedulers.newParallel("vins"))
//                .doOnNext(i -> printThreadName("next " + i));

        Flux<Object> flux = Flux.create(fluxSink -> {
            printThreadName("Create");
                    for (int i = 0; i < 20; i++) {
                        fluxSink.next(i);

                    }
                    fluxSink.complete();
        })
                .doOnNext(i -> printThreadName("next " + i));

//        Runnable runnable = () -> flux.doFirst(() -> printThreadName("First 2"))
//                .subscribeOn(Schedulers.boundedElastic())
//                .doFirst(()-> printThreadName("First 1"))
//                .subscribe(v -> printThreadName("sub 1 "+v));

        flux
//                .subscribeOn(Schedulers.boundedElastic())
                .subscribeOn(Schedulers.parallel())
                .subscribe(v -> printThreadName("sub 1" +
                        " "+v));

//        for (int i = 0; i < 2; i++) {
//            new Thread(runnable).start();

//        }
        Util.sleepSeconds(5);
    }

    private static void printThreadName(String msg){
        System.out.println(msg +" : "+Thread.currentThread().getName());
    }
}

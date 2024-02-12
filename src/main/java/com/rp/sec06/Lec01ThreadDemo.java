package com.rp.sec06;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec01ThreadDemo {
    public static void main(String[] args) {


        Flux<Object> flux = Flux.create(fluxSink -> {
            printThredName("Create");
            fluxSink.next(1);
        }).doOnNext(i -> printThredName("Next "+i));

        Runnable runnable = () -> flux.subscribe(v-> printThredName("sub "+v));
        for (int i = 0; i < 2; i++) {
            new Thread(runnable).start();

        }
        Util.sleepSeconds(5);
    }

    private static void printThredName(String msg){
        System.out.println(msg +"  "+ Thread.currentThread().getName());
    }
}

package com.rp.sec11;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Lec03SinkThreadSafe {

    public static void main(String[] args) {
        Sinks.Many<Object> sink = Sinks.many().unicast().onBackpressureBuffer();

        Flux<Object> flux = sink.asFlux();

        List<Object> list = new ArrayList<>();
        flux.subscribe(list::add);

        for (int i = 0; i < 1000; i++) {
            final int j =i;
            CompletableFuture.runAsync(() -> {
                sink.tryEmitNext(j);
            });

//        for (int i = 0; i < 1000; i++) {
//            final int j =i;
//            CompletableFuture.runAsync(() -> {
//                sink.tryEmitNext(j);
//            });

            
        }

        Util.sleepSeconds(3);
        System.out.println(list.size());;

    }
}

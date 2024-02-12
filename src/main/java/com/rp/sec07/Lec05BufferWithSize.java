package com.rp.sec07;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class Lec05BufferWithSize {
    public static void main(String[] args) {
        System.setProperty("reactor.bufferSize.small", "16");
        List<Object> list = new ArrayList<>();
        Flux.create(fluxSink -> {
                    for (int i = 1; i < 201 && !fluxSink.isCancelled(); i++) {
                        fluxSink.next(i);
                        System.out.println("Pushed "+i);
                        Util.sleepMillis(1);
                    }
                    fluxSink.complete();
                })
                .onBackpressureBuffer(50, o -> System.out.println(" Dropped "+ o))
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> {
                    Util.sleepMillis(10);
                }).subscribe(Util.subscriber());

        Util.sleepSeconds(10);
        System.out.println(list);
    }
}

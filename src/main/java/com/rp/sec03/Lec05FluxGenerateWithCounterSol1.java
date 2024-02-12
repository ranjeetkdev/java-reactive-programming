package com.rp.sec03;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class Lec05FluxGenerateWithCounterSol1 {


    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Flux.generate(synchronousSink -> {
            String country = Util.faker().country().name();
            System.out.println("Emitting "+country);
            synchronousSink.next(country);
            atomicInteger.incrementAndGet();
            if(country.equalsIgnoreCase("canada") || atomicInteger.get() <= 10) {
                synchronousSink.complete();
            }
        })
        .subscribe(Util.subscriber());
    }
}

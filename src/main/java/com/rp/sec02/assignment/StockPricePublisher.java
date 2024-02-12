package com.rp.sec02.assignment;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class StockPricePublisher {


    public static Flux<Integer> getPrice() {
        AtomicInteger atomicInteger = new AtomicInteger(100);
        return Flux.interval(Duration.ofSeconds(1))
                .map(i -> atomicInteger.accumulateAndGet(
                        Util.faker().random().nextInt(-5, 5),
                        Integer:: sum
                ));
    }
}

package com.rp.sec04;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec07Timeout {
    public static void main(String[] args) {

        getOrderNumber()
                .timeout(Duration.ofSeconds(2), fallBack())
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

    public static Flux<Integer> getOrderNumber() {
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(5));
    }
    public static Flux<Integer> fallBack(){
        return Flux.range(100, 10)
                .delayElements(Duration.ofMillis(200));
    }
}

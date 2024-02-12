package com.rp.sec11;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.time.Duration;

public class Lec05SinkMultiDirectAll {

    public static void main(String[] args) {
        Sinks.Many<Object> sink = Sinks.many().multicast().directAllOrNothing();

        Flux<Object> flux = sink.asFlux();

        flux.subscribe(Util.subscriber("Ranjeet"));
        flux.delayElements(Duration.ofMillis(200)).subscribe(Util.subscriber("Supriya"));


        for (int i = 0; i < 100; i++) {
            sink.tryEmitNext(i);

        }

        Util.sleepSeconds(10);


    }
}

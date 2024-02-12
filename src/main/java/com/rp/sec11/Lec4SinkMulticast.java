package com.rp.sec11;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Lec4SinkMulticast {

    public static void main(String[] args) {
        Sinks.Many<Object> sink = Sinks.many().multicast().onBackpressureBuffer();

        Flux<Object> flux = sink.asFlux();

        flux.subscribe(Util.subscriber("Ranjeet"));
        flux.subscribe(Util.subscriber("Supriya"));


        sink.tryEmitNext("Hello");
        sink.tryEmitNext("How are you");
        sink.tryEmitNext("?");


    }
}

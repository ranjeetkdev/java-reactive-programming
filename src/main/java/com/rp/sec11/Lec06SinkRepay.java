package com.rp.sec11;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.time.Duration;

public class Lec06SinkRepay {

    public static void main(String[] args) {
        Sinks.Many<Object> sink = Sinks.many().replay().all();

        Flux<Object> flux = sink.asFlux();

        flux.subscribe(Util.subscriber("Ranjeet"));



        sink.tryEmitNext("Hello");
        sink.tryEmitNext("How are you");
        flux.subscribe(Util.subscriber("Supriya"));
        sink.tryEmitNext("?");


    }
}

package com.rp.sec11;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class Lec01SinkOne {
    public static void main(String[] args) {

        //mono 1 value /empty / error
        Sinks.One<Object> sink = Sinks.one();
        Mono<Object> mono = sink.asMono();

        mono.subscribe(Util.subscriber("Ranjeet"));
        mono.subscribe(Util.subscriber("Supriya"));

        sink.tryEmitValue("Hello");
//        sink.tryEmitError(new RuntimeException("error"));

//        sink.emitValue("Hello", (signalType, emitResult) -> {
//            System.out.println(signalType.name());
//            System.out.println(emitResult.name());
//            return false;
//        });

//        sink.emitValue("Hello", (signalType, emitResult) -> {
//            System.out.println(signalType.name());
//            System.out.println(emitResult.name());
//            return true;
//        });
    }

}

package com.rp.sec04;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec03DoCallBack {

    public static void main(String[] args) {


        Flux.create(fluxSink -> {
            System.out.println("Inside create");
            for (int i = 0; i <5; i++) {
                fluxSink.next(i);
            }
            System.out.println("Completed ");
        })
                .doOnComplete(() -> System.out.println("doOnComplete"))
                .doFirst(() -> System.out.println("doFirst 1"))
                .doOnNext(o -> System.out.println("doOnNext : "+o))
                .doOnSubscribe(subscription -> System.out.println("doOnSubscribe 1 "+subscription))
                .doFirst(() -> System.out.println("doFirst 2"))
                .doOnRequest(value -> System.out.println("doOnRequest : "+value))
                .doOnError(throwable -> System.out.println("doOnError : "+throwable.getMessage()))
                .doOnTerminate(() -> System.out.println("doOnTerminate"))
                .doOnCancel(() -> System.out.println("doOnCancel"))
                .doOnSubscribe(subscription -> System.out.println("doOnSubscribe 2 "+subscription))
                .doFirst(() -> System.out.println(" doFirst 3"))
                .doFinally(signalType -> System.out.println("doFinally : "+signalType))
                .doOnDiscard(Object.class, o-> System.out.println("doOnDiscard :"+o))

                .subscribe(Util.subscriber());
    }
}

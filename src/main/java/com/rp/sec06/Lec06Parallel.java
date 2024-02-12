package com.rp.sec06;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec06Parallel {
    public static void main(String[] args) {


        Flux.range(1,10)
                .parallel()
                .runOn(Schedulers.boundedElastic())
                .subscribe(v -> printThreadName("Sub 1 "+v));

        Util.sleepSeconds(5);

    }

    private static void printThreadName(String msg){
        System.out.println(msg +" : "+Thread.currentThread().getName());
    }
}

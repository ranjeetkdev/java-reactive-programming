package com.rp.sec01;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class Lec06SupplierRefactoring {
    public static void main(String[] args) {
        getName();
        getName()
                // asynchronous
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(Util.onNext());
        String name = getName().subscribeOn(Schedulers.boundedElastic())
                        .block();
        System.out.println(name);
        getName();
        Util.sleepSeconds(4);
    }
    private static Mono<String> getName() {
        System.out.println("Entered in getName Method");
        return Mono.fromSupplier(() -> {
            System.out.println("Generating Name ...");
            Util.sleepSeconds(3);
            return Util.faker().name().fullName();
        });
    }
}


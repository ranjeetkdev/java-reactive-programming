package com.rp.sec10;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec02Retry {

    public static void main(String[] args) {


        getIntegers()
                .retry(2)
                .subscribe(Util.subscriber());
    }

    private static Flux<Integer> getIntegers() {
        return Flux.range(1,3)
                .doOnSubscribe(s -> System.out.println("Subscribed"))
                .doOnComplete(() -> System.out.println("--Completed--"))
                .map(i -> i/ (Util.faker().random().nextInt(1,5) > 3 ? 0 : 1))
                .doOnError(err -> System.out.println("--error"));
    }
}

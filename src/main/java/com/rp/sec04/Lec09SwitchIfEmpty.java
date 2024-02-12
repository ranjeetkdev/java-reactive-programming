package com.rp.sec04;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec09SwitchIfEmpty {

    public static void main(String[] args) {


        getOrder()
                .filter(i -> i >10)
                .switchIfEmpty(fallBack())
                .subscribe(Util.subscriber());
    }

    // from cache
    public static Flux<Integer> getOrder() {
        return Flux.range(1, 10);
    }

    // from db
    public static Flux<Integer> fallBack() {
        return Flux.range(20, 5);
    }
}

package com.rp.sec04;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec08DefaultIfEmpty {

    public static void main(String[] args) {


        getOrderNumber()
                .filter(i -> i >10)
                .defaultIfEmpty(-1)
                .subscribe(Util.subscriber());
    }

    public static Flux<Integer> getOrderNumber() {
        return Flux.range(1,12);
    }
}

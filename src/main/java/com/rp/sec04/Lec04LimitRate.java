package com.rp.sec04;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec04LimitRate {
    public static void main(String[] args) {

        Flux.range(1, 10000)
                .log()
//                .limitRate(100)
                .limitRate(100, 0) // request after all consumed
                .subscribe(Util.subscriber());
    }
}

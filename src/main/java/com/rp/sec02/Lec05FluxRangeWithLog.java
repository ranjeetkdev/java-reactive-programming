package com.rp.sec02;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxRangeWithLog {
    public static void main(String[] args) {

        Flux.range(3, 10)
                .log()
                .map(i -> Util.faker().name().fullName())
                .log()
                .subscribe(
                        Util.onNext()
                );
    }
}

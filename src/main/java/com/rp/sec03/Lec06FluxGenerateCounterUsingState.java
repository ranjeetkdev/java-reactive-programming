package com.rp.sec03;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec06FluxGenerateCounterUsingState {
    public static void main(String[] args) {

        Flux.generate(
                () -> 1,
                (counter, synchronousSink) -> {
                    String country = Util.faker().country().name();
                    synchronousSink.next(country);
                    if(country.equalsIgnoreCase("canada") || counter >=10) {
                        synchronousSink.complete();
                    }
                    return  counter +1;
                }
        ).take(4)
                .subscribe(Util.subscriber());
    }
}

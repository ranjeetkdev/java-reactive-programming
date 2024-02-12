package com.rp.sec03;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxCreate {
    public static void main(String[] args) {

        Flux.create(fluxSink -> {
//            fluxSink.next(1);
//            fluxSink.next(2);
//            fluxSink.complete();
//                    for (int i = 0; i < 10; i++) {
//                        fluxSink.next(Util.faker().country().name());
//                    }
                    String country;
            do{
                country = Util.faker().country().name();
                fluxSink.next(country);
            }while (!country.equalsIgnoreCase("canada"));
                    fluxSink.complete();
        })
                .subscribe(Util.subscriber());
    }
}

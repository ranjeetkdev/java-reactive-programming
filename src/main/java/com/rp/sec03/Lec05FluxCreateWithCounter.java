package com.rp.sec03;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxCreateWithCounter {

    public static void main(String[] args) {


        Flux.create(fluxSink -> {
            int counter = 0;
            String country;
            do {
                country = Util.faker().country().name();
                System.out.println("emitting " + country);
                fluxSink.next(country);
                counter++;
            } while (!country.equalsIgnoreCase("canada") && !fluxSink.isCancelled() && counter <=10);
        })
                .take(2)
         .subscribe(Util.subscriber());
    }
}

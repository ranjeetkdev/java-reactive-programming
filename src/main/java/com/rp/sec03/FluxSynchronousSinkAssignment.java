package com.rp.sec03;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Flux;

public class FluxSynchronousSinkAssignment {
    public static void main(String[] args) {

        Flux.generate(synchronousSink -> {
            String countryName = Util.faker().country().name();
            System.out.println("emitting "+countryName);
            synchronousSink.next(countryName);
            if(countryName.equalsIgnoreCase("canada")){
                synchronousSink.complete();
            }
        })
        .subscribe(Util.subscriber());
    }
}

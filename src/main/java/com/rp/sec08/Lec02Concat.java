package com.rp.sec08;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec02Concat {
    public static void main(String[] args) {

        Flux<String> flux1 = Flux.just("a", "b");
        Flux<String> flux2 = Flux.error(new RuntimeException("Opps"));
        Flux<String> flux3 = Flux.just("c", "d", "e");

        Flux<String> flux = flux1.concatWith(flux3);
        flux.subscribe(Util.subscriber());

        Flux<String> fluxConcateAt = Flux.concat(flux1, flux2, flux3);
        fluxConcateAt.subscribe(Util.subscriber());

        Flux<String> fluxConcateDelayError = Flux.concatDelayError(flux1,flux2,flux3);
        fluxConcateDelayError.subscribe(Util.subscriber());
    }
}

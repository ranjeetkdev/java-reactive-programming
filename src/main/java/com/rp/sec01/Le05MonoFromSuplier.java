package com.rp.sec01;

import com.rp.courseUtil.Util;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

public class Le05MonoFromSuplier {

    public static void main(String[] args) {
        // without subscribe 
        System.out.println("---- without subscribe -----");
        Mono<String> mono = Mono.just(getName());

        System.out.println("---- with subscribe using supplier ");
        Mono<String> mono2 = Mono.fromSupplier(() -> getName());
                mono2.subscribe(
                        Util.onNext()
                );
    }

    private static String getName() {
        System.out.println("Generating name");
        return Util.faker().name().firstName();
    }
}

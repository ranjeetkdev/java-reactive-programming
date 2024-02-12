package com.rp.sec01;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Mono;

public class Lec05MonoFromCollable {

    public static void main(String[] args) {
       Mono.fromCallable(() -> getName())
                .subscribe(
                        Util.onNext()
                );
    }

    private static String getName(){
        System.out.println("generating name");
        return Util.faker().name().fullName();
    }
}

package com.rp.sec01;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyOrError {

    public static void main(String[] args) {
            userRepository(1)
                    .subscribe(
                            Util.onNext(),
                            Util.onError(),
                            Util.onComplete()
                    );
    }

    private static Mono<String> userRepository(int userId) {
        if(userId == 1) {
            return Mono.just(Util.faker().name().fullName());
        }else if( userId == 2) {
            return Mono.empty();
        }else {
            return Mono.error(new RuntimeException(" It's not in range "));
        }
    }
}

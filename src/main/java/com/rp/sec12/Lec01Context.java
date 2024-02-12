package com.rp.sec12;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

public class Lec01Context {

    public static void main(String[] args) {

        getWelcomeMessage()
                .contextWrite(Context.of("users", "jack"))
                .contextWrite(Context.of("user", "Ranjeet"))
                .subscribe(Util.subscriber());
    }

    private static Mono<String> getWelcomeMessage(){
        return Mono.deferContextual(ctx -> {
            if(ctx.hasKey("user")){
                return Mono.just("Welcome "+ctx.get("user"));
            }else {
                return Mono.error(new RuntimeException("unauthenticated"));
            }
        });
    }
}

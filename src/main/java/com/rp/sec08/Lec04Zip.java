package com.rp.sec08;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec04Zip {

    public static void main(String[] args) {

        Flux.zip(getTires(), getBody(), getEngine())
                .subscribe(Util.subscriber());
    }

    private static Flux<String> getTires(){
        return Flux.range(1,5)
                .map(i -> "Engine");
    }
    private static Flux<String> getBody(){
        return Flux.range(1,5)
                .map(i -> "Engine");
    }
    private static Flux<String> getEngine(){
        return Flux.range(1,2)
                .map(i -> "Engine");
    }

}

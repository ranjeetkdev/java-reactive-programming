package com.rp.sec04;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec01Handle {

    public static void main(String[] args) {

        Flux.range(1,10)
                .handle((integer, synchronousSink) -> {
                    if(integer == 7){
                        synchronousSink.complete();
                    }else {
                        synchronousSink.next(integer +1 );
                    }
                }).subscribe(Util.subscriber());
    }
}

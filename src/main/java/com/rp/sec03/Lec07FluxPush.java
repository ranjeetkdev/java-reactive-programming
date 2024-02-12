package com.rp.sec03;

import com.rp.courseUtil.Util;
import com.rp.sec03.helper.NameProducer;
import reactor.core.publisher.Flux;

public class Lec07FluxPush {
    public static void main(String[] args) {

        NameProducer nameProducer = new NameProducer();

        Flux.push(nameProducer).subscribe(Util.subscriber());

        Runnable runnable = nameProducer ::producer;

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}

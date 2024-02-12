package com.rp.sec01;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Mono;

public class Lec07MonoFromRunnable {
    public static void main(String[] args) {
        Mono.fromRunnable(timeConsummingProcess())
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        () -> System.out.println("Process is done, Sending mail")
                );
    }
    private static Runnable timeConsummingProcess() {
        return () -> {
            Util.sleepSeconds(3);
            System.out.println("Task completed ");
        };
    }
}

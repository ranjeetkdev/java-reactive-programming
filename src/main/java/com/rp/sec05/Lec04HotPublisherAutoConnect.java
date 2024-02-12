package com.rp.sec05;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec04HotPublisherAutoConnect {
    public static void main(String[] args) {

        Flux<String> fluxMovie = Flux.fromStream(getMovie())
                .delayElements(Duration.ofSeconds(1))
                .publish()
                .autoConnect(0);

        Util.sleepSeconds(3);
        fluxMovie.subscribe(Util.subscriber("Ranjeet"));
        Util.sleepSeconds(10);
        fluxMovie.subscribe(Util.subscriber("Supriya"));

        Util.sleepSeconds(60);
    }
    public static Stream<String> getMovie(){
        System.out.println("Got request for Movie");
        return Stream.of(
                "Scene 1",
                "Scene 2",
                "Scene 3",
                "Scene 4",
                "Scene 5",
                "Scene 6",
                "Scene 7"
        );
    }
}

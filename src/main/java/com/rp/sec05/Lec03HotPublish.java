package com.rp.sec05;

import com.rp.courseUtil.Util;
import lombok.Data;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec03HotPublish {
    public static void main(String[] args) {

        Flux<String> movieView = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(2))
                .publish()
                        .refCount(2);

        movieView.subscribe(Util.subscriber("Ranjeet"));
        Util.sleepSeconds(5);
        movieView.subscribe(Util.subscriber("Supriya"));
        Util.sleepSeconds(60);
    }

    public static Stream<String> getMovie(){
        System.out.println("Got movie request");
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

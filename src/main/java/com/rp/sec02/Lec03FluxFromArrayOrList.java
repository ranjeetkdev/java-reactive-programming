package com.rp.sec02;

import com.rp.courseUtil.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class Lec03FluxFromArrayOrList {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("a", "b", "c", "d");

        Flux.fromIterable(list)
                .subscribe(Util.onNext());

        Integer[] intArray = {1,2,3,4};
        Flux.fromArray(intArray)
                .subscribe(Util.onNext());
    }
}

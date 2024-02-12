package com.rp.sec09;

import com.rp.courseUtil.Util;
import com.rp.sec09.Assignment.OrderProcessor;
import com.rp.sec09.Assignment.OrderService;
import com.rp.sec09.Assignment.PurchaseOrder;
import reactor.core.publisher.Flux;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class Lec06Assignment {
    public static void main(String[] args) {

        Map<String , Function<Flux<PurchaseOrder>, Flux<PurchaseOrder>>> map = Map.of(
                "Kids", OrderProcessor.kidsProcessing(),
                "Automotive", OrderProcessor.automotiveProcessing()
        );

        Set<String> set = map.keySet();
        OrderService.orderStream()
                .filter(p -> set.contains(p.getCatagory()))
                .groupBy(PurchaseOrder::getCatagory)
                .flatMap(gf -> map.get(gf.key()).apply(gf))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }
}

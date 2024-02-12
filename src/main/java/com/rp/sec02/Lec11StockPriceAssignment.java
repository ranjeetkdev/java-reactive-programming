package com.rp.sec02;

import com.github.javafaker.DateAndTime;
import com.rp.sec02.assignment.StockPricePublisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class Lec11StockPriceAssignment {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);
        StockPricePublisher.getPrice()
                .subscribeWith(new Subscriber<Integer>() {
                    private Subscription subscription ;
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        this.subscription = subscription;
                        subscription.request(Long.MAX_VALUE);

                    }

                    @Override
                    public void onNext(Integer price) {
                        System.out.println(LocalDateTime.now()+" price : "+price);
                        if(price > 110 || price < 90) {
                            this.subscription.cancel();
                            latch.countDown();
                        }
                    }

                    @Override
                    public void onError(Throwable throwable) {
                            latch.countDown();
                    }

                    @Override
                    public void onComplete() {
                            latch.countDown();
                    }
                });
        latch.await();
    }
}

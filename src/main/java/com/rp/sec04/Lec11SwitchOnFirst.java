package com.rp.sec04;

import com.rp.courseUtil.Util;
import com.rp.sec04.handle.Person;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class Lec11SwitchOnFirst {

    public static void main(String[] args) {

        getPerson()
//                .transform(filterMap())
                .switchOnFirst((signal, personFlux) -> {
                    System.out.println("Inside switch-On-first");
                    return signal.isOnNext() &&  signal.get().getAge() > 10 ? personFlux: filterMap().apply(personFlux);
                })
                .subscribe(Util.subscriber());

    }

    public static Flux<Person> getPerson() {
        return Flux.range(1,10)
                .map(i -> new Person());
    }

    public static Function<Flux<Person>, Flux<Person>> filterMap() {
        return flux -> flux
                .filter(person -> person.getAge() > 10)
                .doOnNext(person -> person.setName(person.getName().toUpperCase()))
                .doOnDiscard(Person.class, p -> System.out.println("Not allowed "+ p));
    }
}

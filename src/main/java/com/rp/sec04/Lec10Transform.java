package com.rp.sec04;

import com.rp.courseUtil.Util;
import com.rp.sec04.handle.Person;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class Lec10Transform {
    public static void main(String[] args) {

        getPerson()
                .transform(filterMap())
                .subscribe(Util.subscriber());


    }
    public static Flux<Person> getPerson() {
        return Flux.range(1,10)
                .map(i -> new Person());
    }
    public static Function<Flux<Person>, Flux<Person>> filterMap() {
        return personFlux ->
            personFlux.filter(p-> p.getAge() > 10)
                    .doOnNext(person -> person.setName(person.getName().toUpperCase()))
                    .doOnDiscard(Person.class, p -> System.out.println("Not allowed : "+p));


    }
}

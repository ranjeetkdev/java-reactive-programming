package com.rp.sec08;

import com.rp.courseUtil.Util;
import com.rp.sec08.helper.NameGenerator;

public class Lec01StartWith {
    public static void main(String[] args) {


        NameGenerator nameGenerator = new NameGenerator();
        nameGenerator.nameGenerator()
                .take(2)
                .subscribe(Util.subscriber("Ranjeet"));
        nameGenerator.nameGenerator()
                .take(2)
                .subscribe(Util.subscriber("Supriya"));
        nameGenerator.nameGenerator()
                .filter(n -> n.startsWith("A"))
                .take(2)
                .subscribe(Util.subscriber("Amarjeet"));
    }
}

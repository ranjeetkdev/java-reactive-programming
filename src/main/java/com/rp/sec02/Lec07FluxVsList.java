package com.rp.sec02;

import com.rp.courseUtil.Util;
import com.rp.sec02.helper.NameGenerator;

import java.util.List;

public class Lec07FluxVsList {
    public static void main(String[] args) {

//        List<String> names = NameGenerator.getName(5);
//
//        System.out.println(names);

        NameGenerator.getName(5)
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
    }
}

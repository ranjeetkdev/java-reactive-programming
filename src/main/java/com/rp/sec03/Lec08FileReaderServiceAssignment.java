package com.rp.sec03;

import com.rp.courseUtil.Util;
import com.rp.sec03.assignment.FileReaderService;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Lec08FileReaderServiceAssignment {
    public static void main(String[] args) {

        FileReaderService fileReaderService = new FileReaderService();

        Path path = Paths.get("src/main/resources/assignment.sec03/file01.txt");
        fileReaderService.read(path)
                .map(i -> {
                    int number = Util.faker().random().nextInt(0,10);
                    if(number > 8 ){
                        throw new RuntimeException("-- Opps--");
                    }
                    return i;
                })
                .subscribe(Util.subscriber());
    }
}

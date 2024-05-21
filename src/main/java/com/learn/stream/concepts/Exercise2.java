package com.learn.stream.concepts;

import java.io.IOException;

public class Exercise2 {

    public static void main(String[] args) throws IOException, InterruptedException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        // TODO: Write code here
        ReactiveSources.intNumbersFlux().subscribe(e -> System.out.println(e));

        // Print all users in the ReactiveSources.userFlux stream
        // TODO: Write code here
        ReactiveSources.userFlux().subscribe(e -> System.out.println(e));

        Thread.sleep(15000);
    }

}

package com.learn.stream.concepts;

import java.io.IOException;
import java.util.Optional;

public class Exercise4 {

    public static void main(String[] args) throws InterruptedException {

        // Flux - returns 0 or n items
        // Mono - returns 0 or 1 item

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        // TODO: Write code here
        ReactiveSources.intNumberMono().subscribe(number -> System.out.println(number));

        // Get the value from the Mono into an integer variable
        // TODO: Write code here
        Integer integer = ReactiveSources.intNumberMono().block();
        System.out.println(integer);
    }

}

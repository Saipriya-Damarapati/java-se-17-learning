package com.learn.stream.concepts;

import java.io.IOException;
import java.util.List;

public class Exercise3 {

    public static void main(String[] args) throws InterruptedException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        List<Integer> numbers = ReactiveSources.intNumbersFlux().toStream().toList();
        System.out.println("List is " + numbers);
        System.out.println("Size of the list is " + numbers.size());


        //Thread.sleep(15000); // this is not required, because it is blocking operation,
        // source communicates that it is done, and published all the elements
    }

}

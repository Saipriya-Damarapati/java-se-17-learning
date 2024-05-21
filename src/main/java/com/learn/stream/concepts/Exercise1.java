package com.learn.stream.concepts;

import java.util.Optional;
import java.util.stream.Collectors;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()
        System.out.println("\n-----------------------------------------------------------");

        // Print all numbers in the intNumbersStream stream
        System.out.println("Print all numbers in the intNumbersStream stream");
        StreamSources.intNumbersStream()
                .forEach(i -> System.out.print(i + ", "));
        System.out.println("\n-----------------------------------------------------------");

        // Print numbers from intNumbersStream that are less than 5
        System.out.println("Print numbers from intNumbersStream that are less than 5");
        StreamSources.intNumbersStream()
                .filter(integer -> integer < 5)
                .forEach(i -> System.out.print(i + ", "));
        System.out.println("\n-----------------------------------------------------------");

        // Print the second and third numbers in intNumbersStream that's greater than 5
        System.out.println("Print the second and third numbers in intNumbersStream that's greater than 5");
        StreamSources.intNumbersStream()
                .filter(i -> i > 5)
                .skip(1)
                .limit(2)
                .forEach(i -> System.out.print(i + ", "));
        System.out.println("\n-----------------------------------------------------------");

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        System.out.println("Print the first number in intNumbersStream that's greater than 5.");
        StreamSources.intNumbersStream()
                .filter(i -> i > 5)
                .findFirst()
                .ifPresentOrElse(i -> System.out.println(i), () -> System.out.println(-1));
        System.out.println("---OTHER WAY---");
        Integer value = StreamSources.intNumbersStream()
                .filter(i -> i > 5)
                .findFirst().orElse(-1);
        System.out.print(value);
        System.out.println("\n-----------------------------------------------------------");

        // Print first names of all users in userStream
        System.out.println("Print first names of all users in userStream");
        StreamSources.userStream()
                .forEach(user -> System.out.println(user.getFirstName()));
        System.out.println("---OTHER WAY---");
        StreamSources.userStream()
                .map(user -> user.getFirstName())
                .forEach(user -> System.out.println(user));
        System.out.println("\n-----------------------------------------------------------");

        // Print first names in userStream for users that have IDs from number stream
        System.out.println("Print first names in userStream for users that have IDs from number stream");
        StreamSources.userStream()
                .filter(user -> StreamSources.intNumbersStream().anyMatch(i -> i == user.getId()))
                .forEach(user -> System.out.println(user.getFirstName()));
        System.out.println("---OTHER WAY---");
        StreamSources.intNumbersStream()
                .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id).map(user -> user.getFirstName()))
                .forEach(System.out::println);;
        System.out.println("\n-----------------------------------------------------------");
    }
}

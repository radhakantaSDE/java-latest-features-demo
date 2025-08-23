package com.learn.app.concepts.collection.java8;

@FunctionalInterface
public interface Greetings {

    // A functional interface is an interface that contains exactly one abstract method.
    String sayHello(String name);
}

package com.learn.app.concepts.collection.java8;

public class LambdaExpressionExample {

  public void lambdaExpressionExample() {

    // Lambda expression of Runnable interface
    Greetings greetings = (a) -> "Hello, " + a + "!";

    String message = greetings.sayHello("World");
    System.out.println(message);
  }

  public static void main(String[] args) {
    LambdaExpressionExample example = new LambdaExpressionExample();
    example.lambdaExpressionExample();
  }
}

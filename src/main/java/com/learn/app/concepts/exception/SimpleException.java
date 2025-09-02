package com.learn.app.concepts.exception;

public class SimpleException {
  public int divideTwoNumber(int a, int b) {
    try {
      return a / b;
    } catch (ArithmeticException ex) {
      System.out.println("Arithmetic Ex");
      return 0;
    } finally {
      System.out.println("finally");
      return -1;
    }
  }
}

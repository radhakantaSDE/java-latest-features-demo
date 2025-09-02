package com.learn.app.concepts.inheritance.overriding;

public class OverloadingAmbiguousCall {

  public void test(Object a, String b) {
    System.out.println("Object, String");
  }

  public void test(Object a, Object b) {
    System.out.println("Object, Object");
  }

  public static void main(String[] args) {
    OverloadingAmbiguousCall obj = new OverloadingAmbiguousCall();
    obj.test(null, null);
  }
}

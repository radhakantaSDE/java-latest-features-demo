package com.learn.app.concepts.inheritance.overriding;

class MoParent {
  public void show() {
    System.out.println("Parent show");
  }

  protected void greet() {
    System.out.println("Greeting");
  }
}

class MoChild extends MoParent {
  //        public void show() {
  //            System.out.println("Child Show");
  //        }
}

public class MethodOverrideCall {
  public static void main(String[] args) {
    MoParent obj = new MoChild();
    obj.show();
    obj.greet();
  }
}

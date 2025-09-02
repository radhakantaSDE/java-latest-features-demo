package com.learn.app.concepts.inheritance.overriding;

class DaParent {
  public String name = "Hari";
}

public class DataMemberOverride extends DaParent {
  public String name = "Madhu";

  public static void main(String[] args) {
    DaParent pa = new DataMemberOverride();
    System.out.println(pa.name);
  }
}

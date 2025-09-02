package com.learn.app.patterns.creational;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * This pattern will be used if, the cost of creating a new object is expensive and resource
 * intensive. Concept :
 */
public class PrototypeDesignPattern {

  public static void main(String[] args) {

    Circle crl = new Circle(10.5f);
    crl.draw();

    IShape clonedCircle = crl.clone();
    clonedCircle.draw();

    System.out.println(clonedCircle);
  }
}

interface IShape {
  IShape clone();

  void draw();
}

@ToString
@AllArgsConstructor
@NoArgsConstructor
class Circle implements IShape {

  private float radius;

  @Override
  public IShape clone() {
    return new Circle(radius);
  }

  @Override
  public void draw() {
    System.out.println("Drawing circle");
  }
}

@ToString
@AllArgsConstructor
@NoArgsConstructor
class Square implements IShape {

  private float length;

  @Override
  public IShape clone() {
    return new Square(length);
  }

  @Override
  public void draw() {
    System.out.println("Drawing Square");
  }
}

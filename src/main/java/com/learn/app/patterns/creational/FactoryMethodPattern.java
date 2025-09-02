package com.learn.app.patterns.creational;

interface Shape {
  void draw();
}

class CircleShape implements Shape {
  @Override
  public void draw() {
    System.out.println("Drawing a Circle");
  }
}

class SquareShape implements Shape {
  @Override
  public void draw() {
    System.out.println("Drawing a Square");
  }
}

interface ShapeFactory {
  Shape createShape();
}

class CircleFactory implements ShapeFactory {
  @Override
  public Shape createShape() {
    return new CircleShape();
  }
}

class SquareFactory implements ShapeFactory {
  @Override
  public Shape createShape() {
    return new SquareShape();
  }
}

public class FactoryMethodPattern {
  public static void main(String[] args) {
    ShapeFactory circleFactory = new CircleFactory();
    Shape circle = circleFactory.createShape();
    circle.draw();

    ShapeFactory squareFactory = new SquareFactory();
    Shape square = squareFactory.createShape();
    square.draw();
  }
}

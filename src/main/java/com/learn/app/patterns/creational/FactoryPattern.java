package com.learn.app.patterns.creational;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class FactoryPattern {

  public static void main(String[] args) {

    ComputerFactory computerFactory = new ComputerFactory();
    Computer computer = computerFactory.createComputer("Desktop", "Arm", 32, 250);
    System.out.println(computer);
  }
}

class ComputerFactory {

  public Computer createComputer(String type, String cpu, int ram, int hdd) {

    if (Objects.equals(type, "Desktop")) {
      return new Desktop(cpu, ram, hdd);
    } else if (Objects.equals(type, "")) {
      return new Server(cpu, ram, hdd);
    } else {
      throw new RuntimeException("Invalid computer preparation");
    }
  }
}

interface Computer {
  String cpu();

  int ram();

  int hdd();
}

@ToString
@AllArgsConstructor
@NoArgsConstructor
class Desktop implements Computer {

  private String cpu;
  private int ram;
  private int hdd;

  @Override
  public String cpu() {
    return this.cpu;
  }

  @Override
  public int ram() {
    return this.ram;
  }

  @Override
  public int hdd() {
    return this.hdd;
  }
}

@ToString
@AllArgsConstructor
@NoArgsConstructor
class Server implements Computer {

  private String cpu;
  private int ram;
  private int hdd;

  @Override
  public String cpu() {
    return this.cpu;
  }

  @Override
  public int ram() {
    return this.ram;
  }

  @Override
  public int hdd() {
    return this.hdd;
  }
}

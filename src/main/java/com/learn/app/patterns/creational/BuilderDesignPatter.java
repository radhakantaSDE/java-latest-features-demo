package com.learn.app.patterns.creational;

// Product class
class PC {
  private String CPU;
  private String RAM;
  private String storage;

  private PC(Builder builder) {
    this.CPU = builder.CPU;
    this.RAM = builder.RAM;
    this.storage = builder.storage;
  }

  public String toString() {
    return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + storage + "]";
  }

  public static class Builder {
    private String CPU;
    private String RAM;
    private String storage;

    public Builder setCPU(String CPU) {
      this.CPU = CPU;
      return this;
    }

    public Builder setRAM(String RAM) {
      this.RAM = RAM;
      return this;
    }

    public Builder setStorage(String storage) {
      this.storage = storage;
      return this;
    }

    public PC build() {
      return new PC(this);
    }
  }
}

public class BuilderDesignPatter {

  public static void main(String[] args) {

    PC newPc = new PC.Builder().setCPU("Intel").setRAM("24GB").build();
    System.out.println(newPc);
  }
}

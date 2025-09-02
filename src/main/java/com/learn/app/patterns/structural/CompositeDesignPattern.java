package com.learn.app.patterns.structural;

import java.util.ArrayList;
import java.util.List;

interface FileSystemComponent {
  void showDetails();
}

// Leaf class
class File implements FileSystemComponent {
  private String name;

  public File(String name) {
    this.name = name;
  }

  @Override
  public void showDetails() {
    System.out.println("File: " + name);
  }
}

// Composite class
class Folder implements FileSystemComponent {
  private String name;
  private List<FileSystemComponent> components = new ArrayList<>();

  public Folder(String name) {
    this.name = name;
  }

  public void addComponent(FileSystemComponent component) {
    components.add(component);
  }

  public void removeComponent(FileSystemComponent component) {
    components.remove(component);
  }

  @Override
  public void showDetails() {
    System.out.println("Folder: " + name);
    for (FileSystemComponent component : components) {
      component.showDetails();
    }
  }
}

public class CompositeDesignPattern {
  public static void main(String[] args) {

    File file1 = new File("File1.txt");
    File file2 = new File("File2.txt");
    Folder folder1 = new Folder("Folder1");
    folder1.addComponent(file1);
    folder1.addComponent(file2);

    File file3 = new File("File3.txt");
    Folder folder2 = new Folder("Folder2");
    folder2.addComponent(file3);
    folder2.addComponent(folder1);

    folder2.showDetails();
  }
}

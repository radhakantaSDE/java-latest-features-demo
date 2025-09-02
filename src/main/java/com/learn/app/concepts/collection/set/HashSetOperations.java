package com.learn.app.concepts.collection.set;

public class HashSetOperations {

  // Sample method to demonstrate basic HashSet operations
  public void hashSetExample() {
    // Create a HashSet
    java.util.HashSet<String> hashSet = new java.util.HashSet<>();

    // Adding elements to the HashSet
    hashSet.add("Element 1");
    hashSet.add("Element 2");
    hashSet.add("Element 3");
    hashSet.add("Element 3");

    // Displaying the HashSet
    System.out.println("HashSet: " + hashSet);

    // Checking if an element exists in the HashSet
    boolean containsElement = hashSet.contains("Element 2");
    System.out.println("Contains 'Element 2': " + containsElement);

    // Removing an element from the HashSet
    hashSet.remove("Element 1");
    System.out.println("HashSet after removal: " + hashSet);
  }

  public static void main(String[] args) {
    HashSetOperations operations = new HashSetOperations();
    operations.hashSetExample();
  }
}

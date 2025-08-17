package com.learn.app.concepts.collection.arraylist;

public class LinkedListOperations {


    // Create a method to demonstrate LinkedList operations
    public void linkedListExample() {
        // Creating a LinkedList
        java.util.LinkedList<String> linkedList = new java.util.LinkedList<>();

        // Adding elements to the LinkedList
        linkedList.add("Element 1");
        linkedList.add("Element 2");
        linkedList.add("Element 3");

        // Displaying the LinkedList
        System.out.println("LinkedList: " + linkedList);

        // Removing an element from the LinkedList
        String removedElement = linkedList.remove(1); // Removes "Element 2"
        System.out.println("Removed Element: " + removedElement);

        // Displaying the LinkedList after removal
        System.out.println("LinkedList after removal: " + linkedList);
    }

    public static void main(String[] args) {
        LinkedListOperations operations = new LinkedListOperations();
        operations.linkedListExample(); // Call the method to demonstrate LinkedList operations
    }
}

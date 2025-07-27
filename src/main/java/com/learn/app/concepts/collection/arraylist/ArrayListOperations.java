package com.learn.app.concepts.collection.arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListOperations {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of("Amit", "Priya", "Rahul", "Sneha", "Vikram"));

        list.add("Rajesh");

        // If we remove an element that does not exist, it will not throw an error
        list.remove("NonExistentElement");


        // If we try to remove an element at an index that is out of bounds, it will throw an IndexOutOfBoundsException
        try {
            list.remove(10); // This will throw an exception
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught IndexOutOfBoundsException: " + e.getMessage());
        }

        // If we add an element at an existing index, it will shift the existing elements to the right
        list.add(2, "NewElement"); // Adds "NewElement" at index 2
        System.out.println("List after operations: " + list);


        modifyList(list);
        System.out.println("List after modifyList operation: " + list);

        reassignList(list);
        System.out.println("List after reassignList operation: " + list);
    }


    // If we want to modify the list in a way that it reflects in the original list,
    public static void modifyList(List<String> list) {

        list.add("NewItem -At different method");
    }

    // If we assign a new list to the parameter, it will not affect the original list
    public static void reassignList(List<String> list) {
        list = new ArrayList<>(List.of("New", "List", "Reassigned"));
    }
}

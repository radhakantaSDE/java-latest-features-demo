package com.learn.app.concepts.collection.map;

import com.learn.app.model.Employee;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapOperation {

    // Sample method to demonstrate basic HashMap operations
    public void hashMapExample() {
        // Create a HashMap
        java.util.HashMap<String, Integer> hashMap = new java.util.HashMap<>();

        // Adding key-value pairs to the HashMap
        hashMap.put("Key1", 1);
        hashMap.put("Key2", 2);
        hashMap.put("Key3", 3);
        hashMap.put("Key4", 4);
        hashMap.put("Key3", 5); // This will overwrite the previous value for Key3

        // Displaying the HashMap
        System.out.println("HashMap: " + hashMap);

        // Checking if a key exists in the HashMap
        boolean containsKey = hashMap.containsKey("Key2");
        System.out.println("Contains 'Key2': " + containsKey);

        // Removing a key-value pair from the HashMap
        hashMap.remove("Key1");
        System.out.println("HashMap after removal: " + hashMap);
    }

    public void sortHashMapByKey() {
        // Create a HashMap
        java.util.HashMap<String, Integer> hashMap = new java.util.HashMap<>();
        hashMap.put("Key3", 3);
        hashMap.put("Key1", 1);
        hashMap.put("Key4", 4);
        hashMap.put("Key2", 2);

        // Approach-1 : Sorting HashMap by keys using TreeMap
        java.util.TreeMap<String, Integer> sortedMap = new java.util.TreeMap<>(hashMap);

        // Displaying the sorted HashMap
        System.out.println("Sorted HashMap by keys: " + sortedMap);

        // Approach-2 : Sorting HashMap by keys using Streams
        Map<String, Integer> sortedByStreamMap = hashMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println("Sorted HashMap by keys using Streams: " + sortedByStreamMap);


        // Approach-3 : Sorting HashMap by keys using Streams with custom comparator
        Map<Employee, Integer> employeesMap = Map.of(
                new Employee(1, "Alice", 30, "Engineering", 60000, "F", "New York", 2015), 10,
                new Employee(2, "Bob", 25, "Marketing", 50000, "M", "Los Angeles", 2018), 2,
                new Employee(3, "Charlie", 35, "Engineering", 70000, "M", "Chicago", 2012), 3,
                new Employee(4, "Alice", 28, "Sales", 55000, "F", "Houston", 2019), 4
        );
        Map<Employee, Integer> sortedMapOfObj = employeesMap.entrySet().stream().sorted((e1, e2) -> e1.getKey().getName().compareTo(e2.getKey().getName()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println("Sorted HashMap by Employee Name: " + sortedMapOfObj);
    }

    public void sortHashMapByValue() {

        // Approach-1 : Sorting HashMap by values using Streams
        java.util.HashMap<String, Integer> hashMap = new java.util.HashMap<>();
        hashMap.put("Key3", 3);
        hashMap.put("Key1", 1);
        hashMap.put("Key4", 4);
        hashMap.put("Key2", 2);

        Map<String, Integer> sortedByValueMap = hashMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println("Sorted HashMap by values: " + sortedByValueMap);

        // Approach-2 : Sorting HashMap by values using a custom comparator
        Map<Integer, Employee> employeesMap = Map.of(
                1, new Employee(1, "Alice", 30, "Engineering", 60000, "F", "New York", 2015),
                2, new Employee(2, "Bob", 25, "Marketing", 50000, "M", "Los Angeles", 2018),
                3, new Employee(3, "Charlie", 35, "Engineering", 70000, "M", "Chicago", 2012),
                4, new Employee(4, "Alice", 28, "Sales", 55000, "F", "Houston", 2019)
        );
        Map<Integer, Employee> sortedMapOfObj = employeesMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((e1, e2) -> e1.getName().compareTo(e2.getName())))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println("Sorted HashMap by Employee Name: " + sortedMapOfObj);
    }



    public static void main(String[] args) {
        HashMapOperation operations = new HashMapOperation();
        operations.hashMapExample();

        operations.sortHashMapByKey();
        operations.sortHashMapByValue();
    }
}

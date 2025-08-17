package com.learn.app.concepts.collection.map;

import com.learn.app.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class LinkedHashMapSorting {

    // Sort a LinkedHashMap by keys using different approaches
    public void sortLinkedHashMapByKeys() {

        Map<Integer, Employee> employeesMap = Map.of(
                1, new Employee(1, "Alice", 30, "Engineering", 60000, "F", "New York", 2015),
                2, new Employee(2, "Bob", 25, "Marketing", 50000, "M", "Los Angeles", 2018),
                3, new Employee(3, "Charlie", 35, "Engineering", 70000, "M", "Chicago", 2012),
                4, new Employee(4, "Alice", 28, "Sales", 55000, "F", "Houston", 2019));

        // Approach-2 : Sorting LinkedHashMap by keys using a List
        List<Map.Entry<Integer, Employee>> listEmployeeEntries = new ArrayList<>(employeesMap.entrySet());
        listEmployeeEntries.sort((e1, e2) -> e1.getKey().compareTo(e2.getKey()));

        // Approach-3 : Sorting LinkedHashMap by keys using streams
        Map<Integer, Employee> sortedEmpS = employeesMap.entrySet().stream().sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        // Approach-4 : Sorting LinkedHashMap by keys using TreeMap
        Map<Integer, Employee> sortedEmpT = new TreeMap<>(employeesMap);
    }

    // Sort a LinkedHashMap by values using different approaches
    public void sortLinkedHashMapByValues() {
        Map<Integer, Employee> employeesMap = Map.of(
                1, new Employee(1, "Alice", 30, "Engineering", 60000, "F", "New York", 2015),
                2, new Employee(2, "Bob", 25, "Marketing", 50000, "M", "Los Angeles", 2018),
                3, new Employee(3, "Charlie", 35, "Engineering", 70000, "M", "Chicago", 2012),
                4, new Employee(4, "Alice", 28, "Sales", 55000, "F", "Houston", 2019));

        // Approach-1 : Sorting LinkedHashMap by values using streams
        Map<Integer, Employee> sortedByValueMap = employeesMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getName)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        // Approach-2 : Sorting LinkedHashMap by values using a List
        List<Map.Entry<Integer, Employee>> listEmployeeEntries = new ArrayList<>(employeesMap.entrySet());
        listEmployeeEntries.sort((e1, e2) -> e1.getValue().getName().compareTo(e2.getValue().getName()));
    }
}

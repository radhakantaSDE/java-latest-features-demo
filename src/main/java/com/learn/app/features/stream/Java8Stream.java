package com.learn.app.features.stream;

import com.learn.app.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Java8Stream {

    // Stream features analysis
    public static void streamPlay() {

        List<Employee> employees = getEmployeeList();

        // 1. Find only unique elements in the list
        List<String> fruits = List.of("Apple", "Apple", "Litchi", "Pomegranate", "Banana");
        String filFruits = fruits.stream().filter(e -> Collections.frequency(fruits, e) == 1).sorted().collect(Collectors.joining(","));
        System.out.println(filFruits);


        // 2. Collect distinct employee names
        String empNames = employees.stream().map(Employee::getName).distinct().sorted().collect(Collectors.joining(","));
        System.out.println(empNames);

        // 3. Group employee by gender
        Map<String, List<Employee>> employeesMap =  employees.stream().collect(Collectors.groupingBy(Employee::getGender));
        System.out.println("Group by Gender" + employeesMap);


        // Sorting objects
        List<Employee> sortedEmpList = employees.stream().sorted(
                Comparator.comparingDouble(Employee::getSalary)
                        .thenComparing(Employee::getName))
                .toList();
        System.out.println("Sorted list : " + sortedEmpList);
    }


    public static void main(String[] args) {

        streamPlay();
    }


    public static List<Employee> getEmployeeList() {

        return List.of(
                Employee.builder().name("Puja").age(20).salary(40000.0f).gender("F").build(),
                Employee.builder().name("Rajesh").age(30).salary(30000.0f).gender("M").build(),
                Employee.builder().name("Mojo").age(21).salary(40000).gender("M").build()
        );
    }
}

package com.learn.app.concepts.collection.arraylist;

import com.learn.app.model.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayListFilterOperation {

    public void filterEmployeeListByName(List<Employee> employees, String name) {
        // Using Java Streams to filter employees by name
        List<Employee> filteredEmployees = employees.stream()
                .filter(employee -> employee.getName().equalsIgnoreCase(name))
                .toList(); // Collecting the results into a new list

        // Printing the filtered list
        System.out.println("Filtered Employees: " + filteredEmployees);
    }

    public void filterEmployeeListAndSortById(List<Employee> employees, String name) {
        // Using Java Streams to filter employees by name and sort by id
        List<Employee> filteredAndSortedEmployees = employees.stream()
                .filter(e -> e.getName().startsWith("E"))
                .sorted(Comparator.comparing(Employee::getId))
                .toList(); // Collecting the results into a new list

        // Printing the filtered and sorted list
        System.out.println("Filtered and Sorted Employees: " + filteredAndSortedEmployees);
    }

    public void convertEmployeeListToSingleStringOfNames(List<Employee> employees) {
        // Using Java Streams to convert the list of employees to a single string of names
        String names = employees.stream()
                .map(Employee::getName) // Extracting names from Employee objects
                .reduce((name1, name2) -> name1 + ", " + name2) // Concatenating names
                .orElse("No Employees"); // Default value if the list is empty

        // Printing the concatenated names
        System.out.println("Concatenated Names: " + names);
    }

    public void findFirstNonRepeatedEmployeeByName(List<Employee> employees) {

        // Using Java Streams to find the first non-repeated employee by name
        Employee firstNonRepeated = employees.stream()
                .filter(e -> employees.stream().filter(emp -> emp.getName().equals(e.getName())).count() == 1)
                .findFirst()
                .orElse(null); // Default value if no such employee exists

        // Printing the first non-repeated employee
        System.out.println("First Non-Repeated Employee: " + firstNonRepeated);

        // Find all non-repeated employees by name
        List<Employee> nonRepeatedEmployees = employees.stream()
                .filter(e -> employees.stream().filter(emp -> emp.getName().equals(e.getName())).count() == 1)
                .toList(); // Collecting the results into a new list
        System.out.println("All Non-Repeated Employees: " + nonRepeatedEmployees);
    }

    public void findEmployeesByNameRepeatTwice(List<Employee> employees) {
        // Using Java Streams to find employees whose names repeat exactly twice
        List<Employee> repeatedEmployees = employees.stream()
                .filter(e -> employees.stream().filter(emp -> emp.getName().equals(e.getName())).count() == 2)
                .toList(); // Collecting the results into a new list

        // Printing the employees whose names repeat exactly twice
        System.out.println("Employees with Names Repeating Twice: " + repeatedEmployees);
    }

    public void findDistinctEmployeesByName(List<Employee> employees) {
        // Using Java Streams to find distinct employees by name
        List<Employee> distinctEmployees = employees.stream()
                .distinct() // This will use the equals method from Employee class
                // TODO : Need to implement HashCode and Equals in Employee class for distinct operation
                .toList(); // Collecting the results into a new list

        List<Employee> distinctEmployeess = new ArrayList<>(
                employees.stream()
                        .collect(Collectors.toMap(
                                e -> e.getName() + "_" + e.getDept(),
                                e -> e,
                                (e1, e2) -> e1
                        ))
                        .values()
        );

        // Printing the distinct employees
        System.out.println("Distinct Employees: " + distinctEmployees);
    }

    public void groupEmployeesByFrequency(List<Employee> employees) {

        // Using Java Streams to group employees by name frequency
        var groupedByFrequency = employees.stream()
                .collect(Collectors.groupingBy(Employee::getName, Collectors.counting()));

        // Printing the grouped employees by frequency
        System.out.println("Grouped Employees by Frequency: " + groupedByFrequency);

        // Java stream to group employees by name and find the first non-repeated employee
        Employee firstNonRepeated = employees.stream()
                .filter(e -> groupedByFrequency.get(e.getName()) == 1)
                .findFirst()
                .orElse(null); // Default value if no such employee exists

        var empGroup = employees.stream().collect(Collectors.groupingBy(Employee::getDept));
        System.out.println("First Non-Repeated Employee: " + empGroup);
    }

    public void sortEmployeesByNameLengthAndNamesNaturalOrder(List<Employee> employees) {
        // Using Java Streams to sort employees by name length and then by name in natural order
        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparingInt((Employee e) -> e.getName().length())
                        .thenComparing(Employee::getName))
                .toList(); // Collecting the results into a new list

        // Printing the sorted list
        System.out.println("Sorted Employees by Name Length and Name: " + sortedEmployees);
    }

    public void groupEmployeesByDepartment(List<Employee> employees) {
        // Using Java Streams to group employees by department
        var groupedByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDept));

        // Printing the grouped employees by department
        System.out.println("Grouped Employees by Department: " + groupedByDepartment);
    }

    public void sortEmployeesByFrequencyOfName(List<Employee> employees) {
        // Using Java Streams to sort employees by frequency of names
        List<Employee> sortedByFrequency = employees.stream()
                .sorted(Comparator.comparingInt((Employee e) ->
                        (int) employees.stream().filter(emp -> emp.getName().equals(e.getName())).count())
                        .reversed()) // Sort by frequency in descending order
                .toList(); // Collecting the results into a new list

        // Printing the sorted list
        System.out.println("Sorted Employees by Frequency of Name: " + sortedByFrequency);
    }

    /**
     * partitioningBy : When you want to partition a collection into two groups based on a predicate.
     * groupingBy : When you want to group a collection by a certain property or attribute.
     * */
    public void partitionEmployeesByGender(List<Employee> employees) {
        // Using Java Streams to partition employees
        var partitionedByGender = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getGender().equalsIgnoreCase("M")));
        System.out.println("Partition by gender: " + partitionedByGender);
    }

    /**
     * It will calculate the most frequent employee by name.
     * */
    public void findMostFrequentEmployeeByName(List<Employee> employees) {
        // Using Java Streams to find the most frequent employee by name
        var mostFrequentEmployee = employees.stream()
                .collect(Collectors.groupingBy(Employee::getName, Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparingLong(entry -> entry.getValue())) // Find the entry with the maximum count
                .map(entry -> new Employee(0, entry.getKey(), 0, null, 0, null, null, 0)) // Create a new Employee object with the name
                .orElse(null); // Default value if no such employee exists

        // Printing the most frequent employee
        System.out.println("Most Frequent Employee by Name: " + mostFrequentEmployee);
    }


    public void findLongestPalindromicString(List<String> strings) {
        // Using Java Streams to find the longest palindromic string
        String longestPalindrome = strings.stream()
                .filter(s -> s.contentEquals(new StringBuilder(s).reverse())) // Check if the string is a palindrome
                .max(Comparator.comparingInt(String::length)) // Find the longest palindrome
                .orElse("No Palindrome Found"); // Default value if no palindrome exists

        // Printing the longest palindromic string
        System.out.println("Longest Palindromic String: " + longestPalindrome);
    }

    public void countWordsIgnoringCases(List<String> words) {
        var wordCounts = words.stream().map(String::toLowerCase)
                .collect(Collectors.groupingBy(e-> e, Collectors.counting()));
        System.out.println("Word Counts Ignoring Cases: " + wordCounts);
    }

    public static void main(String[] args) {

        ArrayListFilterOperation filterOperation = new ArrayListFilterOperation();

        // Sample employee list for testing
        List<Employee> employees = List.of(
                new Employee(1, "Alice", 30, "Engineering", 60000, "F", "New York", 2015),
                new Employee(2, "Bob", 25, "Marketing", 50000, "M", "Los Angeles", 2018),
                new Employee(3, "Charlie", 35, "Engineering", 70000, "M", "Chicago", 2012),
                new Employee(4, "Alice", 28, "Sales", 55000, "F", "Houston", 2019)
        );

//        // Filtering employees by name
//        filterOperation.filterEmployeeListByName(employees, "Alice");
//
//        // Filtering and sorting employees by id
//        filterOperation.filterEmployeeListAndSortById(employees, "E");
//
//        // Converting employee list to a single string of names
//        filterOperation.convertEmployeeListToSingleStringOfNames(employees);

        // Finding first non-repeated employee by name
        filterOperation.sortEmployeesByFrequencyOfName(employees);

        List<String> wordsWithCaseSensitive = List.of("Hello", "world", "hello", "Java", "java", "WORLD", "hello");
        filterOperation.countWordsIgnoringCases(wordsWithCaseSensitive);

    }
}

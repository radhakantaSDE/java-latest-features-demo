package com.learn.app.concepts.collection.arraylist;

import com.learn.app.model.Employee;
import java.util.Comparator;
import java.util.List;

public class ArrayListSortOperation {

  public void sortArrayListByComparator(List<Employee> employees) {

    // Approach-1 : Sort the list using a custom comparator
    employees.sort(new NameIdComparator());

    // Approach-2 : Alternatively, using a lambda expression
    employees.sort(
        (e1, e2) -> {
          // Compare by name
          int nameSeq = e1.getName().compareTo(e2.getName());
          if (nameSeq != 0) {
            return nameSeq; // If names are different, return the comparison result
          }
          return Integer.compare(e1.getId(), e2.getId()); // If names are the same, compare by id
        });

    // Approach-3 : Using method reference for cleaner code
    employees.sort(Comparator.comparing(Employee::getName).thenComparingInt(Employee::getId));
  }
}

class NameIdComparator implements Comparator<Employee> {

  @Override
  public int compare(Employee e1, Employee e2) {
    // Compare by name
    int nameSeq = e1.getName().compareTo(e2.getName());
    if (nameSeq != 0) {
      return nameSeq; // If names are different, return the comparison result
    }
    return Integer.compare(e1.getId(), e2.getId()); // If names are the same, compare by id
  }
}

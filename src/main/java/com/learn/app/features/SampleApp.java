package com.learn.app.features;

import com.learn.app.model.Employee;
import com.learn.app.model.EmployeeDto;
import java.util.Comparator;
import java.util.List;

public class SampleApp {

  /**
   * Your task is to process this list to accomplish the following: 1. Extract the employees who
   * work in the “Engineering” department. 2. From the filtered list, find the top 3 highest-paid
   * employees. 3. Create a new list of EmployeeDTO objects, which only includes the id and name of
   * the employees. Define the EmployeeDTO class with the following attributes: id (int) name
   * (String) List<Employee> employees; List<EmployeeDTO> dto = employees.stream()..;
   */
  public static void main(String[] args) {

    List<Employee> employees = List.of();

    List<EmployeeDto> employeeDtos =
        employees.stream()
            .filter(e -> "Engineering".equals(e.getDept()))
            .sorted(
                new Comparator<Employee>() {
                  @Override
                  public int compare(Employee o1, Employee o2) {
                    return (int) (o2.getSalary() - o1.getSalary());
                  }
                })
            .limit(3)
            .map(e -> EmployeeDto.builder().id(e.getId()).name(e.getName()).build())
            .toList();

    // [3,1,5,2,7,8,-1,6]

  }
}

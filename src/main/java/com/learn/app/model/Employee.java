package com.learn.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Comparable<Employee> {

  private Integer id;
  private String name;
  private Integer age;
  private String dept;
  private double salary;
  private String gender;
  private String city;
  private int yearOfJoining;

  @Override
  public int compareTo(Employee o) {

    int yearOfJoin = Integer.compare(this.yearOfJoining, o.getYearOfJoining());
    if (yearOfJoin != 0) {
      return yearOfJoin; // Compare by year of joining first
    }
    return Integer.compare(this.id, o.getId()); // Then compare by id
  }
}

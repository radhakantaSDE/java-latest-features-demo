package com.learn.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Integer id;
    private String name;
    private Integer age;
    private String dept;
    private double salary;
    private String gender;
    private String city;
    private int yearOfJoining;
}

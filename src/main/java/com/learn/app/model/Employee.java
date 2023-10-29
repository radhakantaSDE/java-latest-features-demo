package com.learn.app.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {

    private Integer id;
    private String name;
    private Integer age;
    private Float salary;
}

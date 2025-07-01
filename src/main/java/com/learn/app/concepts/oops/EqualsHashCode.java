package com.learn.app.concepts.oops;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Builder
@ToString
class HsEmployee implements Cloneable {


    private String name;
    private String id;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        HsEmployee that = (HsEmployee) o;
//        return Objects.equals(id, that.id);
//    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class EqualsHashCode {

    public static void main(String[] args) {

        HsEmployee e1 = HsEmployee.builder().id("100E").build();
        HsEmployee e2 = HsEmployee.builder().id("100E").build();

        Set<HsEmployee> employees = new HashSet<>();
        employees.add(e1);
        employees.add(e2);
        System.out.println(employees);
    }
}

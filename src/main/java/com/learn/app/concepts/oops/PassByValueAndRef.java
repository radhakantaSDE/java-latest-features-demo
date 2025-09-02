package com.learn.app.concepts.oops;

import com.learn.app.model.Employee;

public class PassByValueAndRef {

  public void changePassByValueTest(Employee emp) {

    System.out.println(emp);

    // Though we are assigning emp to a new object but, it will not change that ---- Java is pass by
    // value
    emp = new Employee(100, "NewEmp", 20, "ENGG", 24000, "M", null, 2001);
  }

  public void changePassByRefTest(Employee emp) {

    System.out.println(emp);

    // Here, if we are changing ref. attribute inside incoming object hence, it will impact actual
    // object
    emp.setName("Cow Boy");
  }

  public static void main(String[] args) {

    PassByValueAndRef programmer = new PassByValueAndRef();

    Employee sample1 = new Employee(400, "Monoj", 10, "Engg", 100f, "M", null, 1992);
    System.out.println("Before Change- " + sample1);
    programmer.changePassByRefTest(sample1);
    System.out.println(
        "Though called method assigned a new object to passing object but, still its unchanged : After Change- "
            + sample1);

    // ********* Test Pass object's ref change check *********
    System.out.println("\n");
    Employee sample2 = new Employee(1000, "Sarita", 90, "Sales", 200000f, "M", null, 1992);
    System.out.println("Before Change- " + sample2);
    programmer.changePassByRefTest(sample2);
    System.out.println(
        "Called and changed a attribute ref. in calling method.... Its should change. : After Change- "
            + sample2);
  }
}

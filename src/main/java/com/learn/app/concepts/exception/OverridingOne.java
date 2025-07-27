package com.learn.app.concepts.exception;

    class ExParent {
        public void show() throws Exception {
            System.out.println("Parent");
        }
    }

    class ExChild extends ExParent {
        public void show() throws ArithmeticException {
            System.out.println("Child");
        }
    }


    /**
     * 1. If super class method is throwing an exception,
     *      - then, the overriding method in the subclass can throw the same exception or a subclass of that exception.
     *      - It can be empty as well.
     * 2. If super class method is not throwing any exception,
     *      - then, the overriding method in the subclass cannot throw any checked exception.
     *      - It can throw unchecked exceptions.
     * */
public class OverridingOne {

    public static void main(String[] args) {
        ExParent obj = new ExChild();
        try {
            obj.show();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}

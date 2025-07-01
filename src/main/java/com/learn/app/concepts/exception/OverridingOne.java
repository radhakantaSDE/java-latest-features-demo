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

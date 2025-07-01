package com.learn.app.concepts.inheritance.overriding;

class Sp {
    public String username;
    public void test() {
        System.out.println("test parent");
    }
}

class Cp extends Sp {
    public void show() {
        System.out.println("test");
        super.username = "user";
        super.test();
    }
}

    class Parent {
        public Parent(){System.out.println("ParentConst");}
        {System.out.println("ParentInstBlock");}
    }
    public class ImpKeywords extends Parent {
        public ImpKeywords() {System.out.println("ChildDefaultConst");}
        public ImpKeywords(int a) {System.out.println("ChildParamConst");}
        {System.out.println("ChildInstBlock");}
        public static void main(String[] args) {
            ImpKeywords obj = new ImpKeywords(10);
        }
    }


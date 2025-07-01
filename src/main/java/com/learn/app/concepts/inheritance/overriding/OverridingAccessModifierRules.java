package com.learn.app.concepts.inheritance.overriding;

// 1. Access modifier restrictions (broder or same access-modifiers will be in child overridden method)
class A {
    private void test(){}
}

class B extends A {
    public void test(){}
}

// 2. final method
class Af {
    public final void test(){}
}
class AfC extends Af {
//    public final void test(){}
}

// 3. static method
class Sf {
    public static void show(){
        System.out.println("static parent show");
    }
}
class SfA extends Sf {
    public static void show() {
        System.out.println("static child show");
    }
}

public class OverridingAccessModifierRules {

    public static void main(String[] args) {
        Sf sf = new SfA();
        sf.show();
    }
}

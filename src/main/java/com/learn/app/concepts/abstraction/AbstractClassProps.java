package com.learn.app.concepts.abstraction;

    abstract class AbsClass {
        public AbsClass() {System.out.println("Const");}
        public void show(){System.out.println("Show Method");}
        public abstract void absMethodShow();
        public static void test(){System.out.println("static Method");}
        public final void greet(){System.out.println("final method");}
    }

public class AbstractClassProps {
}

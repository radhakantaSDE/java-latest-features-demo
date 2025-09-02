package com.learn.app.patterns.creational;

/** Usage : When want to create an only and */
public class SingletonPattern {}

// Case-1 : Eager Initialization
class SingletonEager {
  private static final SingletonEager instance = new SingletonEager();

  private SingletonEager() {}

  public static SingletonEager getSingletonInstance() {
    return instance;
  }
}

// Case-2 : Static block init
class SingletonStaticBlock {
  private static SingletonStaticBlock instance;

  private SingletonStaticBlock() {}

  static {
    try {
      instance = new SingletonStaticBlock();
    } catch (Exception ex) {
      System.out.println("Error in instance creation:" + ex);
    }
  }

  public static SingletonStaticBlock getSingletonInstance() {
    return instance;
  }
}

// Case-3 : Lazy Initialization (issue : works only in single-threaded environment)
class SingletonLazyInitialization {
  private static SingletonLazyInitialization instance = null;

  private SingletonLazyInitialization() {}

  public static SingletonLazyInitialization getSingletonInstance() {

    if (instance == null) {
      instance = new SingletonLazyInitialization();
    }
    return instance;
  }
}

// Case-4 : Thread safe
class SingletonThreadSafe {

  private static SingletonThreadSafe instance;

  private SingletonThreadSafe() {}

  public static SingletonThreadSafe getSingletonInstance() {

    if (instance == null) {
      synchronized (SingletonThreadSafe.class) {
        if (instance == null) {
          instance = new SingletonThreadSafe();
        }
      }
    }
    return instance;
  }
}

/**
 * Case-5 : Bill push model (SingletonHolder class will get loaded once getSingletonInstance() will
 * get called) Note: Most widely used pattern
 */
class SingletonBillPush {
  private SingletonBillPush() {}

  private static class SingletonHolder {
    private static final SingletonBillPush INSTANCE = new SingletonBillPush();
  }

  public static SingletonBillPush getSingletonInstance() {
    return SingletonHolder.INSTANCE;
  }
}

/** Case-6 : Enum pattern */
enum SingletonEnum {
  INSTANCE;

  public static void doSomething() {}
}

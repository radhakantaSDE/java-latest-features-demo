package com.learn.app.patterns.creational;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Abstract factory is similar to factory pattern except addition layer to create concrete product
 * */
interface Mobile {
    String model();
    String description();
}

@ToString
@AllArgsConstructor
@NoArgsConstructor
class Iphone implements Mobile {

    private String model;
    private String description;

    @Override
    public String model() {
        return this.model;
    }

    @Override
    public String description() {
        return this.description;
    }
}

@ToString
@AllArgsConstructor
@NoArgsConstructor
class OnePlus implements Mobile {

    private String model;
    private String description;

    @Override
    public String model() {
        return this.model;
    }

    @Override
    public String description() {
        return this.description;
    }
}

// *************** Abstract Factory class *****************
class MobileFactory {
    public static Mobile createMobileFactory(AbstractFactory factory) {
        return factory.createMobileFactory();
    }
}
// *************** Abstract Factory class *****************


interface AbstractFactory {
    Mobile createMobileFactory();
}


@AllArgsConstructor
@NoArgsConstructor
class IPhoneFactory implements AbstractFactory {

    private String model;
    private String description;

    @Override
    public Mobile createMobileFactory() {
        return new Iphone(this.model, this.description);
    }
}

@AllArgsConstructor
@NoArgsConstructor
class OnePlusFactory implements AbstractFactory {

    private String model;
    private String description;

    @Override
    public Mobile createMobileFactory() {
        return new OnePlus(this.model, this.description);
    }
}
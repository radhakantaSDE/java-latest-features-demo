package com.learn.app.patterns.structural;

interface PaymentGateway {
    void processPayment(double amount);
}
class PayPal implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through PayPal.");
    }
}

class Stripe implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through Stripe.");
    }
}

// Abstraction - PaymentProcessor
abstract class PaymentProcessor {
    protected PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public abstract void makePayment(double amount);
}

class SimplePaymentProcessor extends PaymentProcessor {
    public SimplePaymentProcessor(PaymentGateway paymentGateway) {
        super(paymentGateway);
    }

    @Override
    public void makePayment(double amount) {
        paymentGateway.processPayment(amount);
    }
}

class SecurePaymentProcessor extends PaymentProcessor {
    public SecurePaymentProcessor(PaymentGateway paymentGateway) {
        super(paymentGateway);
    }

    @Override
    public void makePayment(double amount) {
        System.out.println("Securing payment...");
        paymentGateway.processPayment(amount);
    }
}


public class BridgePattern {
    public static void main(String[] args) {
        PaymentGateway paypal = new PayPal();
        PaymentGateway stripe = new Stripe();

        PaymentProcessor simplePayment = new SimplePaymentProcessor(paypal);
        simplePayment.makePayment(100.0);

        PaymentProcessor securePayment = new SecurePaymentProcessor(stripe);
        securePayment.makePayment(200.0);
    }
}











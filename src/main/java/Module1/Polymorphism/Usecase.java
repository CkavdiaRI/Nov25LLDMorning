package Module1.Polymorphism;

// Interface for real-world polymorphic use case
interface PaymentMethod {
    void pay(double amount);
}

// Implementations
class CreditCardPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

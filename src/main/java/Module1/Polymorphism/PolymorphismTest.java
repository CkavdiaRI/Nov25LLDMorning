package Module1.Polymorphism;

public class PolymorphismTest {
    public static void main(String[] args) {
        System.out.println("===== Runtime Polymorphism (Method Overriding) =====");

        Animal genericAnimal = new Animal();
        Animal dog = new Dog();
        Animal cat = new Cat();

        System.out.print("Test 1 (Generic Animal): ");
        genericAnimal.speak(); // Expected: Animal speaks

        System.out.print("Test 2 (Dog as Animal): ");
        dog.speak(); // Expected: Dog barks

        System.out.print("Test 3 (Cat as Animal): ");
        cat.speak(); // Expected: Cat meows

        dog.eat();
        //dog.sayHi();

        System.out.println("\n===== Compile-Time Polymorphism (Method Overloading) =====");
        /// Compile-Time Polymorphism (Method Overloading)
        CompileTimePoly calc = new CompileTimePoly();
        System.out.println("Test 4 (add(int, int)): " + calc.add(5, 10)); // Expected: 15
        System.out.println("Test 5 (add(double, double)): " + calc.add(5.5, 4.5)); // Expected: 10.0
        System.out.println("Test 6 (add(int, int, int)): " + calc.add(1, 2, 3)); // Expected: 6

        System.out.println("\n===== Runtime Polymorphism in Real-World Example (Payment Method) =====");
        // Runtime Polymorphism
        PaymentMethod creditCard = new CreditCardPayment();
        PaymentMethod paypal = new PayPalPayment();

        System.out.print("Test 7 (Credit Card): ");
        creditCard.pay(200.0); // Expected: Paid 200.0 using Credit Card.

        System.out.print("Test 8 (PayPal): ");
        paypal.pay(100.0); // Expected: Paid 100.0 using PayPal.


        System.out.println("\n===== Edge Cases =====");

        // Test Case 1: Subclass object referenced by superclass
        Animal a = new Dog();
        //a.speaks(); // ✅ Output: Dog barks (runtime polymorphism works)
        //Method is overridden and resolves to Dog at runtime.


        // Test Case 2: Calling subclass-specific method from superclass reference
        Animal b = new Dog();
        //b.wagTail(); // ❌ Compile error: wagTail() not in Animal
        //❌ Compile-time error because wagTail() is not defined in Animal, even though object is Dog.

        // Test Case 3: Downcasting to access subclass methods
//        Animal c = new Dog();
//        if (c instanceof Dog) {
//            ((Dog) c).wagTail(); // ✅ Output: Dog wags tail
//        }
        //✅ Downcasting allows access to subclass-specific methods safely.

        //Test Case 4: Invalid downcasting
//        Animal d = new Cat();
//        (d).wagTail(); // ❌ Runtime error: ClassCastException
        //❌ Throws ClassCastException because actual object is Cat, not Dog.

        // Test Case 5: Null reference call
//        Animal f = null;
//        f.speak(); // ❌ Throws NullPointerException
        //❌ Runtime exception — method cannot be called on null reference.

        //Test Case 6: Overridden method called even with upcasting
        Dog dog1 = new Dog();
        Animal a1 = dog1;
        a1.speak(); // ✅ Output: Dog barks
        //✅ Even though reference is Animal, overridden method in Dog is called.

        //Test Case 7: Overriding a private method (doesn't work)
//        Animal obj = new Dog();
//        obj.sayHi(); // ❌ Compile error: sayHi() has private access

    }
}

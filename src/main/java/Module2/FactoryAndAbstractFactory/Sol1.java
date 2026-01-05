package Module2.FactoryAndAbstractFactory;

class VegBurger1 {
    public void prepare() {
        System.out.println("Preparing Veg Burger");
    }
}

class CheeseBurger1 {
    public void prepare() {
        System.out.println("Preparing Cheese Burger");
    }
}

public class Sol1 {
    public static void main(String[] args) {
        String burgerType = "Cheese";

        if (burgerType.equals("Veg")) {
            VegBurger1 vegBurger = new VegBurger1();
            vegBurger.prepare();
        } else if (burgerType.equals("Cheese")) {
            CheeseBurger1 cheeseBurger = new CheeseBurger1();
            cheeseBurger.prepare();
        } else {
            System.out.println("Unknown Burger Type");
        }
    }
}

// Pros :
// 1. Simple and straightforward implementation.


// Cons :
// 1. Adding a new burger type requires modifying the existing code, which violates the Open/Closed Principle.
// 2. Many if else statements can lead to code that is hard to maintain and extend & read.
// 3. Client code is tightly coupled with the creation logic of burgers
// 4. Client will need to modify the code to add new burger types, which is not ideal for scalability.
// 5. Hard to maintain if object creation is being done in multiple places.